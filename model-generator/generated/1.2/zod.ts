// AUTO-GENERATED from BatteryPass/composed-schema1.2.json — do not edit by hand.
import { z } from 'zod';

export const batteryPassportSchema = z.object({
  /** The battery passport must contain carbon footprint per functional unit of the battery as declared in the battery carbon footprint declaration in accordance with */
  "CarbonFootprint": z.object({
    /** The battery carbon footprint is an aggregation of the carbon footprint of the individual lifecycle stages */
    "batteryCarbonFootprint": z.number(),
    /** CarbainFootprints per lifecycle stage */
    "carbonFootprintPerLifecycleStage": z.array(z.object({
      "lifecycleStage": z.enum(["RawMaterialExtraction", "MainProduction", "Distribution", "Recycling"]),
      "carbonFootprint": z.number(),
    })),
    /** EV, industrial and LMT batteries shall bear a conspicuous, clearly legible and indelible label indicating the carbon footprint of the battery and the carbon foo */
    "carbonFootprintPerformanceClass": z.string(),
    /** The path of a resource. */
    "carbonFootprintStudy": z.string().url(),
    "absoluteCarbonFootprint": z.number().optional(),
  }),
  /** Dismantling information (including at least: exploded diagrams of the battery system/pack showing the location of battery cells; disassembly sequences; type and */
  "Circularity": z.object({
    /** A collection of required documentation to support EoL actions. */
    "dismantlingAndRemovalInformation": z.array(z.object({
      /** Describes type for document e.g. Dismantling manual */
      "documentType": z.enum(["BillOfMaterial", "Model3D", "DismantlingManual", "RemovalManual", "OtherManual", "Drawing"]),
      /** A MIME type as defined in RFC 2046, for example "application/pdf". */
      "mimeType": z.string(),
      /** The path of a resource. */
      "documentURL": z.string().url(),
    })),
    /** Contact details of sources for replacement spares. Postal address, including name and brand names, postal code and place, street and number, country, telephone, */
    "sparePartSources": z.array(z.object({
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "nameOfSupplier": z.string(),
      /** Postal address of supplier for spare parts. */
      "addressOfSupplier": z.object({
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "addressCountry": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "postalCode": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "streetAddress": z.string(),
      }),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "emailAddressOfSupplier": z.string(),
      /** The path of a resource. */
      "supplierWebAddress": z.string().url(),
      /** List of components available at supplier */
      "components": z.array(z.object({
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "partName": z.string(),
        /** Part Number of Component */
        "partNumber": z.string(),
      })),
    })),
    /** Share of material recovered from waste present in active materials for each battery model per year and per manufacturing plant. DIN DKE Spec 99100 chapter refer */
    "recycledContent": z.array(z.object({
      /** Recycled material share from pre-consumer waste (manufacturing waste, excluding run-around scrap) of the active material. */
      "preConsumerShare": z.number(),
      /** Name of recycled material */
      "recycledMaterial": z.enum(["Cobalt", "Nickel", "Lithium", "Lead", "Cobalt", "Nickel", "Lithium", "Lead"]),
      /** Recycled material share from post-consumer waste (end-of-life scrap) of the active material. */
      "postConsumerShare": z.number(),
    })),
    /** The safety measures should be provided via the instruction manual as URL linking to PDF. */
    "safetyMeasures": z.object({
      /** The path of a resource. */
      "safetyInstructions": z.string().url(),
      /** Usable extinguishing agents refering to classes of extinguishers (A, B, C, D, K).EUBR: Annex XIII (1a) ? Annex VI Part A (9) */
      "extinguishingAgents": z.array(z.string()),
    }),
    /** Producer or producer responsibility organisations shall make information available to distributors and end-users on: the role of end-users in contributing to wa */
    "endOfLifeInformation": z.object({
      /** The path of a resource. */
      "wastePrevention": z.string().url(),
      /** The path of a resource. */
      "separateCollection": z.string().url(),
      /** The path of a resource. */
      "informationOnCollection": z.string().url(),
    }),
    /** Share of renewable material content. A renewable material is a material made of natural resources that can be replenished. DIN DKE Spec 99100 chapter reference: */
    "renewableContent": z.number(),
  }),
  /** Mandatory data: Product identification; manufacturer?s identification; manufacturing place; manufacturing date; battery category; battery weight; battery status */
  "GeneralProductInformation": z.object({
    /** A unique identifier is defined as "a unique string of characters for the identification of batteries that also enables a web link to the battery passport" (Art. */
    "productIdentifier": z.string(),
    /** Code constraint for URN */
    "batteryPassportIdentifier": z.string(),
    /** Categories relevant for the battery passport: LMT battery, ?electric vehicle battery, stationary or other industrial battery >2kWh. DIN DKE Spec chapter referen */
    "batteryCategory": z.enum(["lmt", "ev", "industrial", "stationary"]),
    /** Unambiguous identification of the manufacturer of the battery, suggested via a unique operator identifier (as "unique string of characters for the identificatio */
    "manufacturerInformation": z.object({
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "contactName": z.string(),
      "postalAddress": z.object({
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "addressCountry": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "postalCode": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "streetAddress": z.string(),
      }),
      /** Not demanded by the EU Battery Regulation */
      "identifier": z.string(),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "emailAddress": z.string().optional(),
      /** The path of a resource. */
      "webAddress": z.string().url().optional(),
    }),
    /** Manufacturing date (month and year) Regulation Reference: Annex XIII (1a) ? Annex VI Part A (4); Annex VII Part B (1) */
    "manufacturingDate": z.coerce.date(),
    /** Lifecycle status of the battery. Status defined from a list, with the options suggested as follows: 'original', 'repurposed', 'reused', 'remanufactured', 'waste */
    "batteryStatus": z.enum(["Original", "Repurposed", "Reused", "Remanufactured", "Waste"]),
    /** Weight of the battery EUBR: Annex XIII (1a) ? Annex VI Part A (5) */
    "batteryMass": z.number(),
    /** Unambiguous identification of the manufacturing facility (e.g. country, city, street, building (if needed)), suggested via a unique facility identifier (as "uni */
    "manufacturingPlace": z.object({
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "addressCountry": z.string(),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "postalCode": z.string(),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "streetAddress": z.string(),
    }),
    /** State the name, trade name or mark, postal address, web ad-dress, e-mail address. Suggested reporting via a unique operator identifier (see requirements of uniq */
    "operatorInformation": z.object({
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "contactName": z.string(),
      "postalAddress": z.object({
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "addressCountry": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "postalCode": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "streetAddress": z.string(),
      }),
      /** Not demanded by the EU Battery Regulation */
      "identifier": z.string(),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "emailAddress": z.string().optional(),
      /** The path of a resource. */
      "webAddress": z.string().url().optional(),
    }),
    /** Where appropriate, the battery passport must include information on the date of putting the battery into service. BR Annex VI Part A (1); Art. 3(33); Art. 38(7) */
    "puttingIntoService": z.string(),
    /** The battery passport must include information about the period for which the commercial warranty applies. DIN DKE Spec chapter reference: 6.1.3.4 */
    "warrentyPeriod": z.string(),
  }),
  /** Data model for battery labels and conformity Copyright 2024 Circulor (for and on behalf of the Battery Pass Consortium). This work is li-censed under a Creative */
  "Labels": z.object({
    /** The path of a resource. */
    "declarationOfConformity": z.string().url(),
    /** The path of a resource. */
    "resultOfTestReport": z.string().url(),
    /** List of labels */
    "labels": z.array(z.object({
      /** The path of a resource. */
      "labelingSymbol": z.string().url(),
      /** Describes a Property which contains plain text in multiple languages. This is intended exclusively for human readable strings, not for identifiers, measurement  */
      "labelingMeaning": z.object({

      }),
      /** Short name of required labeling subjects */
      "labelingSubject": z.enum(["SeparateCollection", "HazardousMaterial", "CarbonFootPrint", "ExtinguishingAgent"]),
    })),
  }),
  /** Mandatory data: Battery chemistry; critical raw materials; materials used in the cathode, anode, and electrolyte; hazardous substances; impact of substances on  */
  "MaterialComposition": z.object({
    /** Detailed composition, including materials used in the cathode, anode, and electrolyte. All common cells have two electrodes and an electrolyte. The specific com */
    "batteryChemistry": z.object({
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "shortName": z.string(),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "clearName": z.string(),
    }),
    /** Detailed composition, including materials used in the cathode, anode, and electrolyte EUBR: Annex XIII (2a) */
    "batteryMaterials": z.array(z.object({
      /** Battery component that includes the material */
      "batteryMaterialLocation": z.object({
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentName": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentId": z.string().optional(),
      }),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "batteryMaterialIdentifier": z.string(),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "batteryMaterialName": z.string(),
      /** Weight of component material */
      "batteryMaterialMass": z.number(),
      /** Represents a boolean value (i.e. a "flag"). */
      "isCriticalRawMaterial": z.boolean(),
    })),
    /** Hazardous substances contained in the battery other than mercury, cadmium or lead. Substance as a chemical element and its compounds in the natural state or the */
    "hazardousSubstances": z.array(z.object({
      /** Battery Regulation narrows reporting to substances falling under defined hazard classes and categories of the CLP regulation. */
      "hazardousSubstanceClass": z.enum(["AcuteToxicity", "SkinCorrosionOrIrritation", "EyeDamageOrIrritation"]),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "hazardousSubstanceName": z.string(),
      /** Concentration of hazardous substance */
      "hazardousSubstanceConcentration": z.number(),
      /** Impact statements based on, e.g., REACH or GHS for all hazard classes applicable to substances in the battery. */
      "hazardousSubstanceImpact": z.array(z.string()),
      /** Battery component that includes the material */
      "hazardousSubstanceLocation": z.object({
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentName": z.string(),
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "componentId": z.string().optional(),
      }),
      /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
      "hazardousSubstanceIdentifier": z.string(),
    })),
  }),
  /** Battery performance and durability data model */
  "Performance": z.object({
    /** Covers all Capability related data attributes */
    "batteryTechnicalProperties": z.object({
      /** Pre-use power capability: Definition of power capability as given in Battery Regulation. Annex IV Part B, point 4 --> measurement at 80 % and 20 % SoC required. */
      "originalPowerCapability": z.array(z.object({
        "atSoC": z.number(),
        "powerCapabilityAt": z.number(),
      })),
      /** This data point describes the value of maximum permitted power the battery is rated for and reflects the data relevant for power limits. DIN DKE Spec 99100 chap */
      "ratedMaximumPower": z.number(),
      /** Ratio between nominal allowed battery power (W) and battery energy (Wh). */
      "powerCapabilityRatio": z.number(),
      /** The certified usable battery energy is the usable battery energy according to the procedure in the UN GTR No 22 as determined during the certification of the ve */
      "ratedEnergy": z.number(),
      /** Expected battery lifetime expressed in cycles. The exception for non-cycle applications in Article 10 appears sensible, but is not included in the Annex XIII pr */
      "expectedNumberOfCycles": z.number(),
      /** Initial self-discharge in % of capacity per unit of time in defined conditions (temperature range etc) as pre-use metric. DIN DKE Spec 99100 chapter reference:  */
      "initialSelfDischarge": z.number(),
      /** Energy round trip efficiency is the ratio of the net energy delivered by a battery during a discharge test to the total energy required to restore the initial s */
      "roundtripEfficiency": z.number(),
      /** Rated capacity is the total number of ampere-hours (Ah) that can be withdrawn from a fully charged battery under reference conditions (see BattReg Annex IV (1)) */
      "ratedCapacity": z.number(),
      /** The battery passport can include additional information about the initial internal resistance on battery module level, if available. It should be defined and ca */
      "initialInternalResistance": z.array(z.object({
        /** Initial (Pre-Use) internal resistance on battery pack level. Definition of internal resistance should differ from regulation definition, as "opposition" is not  */
        "ohmicResistance": z.number(),
        "batteryComponent": z.enum(["pack", "module", "cell"]),
      })),
      /** The battery passport must include information about the expected battery lifetime in calendar years. The update interval must be upon placement on the market an */
      "expectedLifetime": z.number(),
      /** As a non-mandatory data point the battery passport should include the ratio between nominal battery power in W and battery energy in Wh. It aims to provide an i */
      "cRate": z.number().optional(),
      /** s */
      "nominalVoltage": z.number(),
      /** Minimum voltage the battery is rated for. DIN DKE Spec 99100 chapter reference: 6.7.2.9 */
      "minimumVoltage": z.number(),
      /** Maximum voltage the battery is rated for. DIN DKE Spec 99100 chapter reference: 6.7.2.10 */
      "maximumVoltage": z.number(),
      /** The percentage of SOCE, above which the battery is still considered operational as EV battery in its current life, as provided by the economic operator. DIN DKE */
      "capacityThresholdForExhaustion": z.number(),
      /** The path of a resource. */
      "lifetimeReferenceTest": z.string().url(),
      /** The C-rate should be provided separately for both the charge and discharge of the battery, if applicable. The exception for non-cycle applications as mentioned  */
      "cRateLifeCycleTest": z.number(),
      /** Upper an lower boundary of the surrounding temperature range, which the battery can safely withstand. DIN DKE Spec 99100 chapter reference: 6.7.6.3-4 */
      "temperatureRangeIdleState": z.object({
        /** lower temperature range. */
        "minimum": z.number(),
        /** upper temperature range. */
        "maximum": z.number(),
      }),
      /** Initial round trip energy efficiency shall be measured at reference conditions that include the specification of 50 % of cycle-life. Test methods and reference  */
      "roundTripEfficiencyAt50PercentCycleLife": z.number(),
      /** Art. 10: Annex IV Part A (4) (only definition); Article 14: Annex VII Part A (3) */
      "roundTripEfficiencyFade": z.number(),
      /** Power fade (in %) means the decrease over time and upon usage in the amount of power that a battery can deliver at the rated voltage. (see BattReg Annex IV (4)) */
      "powerFade": z.number(),
    }),
    /** Covers all battery lifetime relevant properties */
    "batteryCondition": z.object({
      /** The data attribute should be reported as measured for further potential processing. In addition, the normalisation by capacity may add a further useful value th */
      "energyThroughput": z.object({
        "energyThroughputValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** Capacity throughput. */
      "capacityThroughput": z.object({
        "capacityThroughputValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** - Information and data as a result of its use, including the number of charging and discharging cycles. */
      "numberOfFullCycles": z.object({
        "numberOfFullCyclesValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** Definition based on UNECE GTR 22: The measured or on-board UBE performance at a specific point in its lifetime, expressed as a percentage of the certified usabl */
      "stateOfCertifiedEnergy": z.object({
        "stateOfCertifiedEnergyValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** The capacity fade is the Decrease over time and upon usage in the amount of charge that a battery can deliver at the rated voltage, with respect to the original */
      "capacityFade": z.object({
        "capacityFadeValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** Definition from UNECE GTR 22, applicable only to EVs. The energy supplied by the battery from the beginning of the test procedure used for certification until t */
      "remainingEnergy": z.object({
        "remainingEnergyValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** The in-use data attribute on capacity, corresponding with the definition of rated capacity. DIN DKE Spec 99100 chapter reference: 6.7.2.3 */
      "remainingCapacity": z.object({
        "remainingCapacityValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** The battery passport must contain information and data resulting from its use such as accidents. DIN DKE Spec 99100 chapter reference: 6.7.8.4 */
      "negativeEvents": z.array(z.object({
        /** Describes a Property which contains plain text. This is intended exclusively for human readable strings, not for identifiers, measurement values, etc. */
        "negativeEvent": z.string(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      })),
      /** The battery passport must include periodically recorded information on the operating environmental conditions, including temperature. DIN DKE Spec 99100 chapter */
      "temperatureInformation": z.object({
        /** Cumulated time spent above the given upper boundary of temperature. */
        "timeExtremeHighTemp": z.number(),
        /** Cumulated time spent below the given lower boundary of temperature. */
        "timeExtremeLowTemp": z.number(),
        /** Cumulated time spent above the given upper boundary of temperature during Charging. */
        "timeExtremeHighTempCharging": z.number(),
        /** Cumulated time spent below the given lower boundary of temperature during charging. */
        "timeExtremeLowTempCharging": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** '- Original power capability (in Watts) and limits, with temperature range when relevant. - The amount of energy that a battery is capable to provide over a giv */
      "remainingPowerCapability": z.object({
        "remainingPowerCapabilityValue": z.object({
          "atSoC": z.number(),
          "powerCapabilityAt": z.number(),
        }),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** Evolution of self-discharge rates is the change of self-discharge over time and usage, as percentage calculated from the initial and current self-discharge rate */
      "evolutionOfSelfDischarge": z.object({
        "evolutionOfSelfDischargeValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** The current self-discharge rate is the change of the self-discharge rate in an idle state of the battery in reference conditions (temperature etc.) at aging par */
      "currentSelfDischargingRate": z.object({
        "currentSelfDischargingRateValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** The internal resistance increase over time and upon usage should be defined based on the ratio of current and initial values as follows: Rincrease(x) = (R(x) -  */
      "internalResistanceIncrease": z.array(z.object({
        "internalResistanceIncreaseValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
        "batteryComponent": z.enum(["pack", "module", "cell"]),
      })),
      /** The battery passport shall include information, where possible, about the remaining round trip energy efficiency as information on the state of health of the ba */
      "remainingRoundTripEnergyEfficiency": z.object({
        "remainingRoundTripEnergyEfficiencyValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
      /** The Battery Pass consortium proposes to change the definition to: "available capacity in a battery expressed as a percentage of remaining capacity" to reflect u */
      "stateOfCharge": z.object({
        "stateOfChargeValue": z.number(),
        /** Describes a Property which contains the date and time with an optional timezone. */
        "lastUpdate": z.string(),
      }),
    }),
  }),
  /** Data model for Battery due diligence Copyright ? 2024 Circulor (for and on behalf of the Battery Pass Consortium). This work is li-censed under a Creative Commo */
  "SupplyChainDueDiligence": z.object({
    /** The path of a resource. */
    "supplyChainDueDiligenceReport": z.string().url(),
    /** The path of a resource. */
    "thirdPartyAussurances": z.string().url().optional(),
    /** Value that defines supply chain due dilligence performance */
    "supplyChainIndicies": z.number().optional(),
  }),
});

export type BatteryPassport = z.infer<typeof batteryPassportSchema>;
