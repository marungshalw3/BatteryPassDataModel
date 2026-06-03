
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
 * Generated class for internal resistance
 * (urn:samm:io.BatteryPass.Performance:1.3.0#InternalResistanceEntity). The
 * internal resistance is a quotient of change of voltage of a battery by the
 * corresponding change in discharge current under specified conditions (IEV 482
 * 03 36).
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class InternalResistanceEntity {

	@NotNull
	private Double ohmicResistance;

	@NotNull
	private BatteryComponent batteryComponent;

	@JsonCreator
	public InternalResistanceEntity(@JsonProperty(value = "ohmicResistance") Double ohmicResistance,
			@JsonProperty(value = "batteryComponent") BatteryComponent batteryComponent) {
		super(

		);
		this.ohmicResistance = ohmicResistance;
		this.batteryComponent = batteryComponent;
	}

	/**
	 * Returns resistance
	 *
	 * @return {@link #ohmicResistance}
	 */
	public Double getOhmicResistance() {
		return this.ohmicResistance;
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

		final InternalResistanceEntity that = (InternalResistanceEntity) o;
		return Objects.equals(ohmicResistance, that.ohmicResistance)
				&& Objects.equals(batteryComponent, that.batteryComponent);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ohmicResistance, batteryComponent);
	}
}
