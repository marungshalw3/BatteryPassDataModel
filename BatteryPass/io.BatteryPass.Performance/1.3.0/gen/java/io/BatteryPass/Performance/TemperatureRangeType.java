
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
import org.eclipse.esmf.aspectmodel.java.customconstraint.DoubleMax;
import org.eclipse.esmf.aspectmodel.java.customconstraint.DoubleMin;
import org.eclipse.esmf.metamodel.BoundDefinition;

/**
 * Generated class for temperature range
 * (urn:samm:io.BatteryPass.Performance:1.3.0#TemperatureRangeType).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class TemperatureRangeType {

	@NotNull
	@DoubleMin(value = "-100.0", boundDefinition = BoundDefinition.AT_LEAST)
	@DoubleMax(value = "200.0", boundDefinition = BoundDefinition.AT_MOST)

	private Double minimum;

	@NotNull
	@DoubleMin(value = "-100.0", boundDefinition = BoundDefinition.AT_LEAST)
	@DoubleMax(value = "200.0", boundDefinition = BoundDefinition.AT_MOST)

	private Double maximum;

	@JsonCreator
	public TemperatureRangeType(@JsonProperty(value = "minimum") Double minimum,
			@JsonProperty(value = "maximum") Double maximum) {
		super(

		);
		this.minimum = minimum;
		this.maximum = maximum;
	}

	/**
	 * Returns minimum
	 *
	 * @return {@link #minimum}
	 */
	public Double getMinimum() {
		return this.minimum;
	}

	/**
	 * Returns maximum
	 *
	 * @return {@link #maximum}
	 */
	public Double getMaximum() {
		return this.maximum;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final TemperatureRangeType that = (TemperatureRangeType) o;
		return Objects.equals(minimum, that.minimum) && Objects.equals(maximum, that.maximum);
	}

	@Override
	public int hashCode() {
		return Objects.hash(minimum, maximum);
	}
}
