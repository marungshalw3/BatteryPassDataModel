
package io.BatteryPass.Performance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;

/**
 * Generated class for BatteryConditionEntity
 * (urn:samm:io.BatteryPass.Performance:1.3.0#BatteryConditionEntity). Covers
 * all battery lifetime relevant properties
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class BatteryConditionEntity {

	@Valid

	@NotNull
	private EnergyThroughputEntity energyThroughput;

	@Valid

	@NotNull
	private CapacityThroughputEntity capacityThroughput;

	@Valid

	@NotNull
	private NumberOfFullCyclesEntity numberOfFullCycles;

	@Valid

	@NotNull
	private StateOfCertifiedEnergyEntity stateOfCertifiedEnergy;

	@Valid

	@NotNull
	private CapacityFadeEntity capacityFade;

	@Valid

	@NotNull
	private RemainingEnergyEntity remainingEnergy;

	@Valid

	@NotNull
	private RemainingCapacityEntity remainingCapacity;

	@Valid

	@NotNull
	private List<NegativeEventEntity> negativeEvents;

	@Valid

	@NotNull
	private TemperatureConditionsEntity temperatureInformation;

	@Valid

	@NotNull
	private RemainingPowerCapabilityEntity remainingPowerCapability;

	@Valid

	@NotNull
	private EvolutionOfSelfDischargeEntity evolutionOfSelfDischarge;

	@Valid

	@NotNull
	private CurrentSelfDischargingRateEntity currentSelfDischargingRate;

	@Valid

	@NotNull
	private List<InternalResistanceIncreaseEntity> internalResistanceIncrease;

	@Valid

	@NotNull
	private RemainingRoundTripEnergyEfficiencyEntity remainingRoundTripEnergyEfficiency;

	@Valid

	@NotNull
	private StateOfChargeEntity stateOfCharge;

	@JsonCreator
	public BatteryConditionEntity(@JsonProperty(value = "energyThroughput") EnergyThroughputEntity energyThroughput,
			@JsonProperty(value = "capacityThroughput") CapacityThroughputEntity capacityThroughput,
			@JsonProperty(value = "numberOfFullCycles") NumberOfFullCyclesEntity numberOfFullCycles,
			@JsonProperty(value = "stateOfCertifiedEnergy") StateOfCertifiedEnergyEntity stateOfCertifiedEnergy,
			@JsonProperty(value = "capacityFade") CapacityFadeEntity capacityFade,
			@JsonProperty(value = "remainingEnergy") RemainingEnergyEntity remainingEnergy,
			@JsonProperty(value = "remainingCapacity") RemainingCapacityEntity remainingCapacity,
			@JsonProperty(value = "negativeEvents") List<NegativeEventEntity> negativeEvents,
			@JsonProperty(value = "temperatureInformation") TemperatureConditionsEntity temperatureInformation,
			@JsonProperty(value = "remainingPowerCapability") RemainingPowerCapabilityEntity remainingPowerCapability,
			@JsonProperty(value = "evolutionOfSelfDischarge") EvolutionOfSelfDischargeEntity evolutionOfSelfDischarge,
			@JsonProperty(value = "currentSelfDischargingRate") CurrentSelfDischargingRateEntity currentSelfDischargingRate,
			@JsonProperty(value = "internalResistanceIncrease") List<InternalResistanceIncreaseEntity> internalResistanceIncrease,
			@JsonProperty(value = "remainingRoundTripEnergyEfficiency") RemainingRoundTripEnergyEfficiencyEntity remainingRoundTripEnergyEfficiency,
			@JsonProperty(value = "stateOfCharge") StateOfChargeEntity stateOfCharge) {
		super(

		);
		this.energyThroughput = energyThroughput;
		this.capacityThroughput = capacityThroughput;
		this.numberOfFullCycles = numberOfFullCycles;
		this.stateOfCertifiedEnergy = stateOfCertifiedEnergy;
		this.capacityFade = capacityFade;
		this.remainingEnergy = remainingEnergy;
		this.remainingCapacity = remainingCapacity;
		this.negativeEvents = negativeEvents;
		this.temperatureInformation = temperatureInformation;
		this.remainingPowerCapability = remainingPowerCapability;
		this.evolutionOfSelfDischarge = evolutionOfSelfDischarge;
		this.currentSelfDischargingRate = currentSelfDischargingRate;
		this.internalResistanceIncrease = internalResistanceIncrease;
		this.remainingRoundTripEnergyEfficiency = remainingRoundTripEnergyEfficiency;
		this.stateOfCharge = stateOfCharge;
	}

	/**
	 * Returns energyThroughput
	 *
	 * @return {@link #energyThroughput}
	 */
	public EnergyThroughputEntity getEnergyThroughput() {
		return this.energyThroughput;
	}

	/**
	 * Returns capacityThroughput
	 *
	 * @return {@link #capacityThroughput}
	 */
	public CapacityThroughputEntity getCapacityThroughput() {
		return this.capacityThroughput;
	}

	/**
	 * Returns numberOfFullCycles
	 *
	 * @return {@link #numberOfFullCycles}
	 */
	public NumberOfFullCyclesEntity getNumberOfFullCycles() {
		return this.numberOfFullCycles;
	}

	/**
	 * Returns SOCE
	 *
	 * @return {@link #stateOfCertifiedEnergy}
	 */
	public StateOfCertifiedEnergyEntity getStateOfCertifiedEnergy() {
		return this.stateOfCertifiedEnergy;
	}

	/**
	 * Returns capacity fade
	 *
	 * @return {@link #capacityFade}
	 */
	public CapacityFadeEntity getCapacityFade() {
		return this.capacityFade;
	}

	/**
	 * Returns remaining energy
	 *
	 * @return {@link #remainingEnergy}
	 */
	public RemainingEnergyEntity getRemainingEnergy() {
		return this.remainingEnergy;
	}

	/**
	 * Returns remaining capacity
	 *
	 * @return {@link #remainingCapacity}
	 */
	public RemainingCapacityEntity getRemainingCapacity() {
		return this.remainingCapacity;
	}

	/**
	 * Returns negative events
	 *
	 * @return {@link #negativeEvents}
	 */
	public List<NegativeEventEntity> getNegativeEvents() {
		return this.negativeEvents;
	}

	/**
	 * Returns temperature information
	 *
	 * @return {@link #temperatureInformation}
	 */
	public TemperatureConditionsEntity getTemperatureInformation() {
		return this.temperatureInformation;
	}

	/**
	 * Returns remaining power capability
	 *
	 * @return {@link #remainingPowerCapability}
	 */
	public RemainingPowerCapabilityEntity getRemainingPowerCapability() {
		return this.remainingPowerCapability;
	}

	/**
	 * Returns evolution of self discharge
	 *
	 * @return {@link #evolutionOfSelfDischarge}
	 */
	public EvolutionOfSelfDischargeEntity getEvolutionOfSelfDischarge() {
		return this.evolutionOfSelfDischarge;
	}

	/**
	 * Returns current self discharge rate
	 *
	 * @return {@link #currentSelfDischargingRate}
	 */
	public CurrentSelfDischargingRateEntity getCurrentSelfDischargingRate() {
		return this.currentSelfDischargingRate;
	}

	/**
	 * Returns internal resistance increase
	 *
	 * @return {@link #internalResistanceIncrease}
	 */
	public List<InternalResistanceIncreaseEntity> getInternalResistanceIncrease() {
		return this.internalResistanceIncrease;
	}

	/**
	 * Returns remaining round trip energy efficiency
	 *
	 * @return {@link #remainingRoundTripEnergyEfficiency}
	 */
	public RemainingRoundTripEnergyEfficiencyEntity getRemainingRoundTripEnergyEfficiency() {
		return this.remainingRoundTripEnergyEfficiency;
	}

	/**
	 * Returns SoC
	 *
	 * @return {@link #stateOfCharge}
	 */
	public StateOfChargeEntity getStateOfCharge() {
		return this.stateOfCharge;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final BatteryConditionEntity that = (BatteryConditionEntity) o;
		return Objects.equals(energyThroughput, that.energyThroughput)
				&& Objects.equals(capacityThroughput, that.capacityThroughput)
				&& Objects.equals(numberOfFullCycles, that.numberOfFullCycles)
				&& Objects.equals(stateOfCertifiedEnergy, that.stateOfCertifiedEnergy)
				&& Objects.equals(capacityFade, that.capacityFade)
				&& Objects.equals(remainingEnergy, that.remainingEnergy)
				&& Objects.equals(remainingCapacity, that.remainingCapacity)
				&& Objects.equals(negativeEvents, that.negativeEvents)
				&& Objects.equals(temperatureInformation, that.temperatureInformation)
				&& Objects.equals(remainingPowerCapability, that.remainingPowerCapability)
				&& Objects.equals(evolutionOfSelfDischarge, that.evolutionOfSelfDischarge)
				&& Objects.equals(currentSelfDischargingRate, that.currentSelfDischargingRate)
				&& Objects.equals(internalResistanceIncrease, that.internalResistanceIncrease)
				&& Objects.equals(remainingRoundTripEnergyEfficiency, that.remainingRoundTripEnergyEfficiency)
				&& Objects.equals(stateOfCharge, that.stateOfCharge);
	}

	@Override
	public int hashCode() {
		return Objects.hash(energyThroughput, capacityThroughput, numberOfFullCycles, stateOfCertifiedEnergy,
				capacityFade, remainingEnergy, remainingCapacity, negativeEvents, temperatureInformation,
				remainingPowerCapability, evolutionOfSelfDischarge, currentSelfDischargingRate,
				internalResistanceIncrease, remainingRoundTripEnergyEfficiency, stateOfCharge);
	}
}
