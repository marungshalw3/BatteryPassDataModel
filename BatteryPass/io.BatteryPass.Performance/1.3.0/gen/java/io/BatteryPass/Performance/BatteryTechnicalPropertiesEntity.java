
package io.BatteryPass.Performance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;

/**
 * Generated class for BatteryTechnicalPropertiesEntity
 * (urn:samm:io.BatteryPass.Performance:1.3.0#BatteryTechnicalPropertiesEntity).
 * Covers all Capability related data attributes
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class BatteryTechnicalPropertiesEntity {

	@Valid

	@NotNull
	private List<PowerCapabilityAtEntity> originalPowerCapability;

	@NotNull
	private Double ratedMaximumPower;

	@NotNull
	private Float powerCapabilityRatio;

	@NotNull
	private Float ratedEnergy;

	@NotNull
	private Long expectedNumberOfCycles;

	@NotNull
	private Double initialSelfDischarge;

	@NotNull
	private Float roundtripEfficiency;

	@NotNull
	private Float ratedCapacity;

	@Valid

	@NotNull
	private List<InternalResistanceEntity> initialInternalResistance;

	@NotNull
	private Short expectedLifetime;
	private Optional<Float> cRate;

	@NotNull
	private Float nominalVoltage;

	@NotNull
	private Float minimumVoltage;

	@NotNull
	private Float maximumVoltage;

	@NotNull
	private Double capacityThresholdForExhaustion;

	@NotNull
	private URI lifetimeReferenceTest;

	@NotNull
	private Float cRateLifeCycleTest;

	@Valid

	@NotNull
	private TemperatureRangeType temperatureRangeIdleState;

	@NotNull
	private Float roundTripEfficiencyAt50PercentCycleLife;

	@NotNull
	private Float roundTripEfficiencyFade;

	@NotNull
	private Float powerFade;

	@JsonCreator
	public BatteryTechnicalPropertiesEntity(
			@JsonProperty(value = "originalPowerCapability") List<PowerCapabilityAtEntity> originalPowerCapability,
			@JsonProperty(value = "ratedMaximumPower") Double ratedMaximumPower,
			@JsonProperty(value = "powerCapabilityRatio") Float powerCapabilityRatio,
			@JsonProperty(value = "ratedEnergy") Float ratedEnergy,
			@JsonProperty(value = "expectedNumberOfCycles") Long expectedNumberOfCycles,
			@JsonProperty(value = "initialSelfDischarge") Double initialSelfDischarge,
			@JsonProperty(value = "roundtripEfficiency") Float roundtripEfficiency,
			@JsonProperty(value = "ratedCapacity") Float ratedCapacity,
			@JsonProperty(value = "initialInternalResistance") List<InternalResistanceEntity> initialInternalResistance,
			@JsonProperty(value = "expectedLifetime") Short expectedLifetime,
			@JsonProperty(value = "cRate") Optional<Float> cRate,
			@JsonProperty(value = "nominalVoltage") Float nominalVoltage,
			@JsonProperty(value = "minimumVoltage") Float minimumVoltage,
			@JsonProperty(value = "maximumVoltage") Float maximumVoltage,
			@JsonProperty(value = "capacityThresholdForExhaustion") Double capacityThresholdForExhaustion,
			@JsonProperty(value = "lifetimeReferenceTest") URI lifetimeReferenceTest,
			@JsonProperty(value = "cRateLifeCycleTest") Float cRateLifeCycleTest,
			@JsonProperty(value = "temperatureRangeIdleState") TemperatureRangeType temperatureRangeIdleState,
			@JsonProperty(value = "roundTripEfficiencyAt50PercentCycleLife") Float roundTripEfficiencyAt50PercentCycleLife,
			@JsonProperty(value = "roundTripEfficiencyFade") Float roundTripEfficiencyFade,
			@JsonProperty(value = "powerFade") Float powerFade) {
		super(

		);
		this.originalPowerCapability = originalPowerCapability;
		this.ratedMaximumPower = ratedMaximumPower;
		this.powerCapabilityRatio = powerCapabilityRatio;
		this.ratedEnergy = ratedEnergy;
		this.expectedNumberOfCycles = expectedNumberOfCycles;
		this.initialSelfDischarge = initialSelfDischarge;
		this.roundtripEfficiency = roundtripEfficiency;
		this.ratedCapacity = ratedCapacity;
		this.initialInternalResistance = initialInternalResistance;
		this.expectedLifetime = expectedLifetime;
		this.cRate = cRate == null ? Optional.empty() : cRate;
		this.nominalVoltage = nominalVoltage;
		this.minimumVoltage = minimumVoltage;
		this.maximumVoltage = maximumVoltage;
		this.capacityThresholdForExhaustion = capacityThresholdForExhaustion;
		this.lifetimeReferenceTest = lifetimeReferenceTest;
		this.cRateLifeCycleTest = cRateLifeCycleTest;
		this.temperatureRangeIdleState = temperatureRangeIdleState;
		this.roundTripEfficiencyAt50PercentCycleLife = roundTripEfficiencyAt50PercentCycleLife;
		this.roundTripEfficiencyFade = roundTripEfficiencyFade;
		this.powerFade = powerFade;
	}

	/**
	 * Returns original power capability
	 *
	 * @return {@link #originalPowerCapability}
	 */
	public List<PowerCapabilityAtEntity> getOriginalPowerCapability() {
		return this.originalPowerCapability;
	}

	/**
	 * Returns rated maximum power
	 *
	 * @return {@link #ratedMaximumPower}
	 */
	public Double getRatedMaximumPower() {
		return this.ratedMaximumPower;
	}

	/**
	 * Returns power capability ratio
	 *
	 * @return {@link #powerCapabilityRatio}
	 */
	public Float getPowerCapabilityRatio() {
		return this.powerCapabilityRatio;
	}

	/**
	 * Returns rated energy
	 *
	 * @return {@link #ratedEnergy}
	 */
	public Float getRatedEnergy() {
		return this.ratedEnergy;
	}

	/**
	 * Returns expected number of cycles
	 *
	 * @return {@link #expectedNumberOfCycles}
	 */
	public Long getExpectedNumberOfCycles() {
		return this.expectedNumberOfCycles;
	}

	/**
	 * Returns initial self discharge
	 *
	 * @return {@link #initialSelfDischarge}
	 */
	public Double getInitialSelfDischarge() {
		return this.initialSelfDischarge;
	}

	/**
	 * Returns round trip efficiency
	 *
	 * @return {@link #roundtripEfficiency}
	 */
	public Float getRoundtripEfficiency() {
		return this.roundtripEfficiency;
	}

	/**
	 * Returns rated capacity
	 *
	 * @return {@link #ratedCapacity}
	 */
	public Float getRatedCapacity() {
		return this.ratedCapacity;
	}

	/**
	 * Returns initial internal resistance
	 *
	 * @return {@link #initialInternalResistance}
	 */
	public List<InternalResistanceEntity> getInitialInternalResistance() {
		return this.initialInternalResistance;
	}

	/**
	 * Returns expected lifetime
	 *
	 * @return {@link #expectedLifetime}
	 */
	public Short getExpectedLifetime() {
		return this.expectedLifetime;
	}

	/**
	 * Returns C-rate
	 *
	 * @return {@link #cRate}
	 */
	public Optional<Float> getCRate() {
		return this.cRate;
	}

	/**
	 * Returns nominal voltag
	 *
	 * @return {@link #nominalVoltage}
	 */
	public Float getNominalVoltage() {
		return this.nominalVoltage;
	}

	/**
	 * Returns minimum voltage
	 *
	 * @return {@link #minimumVoltage}
	 */
	public Float getMinimumVoltage() {
		return this.minimumVoltage;
	}

	/**
	 * Returns maximum voltage
	 *
	 * @return {@link #maximumVoltage}
	 */
	public Float getMaximumVoltage() {
		return this.maximumVoltage;
	}

	/**
	 * Returns capacity threshold for exhaustion
	 *
	 * @return {@link #capacityThresholdForExhaustion}
	 */
	public Double getCapacityThresholdForExhaustion() {
		return this.capacityThresholdForExhaustion;
	}

	/**
	 * Returns lifetime reference test
	 *
	 * @return {@link #lifetimeReferenceTest}
	 */
	public URI getLifetimeReferenceTest() {
		return this.lifetimeReferenceTest;
	}

	/**
	 * Returns C-rate life cycle test
	 *
	 * @return {@link #cRateLifeCycleTest}
	 */
	public Float getCRateLifeCycleTest() {
		return this.cRateLifeCycleTest;
	}

	/**
	 * Returns temperature range idle state
	 *
	 * @return {@link #temperatureRangeIdleState}
	 */
	public TemperatureRangeType getTemperatureRangeIdleState() {
		return this.temperatureRangeIdleState;
	}

	/**
	 * Returns round trip efficiency at 50 percent cycle life
	 *
	 * @return {@link #roundTripEfficiencyAt50PercentCycleLife}
	 */
	public Float getRoundTripEfficiencyAt50PercentCycleLife() {
		return this.roundTripEfficiencyAt50PercentCycleLife;
	}

	/**
	 * Returns roundTripEfficiencyFade
	 *
	 * @return {@link #roundTripEfficiencyFade}
	 */
	public Float getRoundTripEfficiencyFade() {
		return this.roundTripEfficiencyFade;
	}

	/**
	 * Returns powerFade
	 *
	 * @return {@link #powerFade}
	 */
	public Float getPowerFade() {
		return this.powerFade;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final BatteryTechnicalPropertiesEntity that = (BatteryTechnicalPropertiesEntity) o;
		return Objects.equals(originalPowerCapability, that.originalPowerCapability)
				&& Objects.equals(ratedMaximumPower, that.ratedMaximumPower)
				&& Objects.equals(powerCapabilityRatio, that.powerCapabilityRatio)
				&& Objects.equals(ratedEnergy, that.ratedEnergy)
				&& Objects.equals(expectedNumberOfCycles, that.expectedNumberOfCycles)
				&& Objects.equals(initialSelfDischarge, that.initialSelfDischarge)
				&& Objects.equals(roundtripEfficiency, that.roundtripEfficiency)
				&& Objects.equals(ratedCapacity, that.ratedCapacity)
				&& Objects.equals(initialInternalResistance, that.initialInternalResistance)
				&& Objects.equals(expectedLifetime, that.expectedLifetime) && Objects.equals(cRate, that.cRate)
				&& Objects.equals(nominalVoltage, that.nominalVoltage)
				&& Objects.equals(minimumVoltage, that.minimumVoltage)
				&& Objects.equals(maximumVoltage, that.maximumVoltage)
				&& Objects.equals(capacityThresholdForExhaustion, that.capacityThresholdForExhaustion)
				&& Objects.equals(lifetimeReferenceTest, that.lifetimeReferenceTest)
				&& Objects.equals(cRateLifeCycleTest, that.cRateLifeCycleTest)
				&& Objects.equals(temperatureRangeIdleState, that.temperatureRangeIdleState)
				&& Objects.equals(roundTripEfficiencyAt50PercentCycleLife, that.roundTripEfficiencyAt50PercentCycleLife)
				&& Objects.equals(roundTripEfficiencyFade, that.roundTripEfficiencyFade)
				&& Objects.equals(powerFade, that.powerFade);
	}

	@Override
	public int hashCode() {
		return Objects.hash(originalPowerCapability, ratedMaximumPower, powerCapabilityRatio, ratedEnergy,
				expectedNumberOfCycles, initialSelfDischarge, roundtripEfficiency, ratedCapacity,
				initialInternalResistance, expectedLifetime, cRate, nominalVoltage, minimumVoltage, maximumVoltage,
				capacityThresholdForExhaustion, lifetimeReferenceTest, cRateLifeCycleTest, temperatureRangeIdleState,
				roundTripEfficiencyAt50PercentCycleLife, roundTripEfficiencyFade, powerFade);
	}
}
