package si.um.feri.measurements.vao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

/**
 * Product being measured
 * minMeasure - if a measurement of this product is below, the measurement will be marked as "not OK"
 * maxMeasure - if a measurement of this product is over, the measurement will be marked as "not OK"
 */
@Data
@NoArgsConstructor
@Entity
@Table(name = "Product")
public class Product {

	public Product(si.um.feri.measurements.dto.Product dto) {
		setName(dto.name());
		setMaxMeasure(dto.maxMeasure());
		setMinMeasure(dto.minMeasure());
	}
	
	public void updateFrom(si.um.feri.measurements.dto.Product dto) {
		setName(dto.name());
		setMaxMeasure(dto.maxMeasure());
		setMinMeasure(dto.minMeasure());
	}
	
	public si.um.feri.measurements.dto.Product toDto() {
		return new si.um.feri.measurements.dto.Product(
			getId(),
			getName(),
			maxMeasure,
			minMeasure);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int id;

	protected String name;

	protected LocalDateTime created=LocalDateTime.now();

	protected double maxMeasure;

	protected double minMeasure;

}
