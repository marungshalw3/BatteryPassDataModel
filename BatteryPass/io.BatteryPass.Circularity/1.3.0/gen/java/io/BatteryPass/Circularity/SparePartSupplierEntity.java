
package io.BatteryPass.Circularity;

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
import org.eclipse.esmf.aspectmodel.java.customconstraint.FloatMax;
import org.eclipse.esmf.aspectmodel.java.customconstraint.FloatMin;
import org.eclipse.esmf.metamodel.BoundDefinition;

/**
 * Generated class for spare part supplier
 * (urn:samm:io.BatteryPass.Circularity:1.3.0#SparePartSupplierEntity). The part
 * numbers for components should be provided together with the postal address,
 * e-mail address and web address of the sources for spare parts.
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:13:42.189+05")

public class SparePartSupplierEntity {

	@NotNull
	private String nameOfSupplier;

	@Valid

	@NotNull
	private PostalAddress addressOfSupplier;

	@NotNull
	@Pattern(regexp = "^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$")

	private String emailAddressOfSupplier;

	@NotNull
	private URI supplierWebAddress;

	@Valid

	@NotNull
	private List<ComponentEntity> components;

	@JsonCreator
	public SparePartSupplierEntity(@JsonProperty(value = "nameOfSupplier") String nameOfSupplier,
			@JsonProperty(value = "addressOfSupplier") PostalAddress addressOfSupplier,
			@JsonProperty(value = "emailAddressOfSupplier") String emailAddressOfSupplier,
			@JsonProperty(value = "supplierWebAddress") URI supplierWebAddress,
			@JsonProperty(value = "components") List<ComponentEntity> components) {
		super(

		);
		this.nameOfSupplier = nameOfSupplier;
		this.addressOfSupplier = addressOfSupplier;
		this.emailAddressOfSupplier = emailAddressOfSupplier;
		this.supplierWebAddress = supplierWebAddress;
		this.components = components;
	}

	/**
	 * Returns name of supplier
	 *
	 * @return {@link #nameOfSupplier}
	 */
	public String getNameOfSupplier() {
		return this.nameOfSupplier;
	}

	/**
	 * Returns address of supplier
	 *
	 * @return {@link #addressOfSupplier}
	 */
	public PostalAddress getAddressOfSupplier() {
		return this.addressOfSupplier;
	}

	/**
	 * Returns e-mail address of supplier
	 *
	 * @return {@link #emailAddressOfSupplier}
	 */
	public String getEmailAddressOfSupplier() {
		return this.emailAddressOfSupplier;
	}

	/**
	 * Returns WEB address of supplier
	 *
	 * @return {@link #supplierWebAddress}
	 */
	public URI getSupplierWebAddress() {
		return this.supplierWebAddress;
	}

	/**
	 * Returns components
	 *
	 * @return {@link #components}
	 */
	public List<ComponentEntity> getComponents() {
		return this.components;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final SparePartSupplierEntity that = (SparePartSupplierEntity) o;
		return Objects.equals(nameOfSupplier, that.nameOfSupplier)
				&& Objects.equals(addressOfSupplier, that.addressOfSupplier)
				&& Objects.equals(emailAddressOfSupplier, that.emailAddressOfSupplier)
				&& Objects.equals(supplierWebAddress, that.supplierWebAddress)
				&& Objects.equals(components, that.components);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nameOfSupplier, addressOfSupplier, emailAddressOfSupplier, supplierWebAddress, components);
	}
}
