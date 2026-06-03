# Transition Plan — Battery Pass Data Model v1.2 → v1.3

> Status: **DRAFT — TTL authoring GATED on rename-map review (§4–§5)**
>
> **Decisions locked:** (2) new identifier/info objects modelled using SAMM +
> DIN DKE Spec 99100 judgement; (3) all aspects → `1.3.0`, **Performance based on
> `1.2.1`** (others on `1.2.0`); (4) CarbonFootprint `kilogramperkilowatthour`
> unit case-fix **included** in 1.3.0.
> **Pending:** (1) user to review/correct the rename & consolidation mappings in
> §4–§5 before any `.ttl` is authored.
> Scope: evolve the SAMM/TTL aspect models from `1.2.0` to `1.3.0`, driven by
> `docs/1.3/2026_BatteryPass-Ready_DataAttributeLongList_v1.3.xlsx`.
> Authoring note: **upstream has NOT published v1.3 TTLs** — the `v1.3` branch and
> `docs/1.3` contain only the v1.3 Excel longlist + DIN DKE Spec PDF. We therefore
> author the v1.3 TTLs ourselves by evolving the existing `1.2.0` models.

---

## 1. Goal

Produce `1.3.0` SAMM aspect models (`.ttl`) for all seven aspects, regenerate
their `gen/` artifacts, and refresh the downstream Mongoose/Zod/JSON-Schema
package — **without breaking existing v1.2 passports** (versions coexist).

This document is the **plan only**. No `.ttl` files are created until it is
approved.

---

## 2. Change summary (from the Excel longlist diff)

| Metric | Count |
|---|---|
| v1.2 attributes | 93 |
| v1.3 attributes | 100 |
| Net new (truly new) | 7 |
| Renamed / restructured | 8 (→ appear as add+remove) |
| Type / constraint changes | 12 |
| Aspect categories | **unchanged** (same 7) |

The 7 aspect groupings are identical between v1.2 and v1.3, so **no aspect needs
to be added, removed, or re-partitioned** — all changes are within aspects.

---

## 3. Per-aspect impact

| Aspect (folder) | Impact | What changes |
|---|---|---|
| **GeneralProductInformation** | 🔴 Major | DPP-identity overhaul (see §4) |
| **Labels** | 🟠 Moderate | Document fields `string → URI`; Carbon footprint label becomes mandatory |
| **Circularity** | 🟠 Moderate | Pre/Post-consumer **lead** share consolidated into single "Recycled lead share" |
| **CarbonFootprint** | 🟡 Minor | Rename "main product production/manufacturing" → "main product production"; drop "general battery and manufacturer information"; (also carry the `kilogramperkilowatthour` unit case-fix) |
| **SupplyChainDueDiligence** | 🟡 Minor | "Information of due diligence report" `string → URI` |
| **Performance** | 🟡 Minor | Min/Max/Nominal voltage `integer → decimal`; "Information on accidents" `string → URI` |
| **MaterialComposition** | 🟢 Minimal | v1.2 TTL already models materials & hazardous substances as `samm-c:List` of entities; Excel `string → array` only confirms existing structure |

---

## 4. GeneralProductInformation — the major change

v1.3 reworks identity around the **Digital Product Passport** model. This is the
bulk of the work.

### Net-new properties (7)
- `DPP Schema version`
- `DPP Status`
- `DPP Granularity`
- `Date-time of latest update of DPP`
- `Battery model identifier`
- `Battery serial number`
- `Unique facility identifier`

### Renames / splits (existing data maps forward — no loss)
| v1.2 attribute | v1.3 attribute(s) |
|---|---|
| Battery passport identifier | **Unique battery passport identifier / unique DPP identifier** |
| Battery identifier | **Unique battery identifier / unique product identifier** |
| Operator identifier and information | **Unique economic operator identifier** + **Economic operator information** |
| Manufacturer identifier and information | **Unique manufacturer identifier** + **Manufacturer information** |

> Model-vs-individual granularity is now explicit: `Battery model identifier`
> (model level) vs `Battery serial number` + the unique battery identifier
> (individual level), gated by the new `DPP Granularity` field.

---

## 5. Other rename / consolidation map

| Aspect | v1.2 | v1.3 |
|---|---|---|
| CarbonFootprint | Contribution of main product production/manufacturing lifecycle stage | Contribution of main product production lifecycle stage |
| CarbonFootprint | General battery and manufacturer information | *(dropped)* |
| Circularity | Pre-consumer recycled lead share **+** Post-consumer recycled lead share | **Recycled lead share** *(consolidated)* |

---

## 6. Type / constraint changes (12)

| Aspect | Attribute | Change |
|---|---|---|
| Labels | Separate collection symbol | string → **URI** |
| Labels | Symbols for cadmium and lead | string → **URI** |
| Labels | Carbon footprint label | string → **URI**, optional → **required** |
| Labels | EU declaration of conformity | string → **URI** |
| Labels | Results of test reports proving compliance | string → **URI** |
| SupplyChainDueDiligence | Information of due diligence report | string → **URI** |
| Performance | Information on accidents | string → **URI** |
| Performance | Minimum / Maximum / Nominal voltage | integer → **decimal** |
| MaterialComposition | Materials used in cathode, anode and electrolyte | string → **array** *(already a List in TTL)* |
| MaterialComposition | Hazardous substances | string → **array** *(already a List in TTL)* |

The `string → URI` changes map to the SAMM `samm-c:ResourcePath` characteristic
(already used elsewhere). `integer → decimal` maps `xsd:integer → xsd:double`.

---

## 7. Versioning strategy

- Create new folders `io.BatteryPass.<Aspect>/1.3.0/<Aspect>.ttl` for all 7
  aspects. **Leave `1.2.0` untouched** — both versions coexist.
- Namespace URN per aspect: `urn:samm:io.BatteryPass.<Aspect>:1.3.0#`.
- Bump `samm:` meta-model prefixes to the current release (as used in 1.2.0).
- Add a `1.3.0` row per aspect to `RELEASE_NOTES.md` and the README aspect table.
- **Decided:** `Performance` 1.3.0 is based on its `1.2.1` patch; all other
  aspects on `1.2.0`. Folder/namespace label: `1.3.0`.

---

## 8. Migration of stored passports

- The platform dispatches validation/rendering on `(sector, version)`, so
  **existing v1.2 passports stay valid** under the `1.2.0` schema; only new
  passports target `1.3.0`. No forced migration.
- For any opt-in backfill of v1.2 → v1.3 documents, the rename map in §4–§5 is
  the field-mapping spec. Consolidations (lead share) and splits (operator /
  manufacturer) need a small transform; net-new fields default to empty/unknown.
- Net-new DPP metadata (`DPP Status`, `DPP Granularity`, schema version,
  timestamp) is populated by the issuing system, not migrated.

---

## 9. Work plan (after approval)

1. **GeneralProductInformation 1.3.0** — author first (largest); model new DPP
   identity properties + entities, apply renames/splits.
2. **Labels, Circularity 1.3.0** — moderate; type changes + lead-share consolidation.
3. **CarbonFootprint, SupplyChain, Performance 1.3.0** — minor; renames + type changes; carry CF unit case-fix.
4. **MaterialComposition 1.3.0** — copy 1.2.0, bump version, confirm arrays.
5. **Validate & generate** — `./convert.sh` per aspect; ensure 0 errors.
6. **Downstream refresh** — regenerate the `battery-passport-model` Mongoose/Zod/JSON-Schema for `battery/eu/v1.3` and align the LW3 `sector_payload` mapping (categories unchanged, so low risk).
7. **Review** — diff generated JSON Schemas 1.2.0 vs 1.3.0 to confirm only intended deltas.

---

## 10. Decisions

1. **Rename mappings** (§4–§5) — ⏳ **PENDING: user to review/correct** before TTL authoring. This is the only blocker.
2. **Sub-structure of new identifier objects** — ✅ model per SAMM conventions + DIN DKE Spec 99100 (our judgement).
3. **Performance base version** — ✅ `1.3.0` from `1.2.1`; other aspects from `1.2.0`.
4. **CarbonFootprint unit fix** — ✅ include the `kilogramperkilowatthour` case correction in 1.3.0.
5. **Folder/version label** — ✅ `1.3.0` (consortium scheme).
