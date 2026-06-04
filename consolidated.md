# Consolidated Guide — Generating Models for a New DPP Version

How to go from a **new/updated DPP Excel data-attribute sheet** to generated
**Zod + Mongoose** (and JSON Schema) models for that version.

```
new DPP Excel
   │  (1) understand what changed  →  transition plan
   ▼
SAMM .ttl aspect models  (hand-authored, one per aspect, per version)
   │  (samm CLI via convert.sh)
   ▼
gen/<Aspect>.schema , .json , .sql , …
   │  (make-composed-schema.sh)
   ▼
composed-schema<version>.json   ← one valid draft-07 schema
   │  (model-generator)
   ▼
zod.ts  +  mongoose.ts  +  json-schema.json
```

> **Key principle:** the `.ttl` SAMM models are the **source of truth**, not the
> Excel. The Excel is the *guidance* a human uses to evolve the TTLs. Everything
> downstream (schemas, models) is generated.

---

## 0. Prerequisites (one-time setup)

| Tool | Why | Install |
|---|---|---|
| **JDK 17+** (Temurin) | runs the SAMM CLI | `brew install --cask temurin` |
| **SAMM CLI jar** | TTL → schema/json/sql/… | `cd BatteryPass && ./download-samm-cli.sh` |
| **python3** | the `make-*.sh` bundlers | preinstalled on macOS |
| **jsonschema** (python) | validate composed schema | `pip3 install jsonschema` |
| **Node 18+ / npm** | the model generator | `brew install node` |

```bash
# verify
"$(/usr/libexec/java_home)/bin/java" -jar BatteryPass/samm-cli.jar --version
node --version
```

One-time: `cd model-generator && npm install`

---

## Folder map

```
BatteryPassDataModel/
├── docs/<version>/                       # the DPP Excel sheets + DIN spec live here
├── BatteryPass/
│   ├── io.BatteryPass.<Aspect>/<ver>/    # one SAMM .ttl per aspect, per version
│   │   ├── <Aspect>.ttl                  #   ← hand-authored source of truth
│   │   └── gen/                          #   ← generated (convert.sh)
│   ├── samm-cli.jar                      # downloaded, git-ignored
│   ├── convert.sh                        # .ttl → all formats (recursive)
│   ├── clean.sh                          # remove gen/ recursively
│   ├── make-passport.sh                  # bundle sample payloads
│   ├── make-schema.sh                    # bundle per-aspect schemas (for diffing)
│   ├── make-composed-schema.sh           # ONE valid composed schema (for models)
│   └── attribute-diff.html               # visualize added/removed/modified
└── model-generator/                      # composed schema → Zod + Mongoose
```

The **seven aspects** and their `sector_payload` keys:

| Aspect folder | Key |
|---|---|
| `io.BatteryPass.GeneralProductInformation` | `general_information` |
| `io.BatteryPass.CarbonFootprint` | `carbon_footprint` |
| `io.BatteryPass.MaterialComposition` | `material_composition` |
| `io.BatteryPass.Circularity` | `circularity` |
| `io.BatteryPass.Performance` | `performance` |
| `io.BatteryPass.SupplyChainDueDiligence` | `supply_chain_due_diligence` |
| `io.BatteryPass.Labels` | `labels` |

---

## TL;DR (when the TTLs for the new version already exist)

```bash
cd BatteryPass
./convert.sh . -- schema                 # regenerate <Aspect>.schema with one CLI
./make-composed-schema.sh <version>      # -> composed-schema<version>.json
cd ../model-generator
npm run generate -- --version <version>  # -> generated/<version>/{zod,mongoose,json-schema}.ts
```

The full first-time-for-a-version process is below.

---

## Step-by-step — new version (example: `1.4`)

### 1. Add the Excel and understand what changed

Drop the new sheet in `docs/1.4/`. Produce a **transition plan** by diffing the
new version against the previous one — added / removed / renamed / type-changed
attributes, grouped by aspect. (See `docs/1.3/TRANSITION_PLAN_v1.2_to_v1.3.md`
for the format.) Get the rename/consolidation mappings reviewed before authoring.

> Most "added/removed" pairs are usually **renames** — capture them as a mapping
> so existing data can migrate, and so you don't model the same field twice.

### 2. Author the SAMM `.ttl` aspect models for the new version

For each of the 7 aspects, create `io.BatteryPass.<Aspect>/1.4.0/<Aspect>.ttl`:

```bash
cd BatteryPass
for d in io.BatteryPass.*; do
  base=$(ls "$d/1.2.0"/*.ttl 2>/dev/null | head -1)         # or 1.3.0, the prior version
  [ -n "$base" ] || continue
  mkdir -p "$d/1.4.0"
  sed 's/:1\.2\.0#/:1.4.0#/g' "$base" > "$d/1.4.0/$(basename "$base")"
done
```

Then **edit each new `.ttl`** to apply the transition-plan changes (add new
`samm:Property` + `samm:Characteristic`/`samm:Entity` definitions, rename,
adjust types). Notes from experience:

- Only the `@prefix : <urn:samm:…:1.4.0#>` line carries the version — bumping it
  is the whole "copy".
- Many Excel "type changes" are **already** satisfied by the prior TTL (it often
  uses richer types/nesting than the flat sheet) — verify before changing.
- Performance is versioned independently; base it on its latest patch (e.g.
  `1.2.1`).
- Watch for case/spelling bugs in custom units (e.g. CarbonFootprint's
  `kilogramperkilowatthour`) — the reference and definition must match exactly.

### 3. Generate artifacts from the TTLs

```bash
cd BatteryPass
./convert.sh . -- schema        # fast: just JSON Schemas (add more formats by listing them)
# or full set: ./convert.sh io.BatteryPass.MaterialComposition/1.4.0
```

Every aspect must report **0 errors**. Fix any TTL validation errors before
proceeding (the CLI prints the offending element).

### 4. Build the composed schema

```bash
./make-composed-schema.sh 1.4   # -> composed-schema1.4.json
```

This produces **one valid, self-contained draft-07 schema** (refs relocated into
`$defs`, draft-04 constructs normalized). It self-checks: look for
`valid draft-07 schema` and `dangling $refs: (none)`.

### 5. Generate the Zod + Mongoose models

```bash
cd ../model-generator
npm run generate -- --version 1.4
# -> generated/1.4/zod.ts , mongoose.ts , json-schema.json , index.ts
```

Use them:

```ts
import { batteryPassportSchema } from './generated/1.4/zod.js';
batteryPassportSchema.parse(doc);                 // runtime validation

import { BatteryPassport } from './generated/1.4/mongoose.js';
await BatteryPassport.create(doc);                // MongoDB persistence
```

### 6. (Optional) Visualize the change vs the previous version

```bash
cd ../BatteryPass
./make-schema.sh 1.3 && ./make-schema.sh 1.4     # per-aspect schema bundles
python3 -m http.server 8777
# open http://localhost:8777/attribute-diff.html → Source=schemas, From=1.3, To=1.4 → Compare
```

### 7. (Optional) Validate a sample against the composed schema

```bash
cd BatteryPass
./make-passport.sh 1.4                            # sample payload bundle
python3 - <<'PY'
import json
from jsonschema import Draft7Validator
s = json.load(open('composed-schema1.4.json'))
d = json.load(open('passport1.4.json'))
errs = list(Draft7Validator(s).iter_errors(d))
print('VALID' if not errs else f'{len(errs)} error(s)')
PY
```

---

## Gotchas & tips

- **Regenerate both versions with one CLI before diffing.** The consortium-shipped
  `gen/` can be **stale** relative to the current `.ttl` (e.g. an old payload said
  `extinguishingAgent`, the TTL says `extinguishingAgents`). `convert.sh . -- schema`
  writes fresh `<Aspect>.schema` so a 1.x↔1.y diff is apples-to-apples.
- **Bundle vs composed schema.** `make-schema.sh` → `schema<v>.json` is a *bundle*
  for diffing (its internal `$ref`s dangle once nested — **not** valid for
  validation). `make-composed-schema.sh` → `composed-schema<v>.json` is the
  **valid** schema; feed that to `model-generator`.
- **Draft version.** SAMM emits draft-04 (`components/schemas`, boolean
  `exclusiveMinimum/Maximum`); `make-composed-schema.sh` normalizes these to
  draft-07 automatically.
- **Versions coexist.** New versions are additive — old `1.x.0` folders and any
  passports authored against them stay valid. Never edit a shipped version's TTL
  in place; add a new `<version>/` folder.
- **`.ttl` is consortium source.** If you fix a bug in a shipped TTL, it can be
  overwritten on the next upstream pull — consider upstreaming the fix.

---

## Quick reference — scripts

| Script | Location | Purpose |
|---|---|---|
| `download-samm-cli.sh` | `BatteryPass/` | install the SAMM CLI jar |
| `convert.sh` | `BatteryPass/` | `.ttl` → all formats into `gen/` (recursive) |
| `clean.sh` | `BatteryPass/` | remove `gen/` folders recursively |
| `make-passport.sh` | `BatteryPass/` | bundle sample payloads → `passport<v>.json` |
| `make-schema.sh` | `BatteryPass/` | bundle per-aspect schemas → `schema<v>.json` (diff) |
| `make-composed-schema.sh` | `BatteryPass/` | **valid** composed schema → `composed-schema<v>.json` |
| `attribute-diff.html` | `BatteryPass/` | visualize added/removed/modified |
| `npm run generate` | `model-generator/` | composed schema → Zod + Mongoose |
