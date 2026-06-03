
package io.BatteryPass.MaterialComposition;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;

/**
 * Generated class for material
 * (urn:samm:io.BatteryPass.MaterialComposition:1.3.0#BatteryMaterialEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:14:46.709+05")

public class BatteryMaterialEntity {

	@Valid

	@NotNull
	private BatteryLocationEntity batteryMaterialLocation;

	@NotNull
	@Pattern(regexp = "^\\d{2,7}-\\d{2}-\\d{1}$")

	private String batteryMaterialIdentifier;

	@NotNull
	private String batteryMaterialName;

	@NotNull
	private Float batteryMaterialMass;

	@NotNull
	private Boolean isCriticalRawMaterial;

	@JsonCreator
	public BatteryMaterialEntity(
			@JsonProperty(value = "batteryMaterialLocation") BatteryLocationEntity batteryMaterialLocation,
			@JsonProperty(value = "batteryMaterialIdentifier") String batteryMaterialIdentifier,
			@JsonProperty(value = "batteryMaterialName") String batteryMaterialName,
			@JsonProperty(value = "batteryMaterialMass") Float batteryMaterialMass,
			@JsonProperty(value = "isCriticalRawMaterial") Boolean isCriticalRawMaterial) {
		super(

		);
		this.batteryMaterialLocation = batteryMaterialLocation;
		this.batteryMaterialIdentifier = batteryMaterialIdentifier;
		this.batteryMaterialName = batteryMaterialName;
		this.batteryMaterialMass = batteryMaterialMass;
		this.isCriticalRawMaterial = isCriticalRawMaterial;
	}

	/**
	 * Returns location
	 *
	 * @return {@link #batteryMaterialLocation}
	 */
	public BatteryLocationEntity getBatteryMaterialLocation() {
		return this.batteryMaterialLocation;
	}

	/**
	 * Returns identifier
	 *
	 * @return {@link #batteryMaterialIdentifier}
	 */
	public String getBatteryMaterialIdentifier() {
		return this.batteryMaterialIdentifier;
	}

	/**
	 * Returns name
	 *
	 * @return {@link #batteryMaterialName}
	 */
	public String getBatteryMaterialName() {
		return this.batteryMaterialName;
	}

	/**
	 * Returns weight
	 *
	 * @return {@link #batteryMaterialMass}
	 */
	public Float getBatteryMaterialMass() {
		return this.batteryMaterialMass;
	}

	/**
	 * Returns is critical raw material
	 *
	 * @return {@link #isCriticalRawMaterial}
	 */
	public Boolean isIsCriticalRawMaterial() {
		return this.isCriticalRawMaterial;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final BatteryMaterialEntity that = (BatteryMaterialEntity) o;
		return Objects.equals(batteryMaterialLocation, that.batteryMaterialLocation)
				&& Objects.equals(batteryMaterialIdentifier, that.batteryMaterialIdentifier)
				&& Objects.equals(batteryMaterialName, that.batteryMaterialName)
				&& Objects.equals(batteryMaterialMass, that.batteryMaterialMass)
				&& Objects.equals(isCriticalRawMaterial, that.isCriticalRawMaterial);
	}

	@Override
	public int hashCode() {
		return Objects.hash(batteryMaterialLocation, batteryMaterialIdentifier, batteryMaterialName,
				batteryMaterialMass, isCriticalRawMaterial);
	}
}
