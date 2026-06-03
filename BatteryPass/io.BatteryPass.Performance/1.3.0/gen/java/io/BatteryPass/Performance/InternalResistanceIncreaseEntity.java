
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
 * Generated class for internal resistance increase
 * (urn:samm:io.BatteryPass.Performance:1.3.0#InternalResistanceIncreaseEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class InternalResistanceIncreaseEntity {

	@NotNull
	private Float internalResistanceIncreaseValue;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@NotNull
	private BatteryComponent batteryComponent;

	@JsonCreator
	public InternalResistanceIncreaseEntity(
			@JsonProperty(value = "internalResistanceIncreaseValue") Float internalResistanceIncreaseValue,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate,
			@JsonProperty(value = "batteryComponent") BatteryComponent batteryComponent) {
		super(

		);
		this.internalResistanceIncreaseValue = internalResistanceIncreaseValue;
		this.lastUpdate = lastUpdate;
		this.batteryComponent = batteryComponent;
	}

	/**
	 * Returns internal resistance increase value
	 *
	 * @return {@link #internalResistanceIncreaseValue}
	 */
	public Float getInternalResistanceIncreaseValue() {
		return this.internalResistanceIncreaseValue;
	}

	/**
	 * Returns last update
	 *
	 * @return {@link #lastUpdate}
	 */
	public XMLGregorianCalendar getLastUpdate() {
		return this.lastUpdate;
	}

	/**
	 * Returns component
	 *
	 * @return {@link #batteryComponent}
	 */
	public BatteryComponent getBatteryComponent() {
		return this.batteryComponent;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final InternalResistanceIncreaseEntity that = (InternalResistanceIncreaseEntity) o;
		return Objects.equals(internalResistanceIncreaseValue, that.internalResistanceIncreaseValue)
				&& Objects.equals(lastUpdate, that.lastUpdate)
				&& Objects.equals(batteryComponent, that.batteryComponent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(internalResistanceIncreaseValue, lastUpdate, batteryComponent);
	}
}
