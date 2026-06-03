CREATE TABLE IF NOT EXISTS circularity (
  dismantling_and_removal_information__document_type STRING NOT NULL COMMENT 'Describes type for document e.g. Dismantling manual',
  dismantling_and_removal_information__mime_type STRING NOT NULL COMMENT 'Defines internet media typ to determin how to interpret the documentURL',
  dismantling_and_removal_information__document_u_r_l STRING NOT NULL COMMENT 'Link to document',
  spare_part_sources__name_of_supplier STRING NOT NULL COMMENT 'Name of Supplier',
  spare_part_sources__address_of_supplier__address_country_id BIGINT NOT NULL,
  spare_part_sources__address_of_supplier__address_country STRING NOT NULL,
  spare_part_sources__address_of_supplier__postal_code_id BIGINT NOT NULL,
  spare_part_sources__address_of_supplier__postal_code STRING NOT NULL,
  spare_part_sources__address_of_supplier__street_address_id BIGINT NOT NULL,
  spare_part_sources__address_of_supplier__street_address STRING NOT NULL,
  spare_part_sources__email_address_of_supplier STRING NOT NULL COMMENT 'E-mail address of supplier for spare parts.',
  spare_part_sources__supplier_web_address STRING NOT NULL COMMENT 'Web address of supplier for spare parts.',
  spare_part_sources__components__part_name_id BIGINT NOT NULL,
  spare_part_sources__components__part_name STRING NOT NULL,
  spare_part_sources__components__part_number_id BIGINT NOT NULL,
  spare_part_sources__components__part_number STRING NOT NULL COMMENT 'Part Number of Component',
  recycled_content__pre_consumer_share FLOAT NOT NULL COMMENT 'Recycled material share from pre-consumer waste (manufacturing waste, excluding run-around scrap) of the active material.',
  recycled_content__recycled_material STRING NOT NULL COMMENT 'Name of recycled material',
  recycled_content__post_consumer_share FLOAT NOT NULL COMMENT 'Recycled material share from post-consumer waste (end-of-life scrap) of the active material.',
    safety_measures__safety_instructions STRING NOT NULL COMMENT '- Safety measures. - Necessary safety instructions to handle waste batteries, including in relation to the risks associated with, and the handling of, batteries containing lithium.',
  safety_measures__extinguishing_agents ARRAY<STRING> NOT NULL COMMENT 'Usable extinguishing agents refering to classes of extinguishers (A, B, C, D, K).EUBR: Annex XIII (1a) ? Annex VI Part A (9)',
  end_of_life_information__waste_prevention STRING NOT NULL COMMENT 'Prevention and management of waste batteries: Point (a) of Article 60(1): Information on the role of end-users in contributing to waste prevention, including by information on good practices and recommendations concerning the use of batteries aiming at extending their use phase and the possibilities of re-use, preparing for re-use, preparing for repurpose, repurposing and remanufacturing',
  end_of_life_information__separate_collection STRING NOT NULL COMMENT 'Prevention and management of waste batteries: Point (b) of Article 60(1): Information on the role of end-users in contributing to the separate collection of waste batteries in accordance with their obligations under Article 51 so as to allow their treatment',
  end_of_life_information__information_on_collection STRING NOT NULL COMMENT 'Prevention and management of waste batteries: Point (c) of Article 60(1): information on the separate collection, the take back, the collection points and preparing for re-use, preparing for repurposing, and recycling operations available for waste batteries',
  renewable_content FLOAT NOT NULL COMMENT 'Share of renewable material content. A renewable material is a material made of natural resources that can be replenished. \n\nDIN DKE Spec 99100 chapter reference: 6.6.2.11'
)
COMMENT 'Dismantling information (including at least: exploded diagrams of the battery system/pack showing the location of battery cells; disassembly sequences; type and number of fastening techniques to be unlocked; tools required for disassembly; warnings if risk of damaging parts exists; amount of cells used and layout); part numbers for components and contact details of sources for replacement spares; safety measures (Annex XIII (2b-d)); usable extinguishing agent (Annex VI, Part A(9)). 2024 Circulor (for and on behalf of the Battery Pass Consortium). This work is licensed under a Creative Commons License Attribution-NonCommercial 4.0 International (CC BY-NC 4.0). Readers may reproduce material for their own publications, as long as it is not sold commercially and is given appropriate attribution.'
TBLPROPERTIES ('x-samm-aspect-model-urn'='urn:samm:io.BatteryPass.Circularity:1.3.0#Circularity');
