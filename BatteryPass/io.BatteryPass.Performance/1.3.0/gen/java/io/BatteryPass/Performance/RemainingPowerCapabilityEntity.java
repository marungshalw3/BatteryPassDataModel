
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
 * Generated class for reamining power capability
 * (urn:samm:io.BatteryPass.Performance:1.3.0#RemainingPowerCapabilityEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class RemainingPowerCapabilityEntity {

	@Valid

	@NotNull
	private RemainingPowerCapabilityDynamicAt remainingPowerCapabilityValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public RemainingPowerCapabilityEntity(
			@JsonProperty(value = "remainingPowerCapabilityValue") RemainingPowerCapabilityDynamicAt remainingPowerCapabilityValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.remainingPowerCapabilityValue = remainingPowerCapabilityValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns remaining power capability value
	 *
	 * @return {@link #remainingPowerCapabilityValue}
	 */
	public RemainingPowerCapabilityDynamicAt getRemainingPowerCapabilityValue() {
		return this.remainingPowerCapabilityValue;
	}

	/**
	 * Returns last update
	 *
	 * @return {@link #lastUpdate}
	 */
	public XMLGregorianCalendar getLastUpdate() {
		return this.lastUpdate;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final RemainingPowerCapabilityEntity that = (RemainingPowerCapabilityEntity) o;
		return Objects.equals(remainingPowerCapabilityValue, that.remainingPowerCapabilityValue)
				&& Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(remainingPowerCapabilityValue, lastUpdate);
	}
}
