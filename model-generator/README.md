# model-generator

Generate **Mongoose** + **Zod** (+ a clean JSON Schema) models from a *composed*
Battery Passport JSON Schema.

Self-contained — no runtime dependencies, and **not** related to the obsolete
`battery-passport-model` package. Input is the composed schema produced by
[`../BatteryPass/make-composed-schema.sh`](../BatteryPass/README.md), i.e.
`../BatteryPass/composed-schema<version>.json` — a single valid draft-07 schema
whose `$ref`s resolve against its own `$defs`.

```
.ttl ──(samm CLI)──► <Aspect>.schema ──(make-composed-schema.sh)──► composed-schema<v>.json ──(model-generator)──► zod.ts + mongoose.ts
```

---

## Setup

```bash
cd model-generator
npm install
```

`zod` and `mongoose` are optional peer deps — install them only in the project
that consumes the generated models.

---

## Usage

```bash
# by version — resolves ../BatteryPass/composed-schema<version>.json automatically
npm run generate -- --version 1.3
npm run generate -- --version 1.2

# or point at any composed schema explicitly
npm run generate -- --schema /path/to/composed-schema1.3.json --name BatteryPassport --out ./out
```

| Flag | Default | Description |
|---|---|---|
| `--version` | — | `1.2` / `1.3`; resolves `../BatteryPass/composed-schema<version>.json` |
| `--schema` | (from `--version`) | explicit path to a composed schema |
| `--name` | `BatteryPassport` | model / type name used in the output |
| `--out` | `./generated/<version>` | output directory |

**Output** (`zod.ts`, `mongoose.ts`, `json-schema.json`, `index.ts`):

```ts
import { batteryPassportSchema, type BatteryPassport } from './generated/1.3/zod.js';
batteryPassportSchema.parse(passportDoc);          // runtime validation

import { BatteryPassport } from './generated/1.3/mongoose.js';
await BatteryPassport.create(passportDoc);          // MongoDB persistence
```

The models are **nested** (aspects → fields → arrays of sub-objects), preserve
**enums** (`z.enum` / Mongoose `enum`), mark **required** fields, and carry the
schema **descriptions** as JSDoc.

---

## How it works

`src/convert.ts` resolves the composed schema (`$ref` → `$defs`, `allOf`, arrays,
enums, `format: date-time/uri`) into a small normalized IR, then emits Zod,
Mongoose, and a self-contained JSON Schema from it. `src/cli.ts` is the runner.

Build a publishable JS/types bundle with `npm run build` (→ `dist/`).
