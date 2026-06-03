
package io.BatteryPass.GeneralProductInformation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Generated class for ContactInformationEntity
 * (urn:samm:io.BatteryPass.GeneralProductInformation:1.3.0#ContactInformationEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:14:04.137+05")

public class ContactInformationEntity {

	@NotNull
	private String contactName;

	@Valid

	@NotNull
	private PostalAddressEntity postalAddress;

	@NotNull
	private String identifier;
	private Optional<@Pattern(regexp = "^[w.-]+@[w.-]+.[A-Za-z]{2,}$") String> emailAddress;
	private Optional<URI> webAddress;

	@JsonCreator
	public ContactInformationEntity(@JsonProperty(value = "contactName") String contactName,
			@JsonProperty(value = "postalAddress") PostalAddressEntity postalAddress,
			@JsonProperty(value = "identifier") String identifier,
			@JsonProperty(value = "emailAddress") Optional<String> emailAddress,
			@JsonProperty(value = "webAddress") Optional<URI> webAddress) {
		super(

		);
		this.contactName = contactName;
		this.postalAddress = postalAddress;
		this.identifier = identifier;
		this.emailAddress = emailAddress == null ? Optional.empty() : emailAddress;
		this.webAddress = webAddress == null ? Optional.empty() : webAddress;
	}

	/**
	 * Returns contactName
	 *
	 * @return {@link #contactName}
	 */
	public String getContactName() {
		return this.contactName;
	}

	/**
	 * Returns postalAddress
	 *
	 * @return {@link #postalAddress}
	 */
	public PostalAddressEntity getPostalAddress() {
		return this.postalAddress;
	}

	/**
	 * Returns identifier
	 *
	 * @return {@link #identifier}
	 */
	public String getIdentifier() {
		return this.identifier;
	}

	/**
	 * Returns emailAddress
	 *
	 * @return {@link #emailAddress}
	 */
	public Optional<String> getEmailAddress() {
		return this.emailAddress;
	}

	/**
	 * Returns webAddress
	 *
	 * @return {@link #webAddress}
	 */
	public Optional<URI> getWebAddress() {
		return this.webAddress;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final ContactInformationEntity that = (ContactInformationEntity) o;
		return Objects.equals(contactName, that.contactName) && Objects.equals(postalAddress, that.postalAddress)
				&& Objects.equals(identifier, that.identifier) && Objects.equals(emailAddress, that.emailAddress)
				&& Objects.equals(webAddress, that.webAddress);
	}

	@Override
	public int hashCode() {
		return Objects.hash(contactName, postalAddress, identifier, emailAddress, webAddress);
	}
}
