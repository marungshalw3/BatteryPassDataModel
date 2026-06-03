
package io.BatteryPass.Circularity;

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
import org.eclipse.esmf.aspectmodel.java.customconstraint.FloatMax;
import org.eclipse.esmf.aspectmodel.java.customconstraint.FloatMin;
import org.eclipse.esmf.metamodel.BoundDefinition;

/**
 * Generated class for safety measures
 * (urn:samm:io.BatteryPass.Circularity:1.3.0#SafetyMeasuresEntity). The safety
 * measures should be provided via the instruction manual as URL linking to PDF.
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:13:42.189+05")

public class SafetyMeasuresEntity {

	@NotNull
	private URI safetyInstructions;

	@NotNull
	private List<String> extinguishingAgents;

	@JsonCreator
	public SafetyMeasuresEntity(@JsonProperty(value = "safetyInstructions") URI safetyInstructions,
			@JsonProperty(value = "extinguishingAgents") List<String> extinguishingAgents) {
		super(

		);
		this.safetyInstructions = safetyInstructions;
		this.extinguishingAgents = extinguishingAgents;
	}

	/**
	 * Returns safety instructions
	 *
	 * @return {@link #safetyInstructions}
	 */
	public URI getSafetyInstructions() {
		return this.safetyInstructions;
	}

	/**
	 * Returns extinguishing agents
	 *
	 * @return {@link #extinguishingAgents}
	 */
	public List<String> getExtinguishingAgents() {
		return this.extinguishingAgents;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final SafetyMeasuresEntity that = (SafetyMeasuresEntity) o;
		return Objects.equals(safetyInstructions, that.safetyInstructions)
				&& Objects.equals(extinguishingAgents, that.extinguishingAgents);
	}

	@Override
	public int hashCode() {
		return Objects.hash(safetyInstructions, extinguishingAgents);
	}
}
