
package io.BatteryPass.Circularity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;

/**
 * Generated class for ComponentEntity
 * (urn:samm:io.BatteryPass.Circularity:1.3.0#ComponentEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:13:42.189+05")

public class ComponentEntity {

	@NotNull
	private String partName;

	@NotNull
	private String partNumber;

	@JsonCreator
	public ComponentEntity(@JsonProperty(value = "partName") String partName,
			@JsonProperty(value = "partNumber") String partNumber) {
		super(

		);
		this.partName = partName;
		this.partNumber = partNumber;
	}

	/**
	 * Returns part name
	 *
	 * @return {@link #partName}
	 */
	public String getPartName() {
		return this.partName;
	}

	/**
	 * Returns part number
	 *
	 * @return {@link #partNumber}
	 */
	public String getPartNumber() {
		return this.partNumber;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final ComponentEntity that = (ComponentEntity) o;
		return Objects.equals(partName, that.partName) && Objects.equals(partNumber, that.partNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(partName, partNumber);
	}
}
