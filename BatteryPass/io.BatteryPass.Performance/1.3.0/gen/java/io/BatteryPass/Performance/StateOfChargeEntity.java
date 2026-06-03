
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
 * Generated class for state of charge
 * (urn:samm:io.BatteryPass.Performance:1.3.0#StateOfChargeEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class StateOfChargeEntity {

	@NotNull
	private Float stateOfChargeValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public StateOfChargeEntity(@JsonProperty(value = "stateOfChargeValue") Float stateOfChargeValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.stateOfChargeValue = stateOfChargeValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns state of charge value
	 *
	 * @return {@link #stateOfChargeValue}
	 */
	public Float getStateOfChargeValue() {
		return this.stateOfChargeValue;
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

		final StateOfChargeEntity that = (StateOfChargeEntity) o;
		return Objects.equals(stateOfChargeValue, that.stateOfChargeValue)
				&& Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(stateOfChargeValue, lastUpdate);
	}
}
