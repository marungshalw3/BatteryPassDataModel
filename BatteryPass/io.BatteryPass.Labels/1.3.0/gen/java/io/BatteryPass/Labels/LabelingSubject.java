
package io.BatteryPass.Labels;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;
import org.eclipse.esmf.aspectmodel.java.CollectionAspect;
import org.eclipse.esmf.aspectmodel.java.exception.EnumAttributeNotFoundException;
import org.eclipse.esmf.metamodel.datatype.LangString;

/**
 * Generated class LabelingSubject
 * (urn:samm:io.BatteryPass.Labels:1.3.0#LabelingSubject).
 *
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:14:26.915+05")
public enum LabelingSubject {
	SEPARATE_COLLECTION("SeparateCollection"), HAZARDOUS_MATERIAL("HazardousMaterial"), CARBON_FOOT_PRINT(
			"CarbonFootPrint"), EXTINGUISHING_AGENT("ExtinguishingAgent");

	private String value;

	LabelingSubject(String value) {
		this.value = value;
	}

	@JsonCreator
	static LabelingSubject enumDeserializationConstructor(String value) {
		return fromValue(value).orElseThrow(() -> new EnumAttributeNotFoundException(
				"Tried to parse value \"" + value + "\", but there is no enum field like that in LabelingSubject"));
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public static Optional<LabelingSubject> fromValue(String value) {
		return Arrays.stream(LabelingSubject.values()).filter(enumValue -> compareEnumValues(enumValue, value))
				.findAny();
	}

	private static boolean compareEnumValues(LabelingSubject enumValue, String value) {
		return enumValue.getValue().equals(value);
	}

}
