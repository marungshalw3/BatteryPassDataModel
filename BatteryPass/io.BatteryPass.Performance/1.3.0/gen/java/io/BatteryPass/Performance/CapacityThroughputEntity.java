
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
 * Generated class for capacity throughput
 * (urn:samm:io.BatteryPass.Performance:1.3.0#CapacityThroughputEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class CapacityThroughputEntity {

	@NotNull
	private Float capacityThroughputValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public CapacityThroughputEntity(@JsonProperty(value = "capacityThroughputValue") Float capacityThroughputValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.capacityThroughputValue = capacityThroughputValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns capacity throughput
	 *
	 * @return {@link #capacityThroughputValue}
	 */
	public Float getCapacityThroughputValue() {
		return this.capacityThroughputValue;
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

		final CapacityThroughputEntity that = (CapacityThroughputEntity) o;
		return Objects.equals(capacityThroughputValue, that.capacityThroughputValue)
				&& Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacityThroughputValue, lastUpdate);
	}
}
