
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
 * Generated class for reamining capacity
 * (urn:samm:io.BatteryPass.Performance:1.3.0#RemainingCapacityEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class RemainingCapacityEntity {

	@NotNull
	private Float remainingCapacityValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public RemainingCapacityEntity(@JsonProperty(value = "remainingCapacityValue") Float remainingCapacityValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.remainingCapacityValue = remainingCapacityValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns remaining capacility
	 *
	 * @return {@link #remainingCapacityValue}
	 */
	public Float getRemainingCapacityValue() {
		return this.remainingCapacityValue;
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

		final RemainingCapacityEntity that = (RemainingCapacityEntity) o;
		return Objects.equals(remainingCapacityValue, that.remainingCapacityValue)
				&& Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(remainingCapacityValue, lastUpdate);
	}
}
