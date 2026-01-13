package si.um.feri.measurements;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import si.um.feri.measurements.dto.Product;
import si.um.feri.measurements.dto.post.PostMeasurement;
import si.um.feri.measurements.rest.MeasurementHistoryController;
import si.um.feri.measurements.rest.MeasurementPostController;
import si.um.feri.measurements.rest.ProductController;

@SpringBootTest
//@ActiveProfiles("test")
public class RestScenarioTest {

    @Autowired
    ProductController productRest;

    @Autowired
    MeasurementPostController measurememtPostRest;

    @Autowired
    MeasurementHistoryController measurementHistoryRest;

    Product newProduct=null;

    @BeforeEach
    void createProduct() {
        newProduct=productRest.postProduct(
                new Product(0,"Product",22.0,-23.5)
        ).getBody();
    }

    @Test
    void checkProductExistence() {
        Product fromServer=productRest.getAllProductsById(newProduct.id()).getBody();
        assertEquals(fromServer.name(),newProduct.name());
        assertEquals(-23.5, fromServer.minMeasure(),0.0001);
    }

    @Test
    void newOKMeasurement() {
        String result=
                measurememtPostRest.postProductMeasurement(
                        new PostMeasurement(newProduct.id(),5.5,"MANUAL")
                ).getBody().result();
        assertEquals("ok",result);
    }

    @Test
    void newMeasurementForFakeProduct() {
        Object res=measurememtPostRest.postProductMeasurement(
                new PostMeasurement(1111,5.5,"MANUAL")
        ).getBody();
        assertInstanceOf(String.class,res);
        assertEquals("product-not-found",res.toString());
    }

    @Test
    void newNotOKMeasurement() {
        String result=
                measurememtPostRest.postProductMeasurement(
                        new PostMeasurement(newProduct.id(),-23.6,"MANUAL")
                ).getBody().result();
        assertEquals("not_ok",result);
    }

}
