
package io.BatteryPass.GeneralProductInformation;

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
import javax.xml.datatype.XMLGregorianCalendar;
import org.eclipse.esmf.aspectmodel.java.exception.EnumAttributeNotFoundException;

/**
 * Generated class BatteryStatusEnumeration
 * (urn:samm:io.BatteryPass.GeneralProductInformation:1.3.0#BatteryStatusEnumeration).
 * Lifecycle status of the battery. Status defined from a list, with the options
 * suggested as follows: 'original', 'repurposed', 'reused', 'remanufactured',
 * 'waste'
 * 
 * EUBR: Annex XIII (4c)
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:14:04.137+05")
public enum BatteryStatusEnumeration {
	ORIGINAL("Original"), REPURPOSED("Repurposed"), REUSED("Reused"), REMANUFACTURED("Remanufactured"), WASTE("Waste");

	private String value;

	BatteryStatusEnumeration(String value) {
		this.value = value;
	}

	@JsonCreator
	static BatteryStatusEnumeration enumDeserializationConstructor(String value) {
		return fromValue(value).orElseThrow(() -> new EnumAttributeNotFoundException("Tried to parse value \"" + value
				+ "\", but there is no enum field like that in BatteryStatusEnumeration"));
	}

	@JsonValue
	public String getValue() {
		return value;
	}

	public static Optional<BatteryStatusEnumeration> fromValue(String value) {
		return Arrays.stream(BatteryStatusEnumeration.values()).filter(enumValue -> compareEnumValues(enumValue, value))
				.findAny();
	}

	private static boolean compareEnumValues(BatteryStatusEnumeration enumValue, String value) {
		return enumValue.getValue().equals(value);
	}

}
