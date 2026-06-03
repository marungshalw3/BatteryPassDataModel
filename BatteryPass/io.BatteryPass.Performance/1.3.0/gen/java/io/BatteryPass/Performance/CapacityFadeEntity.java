
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
 * Generated class for capacity fade
 * (urn:samm:io.BatteryPass.Performance:1.3.0#CapacityFadeEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class CapacityFadeEntity {

	@NotNull
	private Float capacityFadeValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public CapacityFadeEntity(@JsonProperty(value = "capacityFadeValue") Float capacityFadeValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.capacityFadeValue = capacityFadeValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns capacity fade
	 *
	 * @return {@link #capacityFadeValue}
	 */
	public Float getCapacityFadeValue() {
		return this.capacityFadeValue;
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

		final CapacityFadeEntity that = (CapacityFadeEntity) o;
		return Objects.equals(capacityFadeValue, that.capacityFadeValue) && Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacityFadeValue, lastUpdate);
	}
}
