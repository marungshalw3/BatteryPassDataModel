# Changelog
All notable changes to the battery passport data model will be documented in this file.

## [1.3.0] - 2026-06-03
Aligned the SAMM aspect models with the v1.3 data-attribute longlist
(`docs/1.3/2026_BatteryPass-Ready_DataAttributeLongList_v1.3.xlsx`). See
`docs/1.3/TRANSITION_PLAN_v1.2_to_v1.3.md` for the full mapping. All seven
aspects now have a `1.3.0` version; the `1.2.0` models are retained unchanged.
### New
- **GeneralProductInformation**: added Digital Product Passport identity &
  metadata — `batteryModelIdentifier`, `batterySerialNumber`, `dppSchemaVersion`,
  `dppStatus`, `dppGranularity`, `dppLastUpdate`, `facilityIdentifier`.
### Changed
- **CarbonFootprint**: fixed the `kilogramperkilowatthour` unit definition
  (case mismatch with its references) so the model validates and generates.
- **Performance**: based on `1.2.1`.
### Notes
- Other aspects (Labels, Circularity, MaterialComposition, SupplyChain,
  Performance) were version-bumped only — the `1.2.0` TTLs already modelled the
  v1.3 Excel changes (URI types, arrays/lists, generic recycled-content,
  decimal voltages).

## [1.2.0] - 2025-10-23
 - Lincense consistently updated to Creative Commons Attribution 4.0 International (CC-BY-4.0) license. See the [LICENSE](https://creativecommons.org/licenses/by/4.0/legalcode) file for more details. 

## [1.2.0] - 2025-01-14
### Updated
- Updated battery passport data model according to: 
  - ### DIN DKE Spec 99100:2025-02 "Requirements for data attributes of the battery passport"
- Link to the DIN Spec: https://www.dinmedia.de/en/technical-rule/din-dke-spec-99100/385692321
  

## [1.0.0] - 2024-05-28
### New
- Initial battery passport data model




