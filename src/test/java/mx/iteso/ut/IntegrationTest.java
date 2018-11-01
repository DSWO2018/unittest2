package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {

    ICart carrito;
    IProduct product1;
    IProduct product2;

    @Before
    public void setUp() {
        carrito = new MyCart();
        product1 = new Product("Bio-Shaker",100.00,"Mueve esos brazos de tamalera", 1);
        product2 = new Product("Discurso del método", 29.99, "Autor: Rene Descartes",2);
    }

    @Test
    public void testIntegracion() {
        carrito.addProduct(product1);
        carrito.addProduct(product2);
        product1.setTaxable(false);
        carrito.addQuantityToLineItem(0,2);
        carrito.addQuantityToLineItem(1,1);
        double result = carrito.calculateTotal();
        assertEquals(9.5968 + 359.98,result,.001);
    }
}
