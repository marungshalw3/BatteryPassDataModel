// AUTO-GENERATED from BatteryPass/composed-schema1.3.json — do not edit by hand.
import { Schema, model, type InferSchemaType } from 'mongoose';

export const batteryPassportSchema = new Schema({
  /** The battery passport must contain carbon footprint per functional unit of the battery as declared in the battery carbon footprint declaration in accordance with */
  "CarbonFootprint": {
    /** The battery carbon footprint is an aggregation of the carbon footprint of the individual lifecycle stages */
    "batteryCarbonFootprint": { type: Number, required: true },
    /** CarbainFootprints per lifecycle stage */
    "carbonFootprintPerLifecycleStage": [{
      /** The description of the life cycle stage  */
      "lifecycleStage": { type: String, required: true, enum: ["RawMaterialExtraction", "MainProduction", "Distribution", "Recycling"] },
      /** Carbon footprint of the individual lifecycle stage */
      "carbonFootprint": { type: Number, required: true },
    }],
    /** EV, industrial and LMT batteries shall bear a conspicuous, clearly legible and indelible label indicating the carbon footprint of the battery and the carbon foo */
    "carbonFootprintPerformanceClass": { type: String, required: true },
    /** The path of a resource. */
    "carbonFootprintStudy": { type: String, required: true },
    /** As a non-mandatory data attribute, the battery passport should include the battery carbon footprint in absolute terms. The absolute battery carbon footprint sho */
    "absoluteCarbonFootprint": { type: Number },
  },
  /** Dismantling information (including at least: exploded diagrams of the battery system/pack showing the location of battery cells; disassembly sequences; type and */
  "Circularity": {
    /** A collection of required documentation to support EoL actions. */
    "dismantlingAndRemovalInformation": [{
      /** Describes type for document e.g. Dismantling manual */
      "documentType": { type: String, required: true, enum: ["BillOfMaterial", "Model3D", "DismantlingManual", "RemovalManual", "OtherManual", "Drawing"] },
      /** A MIME type as defined in RFC 2046, for example "application/pdf". */
      "mimeType": { type: String, required: true },
      /** The path of a resource. */
      "documentURL": { type: String, required: true },
    }],
    /** Contact details of sources for replacement spares. Postal address, including name and brand names, postal code and place, street and number, country, telephone, */
    "sparePartSources": [{
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "nameOfSupplier": { type: String, required: true },
      /** Postal address of supplier for spare parts. */
      "addressOfSupplier": {
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "addressCountry": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "postalCode": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "streetAddress": { type: String, required: true },
      },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "emailAddressOfSupplier": { type: String, required: true },
      /** The path of a resource. */
      "supplierWebAddress": { type: String, required: true },
      /** List of components available at supplier */
      "components": [{
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "partName": { type: String, required: true },
        /** Part Number of Component */
        "partNumber": { type: String, required: true },
      }],
    }],
    /** Share of material recovered from waste present in active materials for each battery model per year and per manufacturing plant. DIN DKE Spec 99100 chapter refer */
    "recycledContent": [{
      /** Recycled material share from pre-consumer waste (manufacturing waste, excluding run-around scrap) of the active material. */
      "preConsumerShare": { type: Number, required: true },
      /** Name of recycled material */
      "recycledMaterial": { type: String, required: true, enum: ["Cobalt", "Nickel", "Lithium", "Lead", "Cobalt", "Nickel", "Lithium", "Lead"] },
      /** Recycled material share from post-consumer waste (end-of-life scrap) of the active material. */
      "postConsumerShare": { type: Number, required: true },
    }],
    /** The safety measures should be provided via the instruction manual as URL linking to PDF. */
    "safetyMeasures": {
      /** The path of a resource. */
      "safetyInstructions": { type: String, required: true },
      /** Usable extinguishing agents refering to classes of extinguishers (A, B, C, D, K).EUBR: Annex XIII (1a) ? Annex VI Part A (9) */
      "extinguishingAgents": [String],
    },
    /** Producer or producer responsibility organisations shall make information available to distributors and end-users on: the role of end-users in contributing to wa */
    "endOfLifeInformation": {
      /** The path of a resource. */
      "wastePrevention": { type: String, required: true },
      /** The path of a resource. */
      "separateCollection": { type: String, required: true },
      /** The path of a resource. */
      "informationOnCollection": { type: String, required: true },
    },
    /** Share of renewable material content. A renewable material is a material made of natural resources that can be replenished. DIN DKE Spec 99100 chapter reference: */
    "renewableContent": { type: Number, required: true },
  },
  /** Mandatory data: Product identification; manufacturer?s identification; manufacturing place; manufacturing date; battery category; battery weight; battery status */
  "GeneralProductInformation": {
    /** A unique identifier is defined as "a unique string of characters for the identification of batteries that also enables a web link to the battery passport" (Art. */
    "productIdentifier": { type: String, required: true },
    /** Code constraint for URN */
    "batteryPassportIdentifier": { type: String, required: true },
    /** Identifier of the battery model (model-level identification). Batteries shall bear a model identification allowing their identification (Art. 38(6)). DIN DKE Sp */
    "batteryModelIdentifier": { type: String, required: true },
    /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
    "batterySerialNumber": { type: String, required: true },
    /** Categories relevant for the battery passport: LMT battery, ?electric vehicle battery, stationary or other industrial battery >2kWh. DIN DKE Spec chapter referen */
    "batteryCategory": { type: String, required: true, enum: ["lmt", "ev", "industrial", "stationary"] },
    /** Unambiguous identification of the manufacturer of the battery, suggested via a unique operator identifier (as "unique string of characters for the identificatio */
    "manufacturerInformation": {
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "contactName": { type: String, required: true },
      "postalAddress": {
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "addressCountry": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "postalCode": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "streetAddress": { type: String, required: true },
      },
      /** Not demanded by the EU Battery Regulation */
      "identifier": { type: String, required: true },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "emailAddress": { type: String },
      /** The path of a resource. */
      "webAddress": { type: String },
    },
    /** Manufacturing date (month and year) Regulation Reference: Annex XIII (1a) ? Annex VI Part A (4); Annex VII Part B (1) */
    "manufacturingDate": { type: Date, required: true },
    /** Lifecycle status of the battery. Status defined from a list, with the options suggested as follows: 'original', 'repurposed', 'reused', 'remanufactured', 'waste */
    "batteryStatus": { type: String, required: true, enum: ["Original", "Repurposed", "Reused", "Remanufactured", "Waste"] },
    /** Weight of the battery EUBR: Annex XIII (1a) ? Annex VI Part A (5) */
    "batteryMass": { type: Number, required: true },
    /** Unambiguous identification of the manufacturing facility (e.g. country, city, street, building (if needed)), suggested via a unique facility identifier (as "uni */
    "manufacturingPlace": {
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "addressCountry": { type: String, required: true },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "postalCode": { type: String, required: true },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "streetAddress": { type: String, required: true },
    },
    /** State the name, trade name or mark, postal address, web ad-dress, e-mail address. Suggested reporting via a unique operator identifier (see requirements of uniq */
    "operatorInformation": {
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "contactName": { type: String, required: true },
      "postalAddress": {
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "addressCountry": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "postalCode": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "streetAddress": { type: String, required: true },
      },
      /** Not demanded by the EU Battery Regulation */
      "identifier": { type: String, required: true },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "emailAddress": { type: String },
      /** The path of a resource. */
      "webAddress": { type: String },
    },
    /** Where appropriate, the battery passport must include information on the date of putting the battery into service. BR Annex VI Part A (1); Art. 3(33); Art. 38(7) */
    "puttingIntoService": { type: String, required: true },
    /** The battery passport must include information about the period for which the commercial warranty applies. DIN DKE Spec chapter reference: 6.1.3.4 */
    "warrentyPeriod": { type: String, required: true },
    /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
    "dppSchemaVersion": { type: String },
    /** Lifecycle status of the digital product passport record. */
    "dppStatus": { type: String, enum: ["Active", "Inactive", "Expired"] },
    /** Granularity level at which the passport applies. */
    "dppGranularity": { type: String, enum: ["Model", "Batch", "Item"] },
    /** Timestamp of the most recent update applied to this digital product passport. */
    "dppLastUpdate": { type: Date },
    /** Unique facility identifier of the manufacturing place ("unique string of characters for the identification of locations or buildings involved in the value chain */
    "facilityIdentifier": { type: String },
  },
  /** Data model for battery labels and conformity Copyright 2024 Circulor (for and on behalf of the Battery Pass Consortium). This work is li-censed under a Creative */
  "Labels": {
    /** The path of a resource. */
    "declarationOfConformity": { type: String, required: true },
    /** The path of a resource. */
    "resultOfTestReport": { type: String, required: true },
    /** List of labels */
    "labels": [{
      /** The path of a resource. */
      "labelingSymbol": { type: String, required: true },
      /** Describes a Property which contains plain text in multiple languages. This is intended exclusively for human readable strings, not for identifiers, measurement  */
      "labelingMeaning": {

      },
      /** Short name of required labeling subjects */
      "labelingSubject": { type: String, required: true, enum: ["SeparateCollection", "HazardousMaterial", "CarbonFootPrint", "ExtinguishingAgent"] },
    }],
  },
  /** Mandatory data: Battery chemistry; critical raw materials; materials used in the cathode, anode, and electrolyte; hazardous substances; impact of substances on  */
  "MaterialComposition": {
    /** Detailed composition, including materials used in the cathode, anode, and electrolyte. All common cells have two electrodes and an electrolyte. The specific com */
    "batteryChemistry": {
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "shortName": { type: String, required: true },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "clearName": { type: String, required: true },
    },
    /** Detailed composition, including materials used in the cathode, anode, and electrolyte EUBR: Annex XIII (2a) */
    "batteryMaterials": [{
      /** Battery component that includes the material */
      "batteryMaterialLocation": {
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentName": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentId": { type: String },
      },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "batteryMaterialIdentifier": { type: String, required: true },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "batteryMaterialName": { type: String, required: true },
      /** Weight of component material */
      "batteryMaterialMass": { type: Number, required: true },
      /** Represents a boolean value (i.e. a "flag"). */
      "isCriticalRawMaterial": { type: Boolean, required: true },
    }],
    /** Hazardous substances contained in the battery other than mercury, cadmium or lead. Substance as a chemical element and its compounds in the natural state or the */
    "hazardousSubstances": [{
      /** Battery Regulation narrows reporting to substances falling under defined hazard classes and categories of the CLP regulation. */
      "hazardousSubstanceClass": { type: String, required: true, enum: ["AcuteToxicity", "SkinCorrosionOrIrritation", "EyeDamageOrIrritation"] },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "hazardousSubstanceName": { type: String, required: true },
      /** Concentration of hazardous substance */
      "hazardousSubstanceConcentration": { type: Number, required: true },
      /** Impact statements based on, e.g., REACH or GHS for all hazard classes applicable to substances in the battery. */
      "hazardousSubstanceImpact": [String],
      /** Battery component that includes the material */
      "hazardousSubstanceLocation": {
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentName": { type: String, required: true },
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentId": { type: String },
      },
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "hazardousSubstanceIdentifier": { type: String, required: true },
    }],
  },
  /** Battery performance and durability data model */
  "Performance": {
    /** Covers all Capability related data attributes */
    "batteryTechnicalProperties": {
      /** Pre-use power capability: Definition of power capability as given in Battery Regulation. Annex IV Part B, point 4 --> measurement at 80 % and 20 % SoC required. */
      "originalPowerCapability": [{
        "atSoC": { type: Number, required: true },
        "powerCapabilityAt": { type: Number, required: true },
      }],
      /** This data point describes the value of maximum permitted power the battery is rated for and reflects the data relevant for power limits. DIN DKE Spec 99100 chap */
      "ratedMaximumPower": { type: Number, required: true },
      /** Ratio between nominal allowed battery power (W) and battery energy (Wh). */
      "powerCapabilityRatio": { type: Number, required: true },
      /** The certified usable battery energy is the usable battery energy according to the procedure in the UN GTR No 22 as determined during the certification of the ve */
      "ratedEnergy": { type: Number, required: true },
      /** Expected battery lifetime expressed in cycles. The exception for non-cycle applications in Article 10 appears sensible, but is not included in the Annex XIII pr */
      "expectedNumberOfCycles": { type: Number, required: true },
      /** Initial self-discharge in % of capacity per unit of time in defined conditions (temperature range etc) as pre-use metric. DIN DKE Spec 99100 chapter reference:  */
      "initialSelfDischarge": { type: Number, required: true },
      /** Energy round trip efficiency is the ratio of the net energy delivered by a battery during a discharge test to the total energy required to restore the initial s */
      "roundtripEfficiency": { type: Number, required: true },
      /** Rated capacity is the total number of ampere-hours (Ah) that can be withdrawn from a fully charged battery under reference conditions (see BattReg Annex IV (1)) */
      "ratedCapacity": { type: Number, required: true },
      /** The battery passport can include additional information about the initial internal resistance on battery module level, if available. It should be defined and ca */
      "initialInternalResistance": [{
        /** Initial (Pre-Use) internal resistance on battery pack level. Definition of internal resistance should differ from regulation definition, as "opposition" is not  */
        "ohmicResistance": { type: Number, required: true },
        "batteryComponent": { type: String, required: true, enum: ["pack", "module", "cell"] },
      }],
      /** The battery passport must include information about the expected battery lifetime in calendar years. The update interval must be upon placement on the market an */
      "expectedLifetime": { type: Number, required: true },
      /** As a non-mandatory data point the battery passport should include the ratio between nominal battery power in W and battery energy in Wh. It aims to provide an i */
      "cRate": { type: Number },
      /** s */
      "nominalVoltage": { type: Number, required: true },
      /** Minimum voltage the battery is rated for. DIN DKE Spec 99100 chapter reference: 6.7.2.9 */
      "minimumVoltage": { type: Number, required: true },
      /** Maximum voltage the battery is rated for. DIN DKE Spec 99100 chapter reference: 6.7.2.10 */
      "maximumVoltage": { type: Number, required: true },
      /** The percentage of SOCE, above which the battery is still considered operational as EV battery in its current life, as provided by the economic operator. DIN DKE */
      "capacityThresholdForExhaustion": { type: Number, required: true },
      /** The path of a resource. */
      "lifetimeReferenceTest": { type: String, required: true },
      /** The C-rate should be provided separately for both the charge and discharge of the battery, if applicable. The exception for non-cycle applications as mentioned  */
      "cRateLifeCycleTest": { type: Number, required: true },
      /** Upper an lower boundary of the surrounding temperature range, which the battery can safely withstand. DIN DKE Spec 99100 chapter reference: 6.7.6.3-4 */
      "temperatureRangeIdleState": {
        /** lower temperature range. */
        "minimum": { type: Number, required: true },
        /** upper temperature range. */
        "maximum": { type: Number, required: true },
      },
      /** Initial round trip energy efficiency shall be measured at reference conditions that include the specification of 50 % of cycle-life. Test methods and reference  */
      "roundTripEfficiencyAt50PercentCycleLife": { type: Number, required: true },
      /** Art. 10: Annex IV Part A (4) (only definition); Article 14: Annex VII Part A (3) */
      "roundTripEfficiencyFade": { type: Number, required: true },
      /** Power fade (in %) means the decrease over time and upon usage in the amount of power that a battery can deliver at the rated voltage. (see BattReg Annex IV (4)) */
      "powerFade": { type: Number, required: true },
    },
    /** Covers all battery lifetime relevant properties */
    "batteryCondition": {
      /** The data attribute should be reported as measured for further potential processing. In addition, the normalisation by capacity may add a further useful value th */
      "energyThroughput": {
        "energyThroughputValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** Capacity throughput. */
      "capacityThroughput": {
        "capacityThroughputValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** - Information and data as a result of its use, including the number of charging and discharging cycles. */
      "numberOfFullCycles": {
        "numberOfFullCyclesValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** Definition based on UNECE GTR 22: The measured or on-board UBE performance at a specific point in its lifetime, expressed as a percentage of the certified usabl */
      "stateOfCertifiedEnergy": {
        "stateOfCertifiedEnergyValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** The capacity fade is the Decrease over time and upon usage in the amount of charge that a battery can deliver at the rated voltage, with respect to the original */
      "capacityFade": {
        "capacityFadeValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** Definition from UNECE GTR 22, applicable only to EVs. The energy supplied by the battery from the beginning of the test procedure used for certification until t */
      "remainingEnergy": {
        "remainingEnergyValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** The in-use data attribute on capacity, corresponding with the definition of rated capacity. DIN DKE Spec 99100 chapter reference: 6.7.2.3 */
      "remainingCapacity": {
        "remainingCapacityValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** The battery passport must contain information and data resulting from its use such as accidents. DIN DKE Spec 99100 chapter reference: 6.7.8.4 */
      "negativeEvents": [{
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "negativeEvent": { type: String, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      }],
      /** The battery passport must include periodically recorded information on the operating environmental conditions, including temperature. DIN DKE Spec 99100 chapter */
      "temperatureInformation": {
        /** Cumulated time spent above the given upper boundary of temperature. */
        "timeExtremeHighTemp": { type: Number, required: true },
        /** Cumulated time spent below the given lower boundary of temperature. */
        "timeExtremeLowTemp": { type: Number, required: true },
        /** Cumulated time spent above the given upper boundary of temperature during Charging. */
        "timeExtremeHighTempCharging": { type: Number, required: true },
        /** Cumulated time spent below the given lower boundary of temperature during charging. */
        "timeExtremeLowTempCharging": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** '- Original power capability (in Watts) and limits, with temperature range when relevant. - The amount of energy that a battery is capable to provide over a giv */
      "remainingPowerCapability": {
        "remainingPowerCapabilityValue": {
          "atSoC": { type: Number, required: true },
          "powerCapabilityAt": { type: Number, required: true },
        },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** Evolution of self-discharge rates is the change of self-discharge over time and usage, as percentage calculated from the initial and current self-discharge rate */
      "evolutionOfSelfDischarge": {
        "evolutionOfSelfDischargeValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** The current self-discharge rate is the change of the self-discharge rate in an idle state of the battery in reference conditions (temperature etc.) at aging par */
      "currentSelfDischargingRate": {
        "currentSelfDischargingRateValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** The internal resistance increase over time and upon usage should be defined based on the ratio of current and initial values as follows: Rincrease(x) = (R(x) -  */
      "internalResistanceIncrease": [{
        "internalResistanceIncreaseValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
        "batteryComponent": { type: String, required: true, enum: ["pack", "module", "cell"] },
      }],
      /** The battery passport shall include information, where possible, about the remaining round trip energy efficiency as information on the state of health of the ba */
      "remainingRoundTripEnergyEfficiency": {
        "remainingRoundTripEnergyEfficiencyValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
      /** The Battery Pass consortium proposes to change the definition to: "available capacity in a battery expressed as a percentage of remaining capacity" to reflect u */
      "stateOfCharge": {
        "stateOfChargeValue": { type: Number, required: true },
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": { type: String, required: true },
      },
    },
  },
  /** Data model for Battery due diligence Copyright ? 2024 Circulor (for and on behalf of the Battery Pass Consortium). This work is li-censed under a Creative Commo */
  "SupplyChainDueDiligence": {
    /** The path of a resource. */
    "supplyChainDueDiligenceReport": { type: String, required: true },
    /** The path of a resource. */
    "thirdPartyAussurances": { type: String },
    /** Value that defines supply chain due dilligence performance */
    "supplyChainIndicies": { type: Number },
  },
}, { timestamps: true });

export type BatteryPassportDoc = InferSchemaType<typeof batteryPassportSchema>;
export const BatteryPassport = model('BatteryPassport', batteryPassportSchema);
