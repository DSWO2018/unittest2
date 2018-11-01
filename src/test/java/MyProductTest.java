import interfaces.impl.iProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyProductTest {

        iProduct producto;

        @Before
        public void setUp() {
            producto = new iProduct(1, "Batman",300.0,"Comic book",true);
        }

        @Test
        public void testName() {
            producto.setName("Batman");
            Assert.assertEquals("Batman",producto.getName());
        }
        @Test
        public void testId() {
            producto.setId(1);
            Assert.assertEquals(1,producto.getID());
        }

        @Test
        public void testPrice() {
            producto.setPrice(300.0);
            Assert.assertEquals(300.0,producto.getPrice(),.001);
        }

        @Test
        public void testDescription() {
            producto.setDescripcion("Comic book");
            Assert.assertEquals("Comic book",producto.getDescription());
        }


        @Test
        public void testTaxeable() {
            producto.setTaxeable(false);
            Assert.assertEquals(false,producto.isTaxeable());
        }



}

