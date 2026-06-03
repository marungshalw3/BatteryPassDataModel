CREATE TABLE IF NOT EXISTS material_composition (
  battery_chemistry__short_name STRING NOT NULL,
  battery_chemistry__clear_name STRING NOT NULL,
  battery_materials__battery_material_location__component_name_id BIGINT NOT NULL,
  battery_materials__battery_material_location__component_name STRING NOT NULL,
  battery_materials__battery_material_location__component_id_id BIGINT NOT NULL,
  battery_materials__battery_material_location__component_id STRING,
  battery_materials__battery_material_identifier STRING NOT NULL COMMENT 'CAS Number ',
  battery_materials__battery_material_name STRING NOT NULL COMMENT 'Clear name of Material',
  battery_materials__battery_material_mass FLOAT NOT NULL COMMENT 'Weight of component material',
  battery_materials__is_critical_raw_material BOOLEAN NOT NULL COMMENT 'The battery passport must contain information on the critical raw materials present in the battery.\n\nThe information on the critical raw materials must also be provided on the battery label.\nPer Annex VI, Part A(10), critical raw materials must be reported if present in the battery in a concentration of more than 0,1 % weight by weight. ',
  hazardous_substances__hazardous_substance_class STRING NOT NULL COMMENT 'Battery Regulation narrows reporting to substances falling under defined hazard classes and categories of the CLP regulation.',
  hazardous_substances__hazardous_substance_name STRING NOT NULL COMMENT 'Clear name of hazardous substance',
  hazardous_substances__hazardous_substance_concentration DOUBLE NOT NULL COMMENT 'Concentration of hazardous substance',
  hazardous_substances__hazardous_substance_impact STRING NOT NULL COMMENT 'Impact statements based on, e.g., REACH or GHS for all hazard classes applicable to substances in the battery.',
  hazardous_substances__hazardous_substance_location__component_name_id BIGINT NOT NULL,
  hazardous_substances__hazardous_substance_location__component_name STRING NOT NULL,
  hazardous_substances__hazardous_substance_location__component_id_id BIGINT NOT NULL,
  hazardous_substances__hazardous_substance_location__component_id STRING,
  hazardous_substances__hazardous_substance_identifier STRING NOT NULL COMMENT 'CAS identifier of hazardous substance'
)
COMMENT 'Mandatory data: Battery chemistry; critical raw materials; materials used in the cathode, anode, and \nelectrolyte; hazardous substances; impact of substances on the environment and on human health or \nsafety\n\nCopyright ? 2024 Circulor (for and on behalf of the Battery Pass Consortium). This work is li-censed under a Creative Commons License Attribution-NonCommercial 4.0 International (CC BY-NC 4.0). Readers may reproduce material for their own publications, as long as it is not sold com-mercially and is given appropriate attribution.'
TBLPROPERTIES ('x-samm-aspect-model-urn'='urn:samm:io.BatteryPass.MaterialComposition:1.3.0#MaterialComposition');
