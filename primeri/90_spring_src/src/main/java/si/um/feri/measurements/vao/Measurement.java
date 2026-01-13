package si.um.feri.measurements.vao;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import si.um.feri.measurements.Constants;
import si.um.feri.measurements.dto.post.PostMeasurement;

/**
 * A measurement of a product
 * Measurement type and Employee are just "markers"
 * Value - a measurement (temperature) being measured
 * isOK - regard to a product min-max
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Measurement")
public class Measurement {
	
	public Measurement(PostMeasurement m, Product p) {
		this.value=m.avgTemperature();
		this.measurementType=m.measurementType();
		this.subject=Constants.MeasurementSubjects.PRODUCT.getValue();
		this.product=p;
	}
	
	public si.um.feri.measurements.dto.Measurement toDto() {
		return new si.um.feri.measurements.dto.Measurement(
			id,
			Constants.JSON_DATE_FORMAT.format(created),
			(product!=null)?product.getId():-1,
			value,
			employee,
			isOk,
			measurementType
		);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

    @Column(name = "measurementvalue")
	private double value;
	
	private LocalDateTime created=LocalDateTime.now();
	
	private long createdLong=System.currentTimeMillis();
	
	private int subject=Constants.MeasurementSubjects.PRODUCT.getValue();
	
	private String measurementType;
	
	private String employee="Employee";

	private boolean isOk=true;
	
	@ManyToOne
	private Product product;

}
