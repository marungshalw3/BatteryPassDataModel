# Generating SAMM artifacts — `convert.sh`

`convert.sh` walks this directory tree, finds every aspect's `*.ttl` (the
hand-authored SAMM source of truth), and regenerates **all derived formats**
into a `gen/` folder beside each `.ttl` — JSON Schema, SQL, OpenAPI (JSON),
JSON-LD, AAS, sample payload, HTML docs, SVG diagram, and Java classes.

It is a macOS/Linux bash port of the original Windows `ConvertAspect.ps1`,
calling the **Eclipse ESMF SAMM CLI** under the hood.

---

## Prerequisites (macOS)

### 1. Java (JRE 17+)

The SAMM CLI is a Java tool. Install a JDK — Eclipse Temurin works well:

```bash
brew install --cask temurin
```

Verify the JVM is discoverable (the `/usr/bin/java` stub alone is **not**
enough — you need a real runtime):

```bash
/usr/libexec/java_home -V      # should list at least one JDK
"$(/usr/libexec/java_home)/bin/java" -version
```

`convert.sh` locates Java automatically via `/usr/libexec/java_home`. To force a
specific one, export `JAVA=/path/to/bin/java`.

### 2. The SAMM CLI jar

The jar (~178 MB) is **not committed to git**. Install it into this folder with
the bundled helper:

```bash
cd BatteryPass
./download-samm-cli.sh            # fetches samm-cli.jar (v2.14.3) here
./download-samm-cli.sh 2.14.3     # or pin a specific esmf-sdk version
```

Or download it manually from the
[esmf-sdk releases](https://github.com/eclipse-esmf/esmf-sdk/releases) and place
it next to the scripts as `samm-cli.jar`:

```bash
curl -L -o samm-cli.jar \
  https://github.com/eclipse-esmf/esmf-sdk/releases/download/v2.14.3/samm-cli-2.14.3.jar
```

> It's listed in `.gitignore`, so it stays out of git. The scripts look for it
> next to themselves, then one directory up. Override with
> `SAMM_JAR=/path/to/samm-cli.jar` if you store it elsewhere.

### 3. Bash

The stock macOS bash (3.2) is fine — the script is written to be compatible
with it.

---

## Usage

Run from this `BatteryPass/` folder:

```bash
./convert.sh                            # regenerate EVERYTHING under BatteryPass/
./convert.sh io.BatteryPass.Labels      # one aspect, all its versions
./convert.sh io.BatteryPass.Labels/1.2.0   # one aspect, one version
./convert.sh . -- schema sql            # only JSON Schema + SQL, everywhere
./convert.sh . --                       # only OpenAPI, everywhere
```

**Arguments**

| Position | Meaning | Default |
|---|---|---|
| `ROOT_DIR` | directory searched recursively for `*.ttl` | the script's own folder |
| `-- FORMAT ...` | restrict to these formats (after `--`) | all formats below |

**Formats:** `html java json jsonld png schema svg aas sql` + `openapi`
(always run). Pass `--` with no formats to run **openapi only**.

**Environment overrides**

| Var | Purpose | Default |
|---|---|---|
| `SAMM_JAR` | path to the CLI jar | `./samm-cli.jar`, then `../samm-cli.jar` |
| `JAVA` | path to the `java` binary | from `/usr/libexec/java_home` |
| `OPENAPI_BASE` | server base URL in the OpenAPI spec | `https://thebatterypass.io` |

---

## Output

For each `io.BatteryPass.<Aspect>/<version>/<Aspect>.ttl`, artifacts are written
to that version's `gen/` folder:

```
io.BatteryPass.MaterialComposition/1.2.0/
├── MaterialComposition.ttl          # source (do not regenerate)
└── gen/
    ├── MaterialComposition.schema        # JSON Schema (UTF-8)
    ├── MaterialComposition.sql           # SQL DDL (Spark/Databricks dialect)
    ├── MaterialComposition.openapi.json  # OpenAPI 3.0.3 (JSON)
    ├── MaterialComposition.json          # sample payload
    ├── MaterialComposition.jsonld        # JSON-LD
    ├── MaterialComposition.aas           # Asset Administration Shell
    ├── MaterialComposition.svg           # class diagram
    ├── MaterialComposition.html          # documentation
    └── java/io/BatteryPass/...           # generated Java classes
```

On finish it prints a tally: `Done. <ok> ok, <fail> failed (of <total>) …`.

---

## Cleaning generated output — `clean.sh`

`gen/` folders are fully reproducible from the `.ttl` sources, so they can be
wiped at any time. `clean.sh` removes them recursively (and never touches
`genold/` backups):

```bash
./clean.sh                       # remove every gen/ under BatteryPass/
./clean.sh -n                    # dry run — list what would be removed
./clean.sh io.BatteryPass.Labels # only under one aspect
```

Regenerate afterwards with `./convert.sh`.

---

## Building a passport sample — `make-passport.sh`

Concatenates the seven aspect **sample payloads** for a version into one
passport document, shaped `{ "<Aspect>": <aspect sample json>, ... }`:

```bash
./make-passport.sh 1.3                 # -> passport1.3.json
./make-passport.sh 1.2                 # -> passport1.2.json (Performance resolves to 1.2.1)
./make-passport.sh 1.3 /tmp/p.json     # custom output path
```

Minor versions (`1.2`, `1.3`) resolve to the highest matching patch per aspect.
It reads whichever sample the `gen/` folder has — `<base>.json` (from
`convert.sh`) or `<base>-payload.json` (consortium bundle) — and handles
UTF-8/UTF-16 transparently. Run `convert.sh` first if a version's samples are
missing.

---

## Bundling schemas — `make-schema.sh`

Like `make-passport.sh`, but bundles the seven aspect **JSON Schemas** (not
sample payloads) into `schema<version>.json`, shaped `{ "<Aspect>": <JSON
Schema>, ... }`. This is the input for an **exact** structural diff (types +
required/optional, no sample noise).

```bash
./make-schema.sh 1.2     # -> schema1.2.json
./make-schema.sh 1.3     # -> schema1.3.json
```

It prefers `<base>.schema` (from `convert.sh`) over the consortium
`<base>-schema.json` bundle. For a true diff, regenerate both versions with the
same CLI first (`./convert.sh . -- schema`) — the shipped consortium gen can be
stale relative to the current `.ttl`.

---

## Composed (validatable) schema — `make-composed-schema.sh`

`make-schema.sh` produces a *bundle* (`{ "<Aspect>": <schema> }`) whose internal
`$ref`s dangle once nested — fine for diffing, **not** valid for validation.
`make-composed-schema.sh` produces ONE **valid, self-contained draft-07 schema**
that validates a whole passport document (the shape from `make-passport.sh`):

```bash
./make-composed-schema.sh 1.3    # -> composed-schema1.3.json
./make-composed-schema.sh 1.2    # -> composed-schema1.2.json
```

It relocates every aspect's `components/schemas` into a shared root `$defs`
(namespaced `<Aspect>__<Name>`), rewrites the `$ref` pointers, and normalizes
SAMM's draft-04 constructs (boolean `exclusiveMinimum/Maximum`) to draft-07. The
script self-checks validity and that no `$ref` dangles. Example — validate a
passport with any draft-07 validator:

```python
from jsonschema import Draft7Validator
import json
schema = json.load(open("composed-schema1.3.json"))
doc    = json.load(open("passport1.3.json"))
errs   = list(Draft7Validator(schema).iter_errors(doc))   # [] = valid
```

---

## Visualizing attribute changes — `attribute-diff.html`

A self-contained page that loads two bundles and shows the changes
(added / removed / modified) grouped by aspect. The **Source** selector picks:

- **schemas** (`schema<v>.json`) — **recommended**: exact diff of structure,
  type, and required ↔ optional.
- **samples** (`passport<v>.json`) — structural diff of sample payloads (handy,
  but optional fields present in one sample only show as add/remove).

```bash
# build bundles + regenerate schemas with one CLI for an apples-to-apples diff
./convert.sh . -- schema
./make-schema.sh 1.2 && ./make-schema.sh 1.3
./make-passport.sh 1.2 && ./make-passport.sh 1.3   # (optional, for samples mode)
# serve (browsers block file:// fetches) and open the page
python3 -m http.server 8777
# open http://localhost:8777/attribute-diff.html → Source=schemas, From=1.2, To=1.3 → Compare
```

You can also pick two JSON files manually (no server needed); the page
auto-detects whether they are schemas or samples. Use "show unchanged" and the
path filter to explore. In schema mode, modified rows show e.g.
`string → array` and `optional → required`.

---

## Notes & gotchas

- **`java` format** is emitted as a package tree via `--output-directory`
  (not a single file), so it lands under `gen/java/…`.
- **OpenAPI is generated as JSON** (`--json`). Without that flag the SAMM CLI
  emits YAML — which is why a plain run elsewhere can produce a `.json` file
  that isn't actually JSON.
- **JVM warnings** like `WARNING: A restricted method … has been called` are
  harmless (JDK native-access notices) and are suppressed by the script.
- **CarbonFootprint 1.0.0** currently fails every format: its TTL declares the
  legacy namespace `urn:samm:BatteryPass:1.0.0#`, which current SAMM rejects
  (namespaces must be dotted, e.g. `io.BatteryPass.CarbonFootprint`). This is a
  source-model issue, not a script issue. All other aspects/versions generate
  cleanly.
- The `.ttl` files are **consortium source**. Local fixes (e.g. a unit
  case-mismatch correction) are overwritten if you re-pull upstream — consider
  upstreaming such fixes.
