package interfaces.impl;

import interfaces.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyProductTest {
    Product product;

    @Before
    public void setUp(){
        product = new MyProduct(1, 50.00, "Playera Negra", "Playera", true);
    }

    @Test
    public void testGetPrice() {
        assertEquals(50.00, product.getPrice(), 0);
    }

    @Test
    public void testGetDescription() {
        assertEquals("Playera Negra", product.getDescription());
    }

    @Test
    public void testSetPrice() {
        product.setPrice(30.00);
        assertEquals(30.00,product.getPrice(),0);
    }

    @Test
    public void testIsTaxeable() {
        assertEquals(true, product.isTaxeable());
    }

    @Test
    public void testSetTaxeable() {
        product.setTaxeable(false);
        assertEquals(false, product.isTaxeable());
    }

    @Test
    public void testGetName() {
        assertEquals("Playera", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("Playera Chida");
        assertEquals("Playera Chida", product.getName());
    }

    @Test
    public void tesGetID() {
        assertEquals(1, product.getID());
    }
}