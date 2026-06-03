
package io.BatteryPass.Circularity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.eclipse.esmf.aspectmodel.java.customconstraint.FloatMax;
import org.eclipse.esmf.aspectmodel.java.customconstraint.FloatMin;
import org.eclipse.esmf.aspectmodel.java.exception.EnumAttributeNotFoundException;
import org.eclipse.esmf.metamodel.BoundDefinition;

/**
 * Generated class RecycledMaterial
 * (urn:samm:io.BatteryPass.Circularity:1.3.0#RecycledMaterial).
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:13:42.189+05")
public enum RecycledMaterial {
	COBALT("Cobalt"), NICKEL("Nickel"), LITHIUM("Lithium"), LEAD("Lead"), COBALT("Cobalt"), NICKEL("Nickel"), LITHIUM(
			"Lithium"), LEAD("Lead");

	private String value;

	RecycledMaterial(String value) {
		this.value = value;
	}

	@JsonCreator
	static RecycledMaterial enumDeserializationConstructor(String value) {
		return fromValue(value).orElseThrow(() -> new EnumAttributeNotFoundException(
				"Tried to parse value \"" + value + "\", but there is no enum field like that in RecycledMaterial"));
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public static Optional<RecycledMaterial> fromValue(String value) {
		return Arrays.stream(RecycledMaterial.values()).filter(enumValue -> compareEnumValues(enumValue, value))
				.findAny();
	}

	private static boolean compareEnumValues(RecycledMaterial enumValue, String value) {
		return enumValue.getValue().equals(value);
	}

}
