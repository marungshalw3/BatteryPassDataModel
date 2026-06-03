
package io.BatteryPass.Performance;

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
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Generated class for negative event
 * (urn:samm:io.BatteryPass.Performance:1.3.0#NegativeEventEntity).
 *
 */
@Generated(value = "esmf-sdk 2.14.3", date = "2026-06-03T19:15:08.410+05")

public class NegativeEventEntity {

	@NotNull
	private String negativeEvent;

	@NotNull
	private XMLGregorianCalendar lastUpdate;

	@JsonCreator
	public NegativeEventEntity(@JsonProperty(value = "negativeEvent") String negativeEvent,
			@JsonProperty(value = "lastUpdate") XMLGregorianCalendar lastUpdate) {
		super(

		);
		this.negativeEvent = negativeEvent;
		this.lastUpdate = lastUpdate;
	}

	/**
	 * Returns negative event
	 *
	 * @return {@link #negativeEvent}
	 */
	public String getNegativeEvent() {
		return this.negativeEvent;
	}

	/**
	 * Returns last update
	 *
	 * @return {@link #lastUpdate}
	 */
	public XMLGregorianCalendar getLastUpdate() {
		return this.lastUpdate;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final NegativeEventEntity that = (NegativeEventEntity) o;
		return Objects.equals(negativeEvent, that.negativeEvent) && Objects.equals(lastUpdate, that.lastUpdate);
	}

	@Override
	public int hashCode() {
		return Objects.hash(negativeEvent, lastUpdate);
	}
}
