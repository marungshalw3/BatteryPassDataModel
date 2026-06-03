
package io.BatteryPass.Performance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.math.BigInteger;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Generated class for power capability at
 * (urn:samm:io.BatteryPass.Performance:1.3.0#PowerCapabilityAtEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")
@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
		@JsonSubTypes.Type(value = RemainingPowerCapabilityDynamicAt.class, name = "RemainingPowerCapabilityDynamicAt")})
public class PowerCapabilityAtEntity {

	@NotNull
	private Float atSoC;

	@NotNull
	private Float powerCapabilityAt;

	@JsonCreator
	public PowerCapabilityAtEntity(@JsonProperty(value = "atSoC") Float atSoC,
			@JsonProperty(value = "powerCapabilityAt") Float powerCapabilityAt) {
		super(

		);
		this.atSoC = atSoC;
		this.powerCapabilityAt = powerCapabilityAt;
	}

	/**
	 * Returns at SoC
	 *
	 * @return {@link #atSoC}
	 */
	public Float getAtSoC() {
		return this.atSoC;
	}

	/**
	 * Returns power capability at
	 *
	 * @return {@link #powerCapabilityAt}
	 */
	public Float getPowerCapabilityAt() {
		return this.powerCapabilityAt;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final PowerCapabilityAtEntity that = (PowerCapabilityAtEntity) o;
		return Objects.equals(atSoC, that.atSoC) && Objects.equals(powerCapabilityAt, that.powerCapabilityAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(atSoC, powerCapabilityAt);
	}
}
