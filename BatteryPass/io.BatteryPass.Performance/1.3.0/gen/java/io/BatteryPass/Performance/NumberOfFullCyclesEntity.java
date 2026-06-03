
package io.BatteryPass.Performance;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * Generated class for number of full cycles
 * (urn:samm:io.BatteryPass.Performance:1.3.0#NumberOfFullCyclesEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class NumberOfFullCyclesEntity {

	@NotNull
	private BigInteger numberOfFullCyclesValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public NumberOfFullCyclesEntity(@JsonProperty(value = "numberOfFullCyclesValue") BigInteger numberOfFullCyclesValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.numberOfFullCyclesValue = numberOfFullCyclesValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns numberOfFullCyclesValue
	 *
	 * @return {@link #numberOfFullCyclesValue}
	 */
	public BigInteger getNumberOfFullCyclesValue() {
		return this.numberOfFullCyclesValue;
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

		final NumberOfFullCyclesEntity that = (NumberOfFullCyclesEntity) o;
		return Objects.equals(numberOfFullCyclesValue, that.numberOfFullCyclesValue)
				&& Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(numberOfFullCyclesValue, lastUpdate);
	}
}
