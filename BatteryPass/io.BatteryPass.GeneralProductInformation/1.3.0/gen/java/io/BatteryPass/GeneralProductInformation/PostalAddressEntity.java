
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
 * Generated class for PostalAddressEntity
 * (urn:samm:io.BatteryPass.GeneralProductInformation:1.3.0#PostalAddressEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:14:04.137+05")

public class PostalAddressEntity {

	@NotNull
	private String addressCountry;

	@NotNull
	private String postalCode;

	@NotNull
	private String streetAddress;

	@JsonCreator
	public PostalAddressEntity(@JsonProperty(value = "addressCountry") String addressCountry,
			@JsonProperty(value = "postalCode") String postalCode,
			@JsonProperty(value = "streetAddress") String streetAddress) {
		super(

		);
		this.addressCountry = addressCountry;
		this.postalCode = postalCode;
		this.streetAddress = streetAddress;
	}

	/**
	 * Returns addressCountry
	 *
	 * @return {@link #addressCountry}
	 */
	public String getAddressCountry() {
		return this.addressCountry;
	}

	/**
	 * Returns postalCode
	 *
	 * @return {@link #postalCode}
	 */
	public String getPostalCode() {
		return this.postalCode;
	}

	/**
	 * Returns streetAddress
	 *
	 * @return {@link #streetAddress}
	 */
	public String getStreetAddress() {
		return this.streetAddress;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final PostalAddressEntity that = (PostalAddressEntity) o;
		return Objects.equals(addressCountry, that.addressCountry) && Objects.equals(postalCode, that.postalCode)
				&& Objects.equals(streetAddress, that.streetAddress);
	}

	@Override
	public int hashCode() {
		return Objects.hash(addressCountry, postalCode, streetAddress);
	}
}
