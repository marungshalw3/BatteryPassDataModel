CREATE TABLE IF NOT EXISTS carbon_footprint_for_batteries (
  battery_carbon_footprint DOUBLE NOT NULL COMMENT 'The carbon footprint of the battery, calculated as kg of carbon dioxide equivalent per one kWh of the total energy provided by the battery over its expected service life, as declared in the Carbon Footprint Declaration.\nDIN DKE Spec 99100 chapter reference: 6.3.2',
  carbon_footprint_per_lifecycle_stage__lifecycle_stage STRING NOT NULL COMMENT 'The description of the life cycle stage ',
  carbon_footprint_per_lifecycle_stage__carbon_footprint DOUBLE NOT NULL COMMENT 'Carbon footprint of the individual lifecycle stage',
  carbon_footprint_performance_class STRING NOT NULL COMMENT 'The carbon footprint performance class that the relevant battery model per manufacturing plant corresponds to.\n\nDIN DKE Spec 99100 chapter reference:  6.3.7',
  carbon_footprint_study STRING NOT NULL COMMENT 'A web link to get access to a public version of the study supporting the carbon footprint values.\n\nDIN DKE Spec 99100 chapter reference:  6.3.8',
  absolute_carbon_footprint DOUBLE COMMENT 'As a non-mandatory data attribute, the battery passport should include the battery carbon footprint in absolute terms.\n\nThe absolute battery carbon footprint should be calculated as kilograms of carbon dioxide equivalent, without reference to the functional unit as prescribed by the battery regulation.\n\nDIN DKE Spec 99100 chapter reference: 6.3.10'
)
COMMENT 'The battery passport must contain carbon footprint per functional unit of the battery as declared in the battery carbon footprint declaration in accordance with the entry into force of the implementing acts on the format of declaration. Reference: REGULATION (EU) 2023/1542 aka EU Battery Regulation'
TBLPROPERTIES ('x-samm-aspect-model-urn'='urn:samm:io.BatteryPass.CarbonFootprint:1.3.0#CarbonFootprintForBatteries');
