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
