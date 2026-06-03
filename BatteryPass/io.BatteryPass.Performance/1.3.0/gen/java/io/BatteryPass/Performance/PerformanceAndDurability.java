
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
 * Generated class for PerformanceAndDurability
 * (urn:samm:io.BatteryPass.Performance:1.3.0#PerformanceAndDurability). Battery
 * performance and durability data model
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")
public class PerformanceAndDurability {

	@Valid

	@NotNull
	private BatteryTechnicalPropertiesEntity batteryTechnicalProperties;

	@Valid

	@NotNull
	private BatteryConditionEntity batteryCondition;

	@JsonCreator
	public PerformanceAndDurability(
			@JsonProperty(value = "batteryTechnicalProperties") BatteryTechnicalPropertiesEntity batteryTechnicalProperties,
			@JsonProperty(value = "batteryCondition") BatteryConditionEntity batteryCondition) {
		super(

		);
		this.batteryTechnicalProperties = batteryTechnicalProperties;
		this.batteryCondition = batteryCondition;
	}

	/**
	 * Returns battery technical properties
	 *
	 * @return {@link #batteryTechnicalProperties}
	 */
	public BatteryTechnicalPropertiesEntity getBatteryTechnicalProperties() {
		return this.batteryTechnicalProperties;
	}

	/**
	 * Returns battery condition
	 *
	 * @return {@link #batteryCondition}
	 */
	public BatteryConditionEntity getBatteryCondition() {
		return this.batteryCondition;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final PerformanceAndDurability that = (PerformanceAndDurability) o;
		return Objects.equals(batteryTechnicalProperties, that.batteryTechnicalProperties)
				&& Objects.equals(batteryCondition, that.batteryCondition);
	}

	@Override
	public int hashCode() {
		return Objects.hash(batteryTechnicalProperties, batteryCondition);
	}
}
