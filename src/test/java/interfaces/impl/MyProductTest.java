package interfaces.impl;

import interfaces.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyProductTest {
    Product product;

    @Before
    public void setUp(){
        product = new MyProduct(1, 1500.00, "Mario Kart 8 Deluxe", "Videogame", true);
    }

    @Test
    public void testGetPrice() {
        assertEquals(1500.00, product.getPrice(), 0);
    }

    @Test
    public void testGetDescription() {
        assertEquals("Mario Kart 8 Deluxe", product.getDescription());
    }

    @Test
    public void testSetPrice() {
        product.setPrice(1300.00);
        assertEquals(1300.00,product.getPrice(),0);
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
        assertEquals("Videogame", product.getName());
    }

    @Test
    public void testSetName() {
        product.setName("Mario Kart 8");
        assertEquals("Mario Kart 8", product.getName());
    }

    @Test
    public void tesGetID() {
        assertEquals(1, product.getID());
    }
}