
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
 * Generated class for evolution of self discharge
 * (urn:samm:io.BatteryPass.Performance:1.3.0#EvolutionOfSelfDischargeEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class EvolutionOfSelfDischargeEntity {

	@NotNull
	private Float evolutionOfSelfDischargeValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public EvolutionOfSelfDischargeEntity(
			@JsonProperty(value = "evolutionOfSelfDischargeValue") Float evolutionOfSelfDischargeValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.evolutionOfSelfDischargeValue = evolutionOfSelfDischargeValue;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns evolution of self discharge value
	 *
	 * @return {@link #evolutionOfSelfDischargeValue}
	 */
	public Float getEvolutionOfSelfDischargeValue() {
		return this.evolutionOfSelfDischargeValue;
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

		final EvolutionOfSelfDischargeEntity that = (EvolutionOfSelfDischargeEntity) o;
		return Objects.equals(evolutionOfSelfDischargeValue, that.evolutionOfSelfDischargeValue)
				&& Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(evolutionOfSelfDischargeValue, lastUpdate);
	}
}
