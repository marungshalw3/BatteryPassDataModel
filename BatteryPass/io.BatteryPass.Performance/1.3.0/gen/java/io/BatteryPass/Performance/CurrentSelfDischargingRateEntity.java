
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
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Generated class for current self discharging rate
 * (urn:samm:io.BatteryPass.Performance:1.3.0#CurrentSelfDischargingRateEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class CurrentSelfDischargingRateEntity {

	@NotNull
	private Float currentSelfDischargingRateValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public CurrentSelfDischargingRateEntity(
			@JsonProperty(value = "currentSelfDischargingRateValue") Float currentSelfDischargingRateValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.currentSelfDischargingRateValue = currentSelfDischargingRateValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns current self discharge rate value
	 *
	 * @return {@link #currentSelfDischargingRateValue}
	 */
	public Float getCurrentSelfDischargingRateValue() {
		return this.currentSelfDischargingRateValue;
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

		final CurrentSelfDischargingRateEntity that = (CurrentSelfDischargingRateEntity) o;
		return Objects.equals(currentSelfDischargingRateValue, that.currentSelfDischargingRateValue)
				&& Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentSelfDischargingRateValue, lastUpdate);
	}
}
