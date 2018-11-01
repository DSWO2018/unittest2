package mx.iteso.ut;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MyCartTest {
    ICart carrito;
    IProduct mockedProduct1;
    IProduct mockedProduct2;

    @Before
    public void setUp() {
        carrito = new MyCart();
        mockedProduct1 = mock(IProduct.class);
        mockedProduct2 = mock(IProduct.class);
    }

    @Test
    public void testAgregadoExitosamente() {
        when(mockedProduct1.getId()).thenReturn(1);
        when(mockedProduct2.getId()).thenReturn(2);
        carrito.addProduct(mockedProduct1);
        String result = carrito.addProduct(mockedProduct2);
        assertEquals("Producto agregado exitosamente", result);
    }

    @Test
    public void testProductoNoSePuedeAgregar() {
        String result = carrito.addProduct(null);
        assertEquals("Producto no se pudo agregar", result);
    }

    @Test
    public void testProductoYaExiste() {
        carrito.addProduct(mockedProduct1);
        String result = carrito.addProduct(mockedProduct1);
        assertEquals("Producto ya existe en el carrito", result);
    }

    @Test
    public void testProductoNoSePudoRemover() {
        String result = carrito.removeProduct(mockedProduct1);
        assertEquals("Producto No Se Encuentra En El Carrito",result);
    }
    @Test
    public void testProductoRemovidoExitosamente() {
        String result = carrito.addProduct(mockedProduct1);
        result = carrito.addProduct(mockedProduct2);
        String result2 = carrito.removeProduct(mockedProduct1);
        assertEquals("Producto Removido Exitosamente",result2);
    }

    @Test
    public void testQuantityAddedToLineItemSuccess() {
        when(mockedProduct1.getId()).thenReturn(1);
        when(mockedProduct2.getId()).thenReturn(2);
        carrito.addProduct(mockedProduct1);
        carrito.addProduct(mockedProduct2);
        int result = carrito.addQuantityToLineItem(1,5);
        assertEquals(6,result);
    }

    @Test
    public void testQuantityAddedToLineItemFail() {
        when(mockedProduct1.getId()).thenReturn(1);
        when(mockedProduct2.getId()).thenReturn(2);
        carrito.addProduct(mockedProduct1);
        carrito.addProduct(mockedProduct2);
        int result = carrito.addQuantityToLineItem(2,5);
        assertEquals(-1,result); //Como el producto no fue agregado en un principio, no se le puede sumar nada
    }

    @Test
    public void testRemoveQuantityToLineItemSuccess() {
        carrito.addProduct(mockedProduct1);
        carrito.addQuantityToLineItem(0,5);
        int result = carrito.removeQuantityToLineItem(0,3);
        assertEquals(3,result);
    }

    @Test
    public void testRemoveQuantityToLineItemNonExistentProduct() {
        when(mockedProduct1.getId()).thenReturn(1);
        when(mockedProduct2.getId()).thenReturn(2);
        carrito.addProduct(mockedProduct1);
        carrito.addProduct(mockedProduct2);
        int result = carrito.removeQuantityToLineItem(2,5);
        assertEquals(-1,result);
    }

    @Test
    public void testRemoveQuantityToLineItemNoNegatives() {
        carrito.addProduct(mockedProduct1);
        int result = carrito.removeQuantityToLineItem(0,5);
        String result2 = carrito.removeProduct(mockedProduct1);
        assertEquals("Producto No Se Encuentra En El Carrito",result2);
        assertEquals(0,result);
    }

    @Test
    public void testCalculateLineItemSubTotalSuccess() {
        carrito.addProduct(mockedProduct1);
        when(mockedProduct1.getPrice()).thenReturn(99.99);
        carrito.addQuantityToLineItem(0,2);
        double result = carrito.calculateLineItemSubTotal(0);
        assertEquals(299.97, result,.001);
    }

    @Test
    public void testCalculateLineItemSubTotalNonExistentProduct() {
        carrito.addProduct(mockedProduct1);
        when(mockedProduct1.getPrice()).thenReturn(100.0);
        carrito.addQuantityToLineItem(0,2);
        double result = carrito.calculateLineItemSubTotal(1);
        assertEquals(0, result,0);
    }

    @Test
    public void testCalculateSubTotalSuccess() {
        when(mockedProduct1.getId()).thenReturn(1);
        when(mockedProduct2.getId()).thenReturn(2);
        carrito.addProduct(mockedProduct1);
        carrito.addProduct(mockedProduct2);
        when(mockedProduct1.getPrice()).thenReturn(100.0);
        when(mockedProduct2.getPrice()).thenReturn(29.99);
        carrito.addQuantityToLineItem(0,2);
        carrito.addQuantityToLineItem(1,1);
        double result = carrito.calculateSubTotal();
        assertEquals(359.98, result,0);
    }

    @Test
    public void testCalculateSubTotalWhenEmpty() {
        double result = carrito.calculateSubTotal();
        assertEquals(0, result,0);
    }

    //Me parece que con este test se cubren todos los casos
    @Test
    public void testCalculateTaxMixed() {
        when(mockedProduct1.getId()).thenReturn(1);
        when(mockedProduct2.getId()).thenReturn(2);
        carrito.addProduct(mockedProduct1);
        carrito.addProduct(mockedProduct2);
        when(mockedProduct1.getPrice()).thenReturn(100.0);
        when(mockedProduct2.getPrice()).thenReturn(29.99);
        when(mockedProduct1.isTaxable()).thenReturn(false);
        when(mockedProduct2.isTaxable()).thenReturn(true);
        carrito.addQuantityToLineItem(0,2);
        carrito.addQuantityToLineItem(1,1);
        double result = carrito.calculateTax();
        assertEquals(9.5968,result,.001);
    }

    public void testCalculateTotal() {
        when(mockedProduct1.getId()).thenReturn(1);
        when(mockedProduct2.getId()).thenReturn(2);
        carrito.addProduct(mockedProduct1);
        carrito.addProduct(mockedProduct2);
        when(mockedProduct1.getPrice()).thenReturn(100.0);
        when(mockedProduct2.getPrice()).thenReturn(29.99);
        when(mockedProduct1.isTaxable()).thenReturn(false);
        when(mockedProduct2.isTaxable()).thenReturn(true);
        carrito.addQuantityToLineItem(0,2);
        carrito.addQuantityToLineItem(1,1);
        double result = carrito.calculateTotal();
        assertEquals(9.5968 + 359.98,result,.001);
    }


}
