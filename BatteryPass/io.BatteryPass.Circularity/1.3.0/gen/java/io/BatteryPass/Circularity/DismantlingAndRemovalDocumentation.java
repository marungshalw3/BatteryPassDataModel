
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

/**
 * Generated class for dismantling and removal documentation
 * (urn:samm:io.BatteryPass.Circularity:1.3.0#DismantlingAndRemovalDocumentation).
 * Dismantling and Removal information, including at least:- Exploded diagrams
 * of the battery system/pack showing the location of battery cells- Disassembly
 * sequences- Type and number of fastening techniques to be unlocked- Tools
 * required for disassembly- Warnings if risk of damaging parts exists- Amount
 * of cells used and layoutEUBR: Annex XIII (2c)
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:13:42.189+05")

public class DismantlingAndRemovalDocumentation {

	@NotNull
	private Documenttype documentType;

	@NotNull
	private String mimeType;

	@NotNull
	private URI documentURL;

	@JsonCreator
	public DismantlingAndRemovalDocumentation(@JsonProperty(value = "documentType") Documenttype documentType,
			@JsonProperty(value = "mimeType") String mimeType, @JsonProperty(value = "documentURL") URI documentURL) {
		super(

		);
		this.documentType = documentType;
		this.mimeType = mimeType;
		this.documentURL = documentURL;
	}

	/**
	 * Returns document type
	 *
	 * @return {@link #documentType}
	 */
	public Documenttype getDocumentType() {
		return this.documentType;
	}

	/**
	 * Returns mime type
	 *
	 * @return {@link #mimeType}
	 */
	public String getMimeType() {
		return this.mimeType;
	}

	/**
	 * Returns document URL
	 *
	 * @return {@link #documentURL}
	 */
	public URI getDocumentURL() {
		return this.documentURL;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final DismantlingAndRemovalDocumentation that = (DismantlingAndRemovalDocumentation) o;
		return Objects.equals(documentType, that.documentType) && Objects.equals(mimeType, that.mimeType)
				&& Objects.equals(documentURL, that.documentURL);
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentType, mimeType, documentURL);
	}
}
