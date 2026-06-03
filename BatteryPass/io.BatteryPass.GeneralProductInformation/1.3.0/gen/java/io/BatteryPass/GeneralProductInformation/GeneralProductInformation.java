
package io.BatteryPass.GeneralProductInformation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Generated class for GeneralProductInformation
 * (urn:samm:io.BatteryPass.GeneralProductInformation:1.3.0#GeneralProductInformation).
 * Mandatory data: Product identification; manufacturer?s identification;
 * manufacturing place; manufacturing date; battery category; battery weight;
 * battery status (Annex VI, Part A and Annex XIII) Copyright ? 2023 Circulor
 * (for and on behalf of the Battery Pass Consortium). This work is li-censed
 * under a Creative Commons License Attribution-NonCommercial 4.0 International
 * (CC BY-NC 4.0). Readers may reproduce material for their own publications, as
 * long as it is not sold com-mercially and is given appropriate attribution.
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:14:04.137+05")
public class GeneralProductInformation {

	@NotNull
	private String productIdentifier;

	@NotNull
	@Pattern(regexp = "^urn:[a-z0-9]+:[a-z0-9]+$")

	private String batteryPassportIdentifier;

	@NotNull
	private String batteryModelIdentifier;

	@NotNull
	private String batterySerialNumber;

	@NotNull
	private BatteryCategoryEnum batteryCategory;

	@Valid

	@NotNull
	private ContactInformationEntity manufacturerInformation;

	@NotNull
	private XMLGregorianCalendar manufacturingDate;

	@NotNull
	private BatteryStatusEnumeration batteryStatus;

	@NotNull
	private Float batteryMass;

	@Valid

	@NotNull
	private PostalAddressEntity manufacturingPlace;

	@Valid

	@NotNull
	private ContactInformationEntity operatorInformation;

	@NotNull
	private XMLGregorianCalendar puttingIntoService;

	@NotNull
	private XMLGregorianCalendar warrentyPeriod;
	private Optional<String> dppSchemaVersion;
	private Optional<DppStatusEnumeration> dppStatus;
	private Optional<DppGranularityEnumeration> dppGranularity;
	private Optional<XMLGregorianCalendar> dppLastUpdate;
	private Optional<String> facilityIdentifier;

	@JsonCreator
	public GeneralProductInformation(@JsonProperty(value = "productIdentifier") String productIdentifier,
			@JsonProperty(value = "batteryPassportIdentifier") String batteryPassportIdentifier,
			@JsonProperty(value = "batteryModelIdentifier") String batteryModelIdentifier,
			@JsonProperty(value = "batterySerialNumber") String batterySerialNumber,
			@JsonProperty(value = "batteryCategory") BatteryCategoryEnum batteryCategory,
			@JsonProperty(value = "manufacturerInformation") ContactInformationEntity manufacturerInformation,
			@JsonProperty(value = "manufacturingDate") XMLGregorianCalendar manufacturingDate,
			@JsonProperty(value = "batteryStatus") BatteryStatusEnumeration batteryStatus,
			@JsonProperty(value = "batteryMass") Float batteryMass,
			@JsonProperty(value = "manufacturingPlace") PostalAddressEntity manufacturingPlace,
			@JsonProperty(value = "operatorInformation") ContactInformationEntity operatorInformation,
			@JsonProperty(value = "puttingIntoService") XMLGregorianCalendar puttingIntoService,
			@JsonProperty(value = "warrentyPeriod") XMLGregorianCalendar warrentyPeriod,
			@JsonProperty(value = "dppSchemaVersion") Optional<String> dppSchemaVersion,
			@JsonProperty(value = "dppStatus") Optional<DppStatusEnumeration> dppStatus,
			@JsonProperty(value = "dppGranularity") Optional<DppGranularityEnumeration> dppGranularity,
			@JsonProperty(value = "dppLastUpdate") Optional<XMLGregorianCalendar> dppLastUpdate,
			@JsonProperty(value = "facilityIdentifier") Optional<String> facilityIdentifier) {
		super(

		);
		this.productIdentifier = productIdentifier;
		this.batteryPassportIdentifier = batteryPassportIdentifier;
		this.batteryModelIdentifier = batteryModelIdentifier;
		this.batterySerialNumber = batterySerialNumber;
		this.batteryCategory = batteryCategory;
		this.manufacturerInformation = manufacturerInformation;
		this.manufacturingDate = manufacturingDate;
		this.batteryStatus = batteryStatus;
		this.batteryMass = batteryMass;
		this.manufacturingPlace = manufacturingPlace;
		this.operatorInformation = operatorInformation;
		this.puttingIntoService = puttingIntoService;
		this.warrentyPeriod = warrentyPeriod;
		this.dppSchemaVersion = dppSchemaVersion == null ? Optional.empty() : dppSchemaVersion;
		this.dppStatus = dppStatus == null ? Optional.empty() : dppStatus;
		this.dppGranularity = dppGranularity == null ? Optional.empty() : dppGranularity;
		this.dppLastUpdate = dppLastUpdate == null ? Optional.empty() : dppLastUpdate;
		this.facilityIdentifier = facilityIdentifier == null ? Optional.empty() : facilityIdentifier;
	}

	/**
	 * Returns ProductIdentifier
	 *
	 * @return {@link #productIdentifier}
	 */
	public String getProductIdentifier() {
		return this.productIdentifier;
	}

	/**
	 * Returns BatteryPassportIdentifier
	 *
	 * @return {@link #batteryPassportIdentifier}
	 */
	public String getBatteryPassportIdentifier() {
		return this.batteryPassportIdentifier;
	}

	/**
	 * Returns battery model identifier
	 *
	 * @return {@link #batteryModelIdentifier}
	 */
	public String getBatteryModelIdentifier() {
		return this.batteryModelIdentifier;
	}

	/**
	 * Returns battery serial number
	 *
	 * @return {@link #batterySerialNumber}
	 */
	public String getBatterySerialNumber() {
		return this.batterySerialNumber;
	}

	/**
	 * Returns BatteryCategory
	 *
	 * @return {@link #batteryCategory}
	 */
	public BatteryCategoryEnum getBatteryCategory() {
		return this.batteryCategory;
	}

	/**
	 * Returns ManufacturerIdentification
	 *
	 * @return {@link #manufacturerInformation}
	 */
	public ContactInformationEntity getManufacturerInformation() {
		return this.manufacturerInformation;
	}

	/**
	 * Returns manufacturingDate
	 *
	 * @return {@link #manufacturingDate}
	 */
	public XMLGregorianCalendar getManufacturingDate() {
		return this.manufacturingDate;
	}

	/**
	 * Returns BatteryStatus
	 *
	 * @return {@link #batteryStatus}
	 */
	public BatteryStatusEnumeration getBatteryStatus() {
		return this.batteryStatus;
	}

	/**
	 * Returns batteryMass
	 *
	 * @return {@link #batteryMass}
	 */
	public Float getBatteryMass() {
		return this.batteryMass;
	}

	/**
	 * Returns ManufacturingPlace
	 *
	 * @return {@link #manufacturingPlace}
	 */
	public PostalAddressEntity getManufacturingPlace() {
		return this.manufacturingPlace;
	}

	/**
	 * Returns OperatorInformation
	 *
	 * @return {@link #operatorInformation}
	 */
	public ContactInformationEntity getOperatorInformation() {
		return this.operatorInformation;
	}

	/**
	 * Returns puttingIntoService
	 *
	 * @return {@link #puttingIntoService}
	 */
	public XMLGregorianCalendar getPuttingIntoService() {
		return this.puttingIntoService;
	}

	/**
	 * Returns warrentyPeriod
	 *
	 * @return {@link #warrentyPeriod}
	 */
	public XMLGregorianCalendar getWarrentyPeriod() {
		return this.warrentyPeriod;
	}

	/**
	 * Returns DPP schema version
	 *
	 * @return {@link #dppSchemaVersion}
	 */
	public Optional<String> getDppSchemaVersion() {
		return this.dppSchemaVersion;
	}

	/**
	 * Returns DPP status
	 *
	 * @return {@link #dppStatus}
	 */
	public Optional<DppStatusEnumeration> getDppStatus() {
		return this.dppStatus;
	}

	/**
	 * Returns DPP granularity
	 *
	 * @return {@link #dppGranularity}
	 */
	public Optional<DppGranularityEnumeration> getDppGranularity() {
		return this.dppGranularity;
	}

	/**
	 * Returns date-time of latest update of DPP
	 *
	 * @return {@link #dppLastUpdate}
	 */
	public Optional<XMLGregorianCalendar> getDppLastUpdate() {
		return this.dppLastUpdate;
	}

	/**
	 * Returns unique facility identifier
	 *
	 * @return {@link #facilityIdentifier}
	 */
	public Optional<String> getFacilityIdentifier() {
		return this.facilityIdentifier;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final GeneralProductInformation that = (GeneralProductInformation) o;
		return Objects.equals(productIdentifier, that.productIdentifier)
				&& Objects.equals(batteryPassportIdentifier, that.batteryPassportIdentifier)
				&& Objects.equals(batteryModelIdentifier, that.batteryModelIdentifier)
				&& Objects.equals(batterySerialNumber, that.batterySerialNumber)
				&& Objects.equals(batteryCategory, that.batteryCategory)
				&& Objects.equals(manufacturerInformation, that.manufacturerInformation)
				&& Objects.equals(manufacturingDate, that.manufacturingDate)
				&& Objects.equals(batteryStatus, that.batteryStatus) && Objects.equals(batteryMass, that.batteryMass)
				&& Objects.equals(manufacturingPlace, that.manufacturingPlace)
				&& Objects.equals(operatorInformation, that.operatorInformation)
				&& Objects.equals(puttingIntoService, that.puttingIntoService)
				&& Objects.equals(warrentyPeriod, that.warrentyPeriod)
				&& Objects.equals(dppSchemaVersion, that.dppSchemaVersion) && Objects.equals(dppStatus, that.dppStatus)
				&& Objects.equals(dppGranularity, that.dppGranularity)
				&& Objects.equals(dppLastUpdate, that.dppLastUpdate)
				&& Objects.equals(facilityIdentifier, that.facilityIdentifier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(productIdentifier, batteryPassportIdentifier, batteryModelIdentifier, batterySerialNumber,
				batteryCategory, manufacturerInformation, manufacturingDate, batteryStatus, batteryMass,
				manufacturingPlace, operatorInformation, puttingIntoService, warrentyPeriod, dppSchemaVersion,
				dppStatus, dppGranularity, dppLastUpdate, facilityIdentifier);
	}
}
