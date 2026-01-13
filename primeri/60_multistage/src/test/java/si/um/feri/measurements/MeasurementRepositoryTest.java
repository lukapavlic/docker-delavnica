package si.um.feri.measurements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.um.feri.measurements.dao.MeasurementRepository;
import si.um.feri.measurements.dao.ProductRepository;
import si.um.feri.measurements.dto.post.PostMeasurement;
import si.um.feri.measurements.vao.Measurement;
import si.um.feri.measurements.vao.Product;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
//@ActiveProfiles("test")
public class MeasurementRepositoryTest {

    @Autowired
    private ProductRepository prodDao;

    @Autowired
    private MeasurementRepository dao;

    Product product1;
    Product product2;

    @BeforeEach
    void beforeAll() {
        dao.deleteAll();
        prodDao.deleteAll();
        product1=prodDao.save(new Product(new si.um.feri.measurements.dto.Product(
                0,"Test product 1",25.0,-12.5
        )));
        product2=prodDao.save(new Product(new si.um.feri.measurements.dto.Product(
                0,"Test product 2",25.0,-12.5
        )));
    }

    @Test
    void countByProductTest() {
        assertEquals(0,dao.count());
        assertEquals(0,dao.countByProduct(product1));
        assertEquals(0,dao.countByProduct(product2));

        dao.save(new Measurement(new PostMeasurement(0,15.0,"MANUAL"),product1));
        dao.save(new Measurement(new PostMeasurement(0,15.0,"MANUAL"),product1));
        dao.save(new Measurement(new PostMeasurement(0,15.0,"MANUAL"),product2));
        dao.save(new Measurement(new PostMeasurement(0,15.0,"MANUAL"),product2));
        dao.save(new Measurement(new PostMeasurement(0,15.0,"MANUAL"),product2));

        assertEquals(2,dao.countByProduct(product1));
        assertEquals(3,dao.countByProduct(product2));
    }

}
