package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ProductTest {
    IProduct producto;

    @Before
    public void setUp() {
        producto = new Product("Harry Potter y el prisionero de Askaban", 29.99,"YA Novel",3);
    }

    @Test
    public void testGetId() {
        assertEquals(3,producto.getId());
    }

    @Test
    public void testSetAndGetPrice() {
        producto.setPrice(59.99);
        assertEquals(59.99,producto.getPrice(),.001);
    }

    @Test
    public void testGetDescription() {
        assertEquals("YA Novel",producto.getDescription());
    }

    @Test
    public void testSetAndGetName() {
        producto.setName("HP y el prisionero de Azkaban");
        assertEquals("HP y el prisionero de Azkaban",producto.getName());
    }

    @Test
    public void testSetAndGetTaxable() {
        producto.setTaxable(false);
        assertEquals(false,producto.isTaxable());
    }



}
