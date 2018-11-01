import interfaces.Cart;
import interfaces.Product;
import interfaces.impl.MyCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyCartTest {
    Cart myCart;
    Product mockedProduct;
    Product secondMockedProduct;


    @Before
    public void setUp(){
        myCart = new MyCart();
        mockedProduct = mock(Product.class);
        secondMockedProduct = mock(Product.class);
        when(mockedProduct.getID()).thenReturn(1);
        when(secondMockedProduct.getID()).thenReturn(2);
    }

    @Test
    public void testAgregadoExitosamente(){
        String result = myCart.addProduct(mockedProduct);
        result = myCart.addProduct(secondMockedProduct);
        Assert.assertEquals("Producto Agregado Exitosamente",result);
}
    @Test
    public void testProductoNoSePudoAgregar(){
        String result = myCart.addProduct(null);
        Assert.assertEquals("Producto No Se Pudo Agregar",result);
    }
    @Test
    public void testProductoExistente(){

        String result = myCart.addProduct(mockedProduct);
        result = myCart.addProduct(secondMockedProduct);
        String result2 = myCart.addProduct(mockedProduct);
        Assert.assertEquals("Producto Ya Existe En El Carrito",result2);

    }
    @Test
    public void testProductoNoSePudoRemover(){
        String result = myCart.removeProduct(mockedProduct);
        Assert.assertEquals("Producto No Se Encuentra En El Carrito",result);
    }
    @Test
    public void testProductoRemovidoExitosamente(){

        String result = myCart.addProduct(mockedProduct);
        result = myCart.addProduct(secondMockedProduct);
        String result2 = myCart.removeProduct(mockedProduct);
        Assert.assertEquals("Producto Removido Exitosamente",result2);

    }
    @Test
    public void testCalcularTotal(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        double result = myCart.calculateTotal();
        Assert.assertEquals(20.00, result, result);
    }
    @Test
    public void testCalcularSubtotalExito(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(20.00, subtotal, subtotal);
    }
    @Test
    public void testCalcularSubtotalError(){
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(0, subtotal,0);
    }
    @Test
    public void testCalcularTax(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        when(mockedProduct.isTaxeable()).thenReturn(true);
        when(secondMockedProduct.isTaxeable()).thenReturn(false);
        double tax = myCart.calculateTax();
        Assert.assertEquals(1.6, tax, tax);
    }

    @Test
    public void testCalcularSubtotalLineaExito(){
        myCart.addProduct(mockedProduct);
        myCart.addQuantityToLineItem(0,5);
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(10, subtotal, subtotal);

    }
    @Test
    public void testCalcularSubtotalLineaError(){
        myCart.addProduct(mockedProduct);
        myCart.addQuantityToLineItem(0,5);
        double subtotal = myCart.calculateLineItemSubtotal(1);
        Assert.assertEquals(0, subtotal, subtotal);
    }
    @Test
    public void testAgregarCantidadLineaExito(){
        myCart.addProduct(mockedProduct);
        int qty = myCart.addQuantityToLineItem(0,5);
        Assert.assertEquals(6,qty);
    }
    @Test
    public void testAgregarCantidadLineaError(){
        int qty = myCart.addQuantityToLineItem(0,5);
        Assert.assertEquals(-1,qty);

    }
    @Test
    public void testRemoverCantidadLineaExito(){
        myCart.addProduct(mockedProduct);
        myCart.addQuantityToLineItem(0,5);
        int qty = myCart.removeQuantityToLineItem(0,5);
        Assert.assertEquals(1,qty);
    }
    @Test
    public void testRemoverCantidadLineaError(){
        int qty = myCart.addQuantityToLineItem(0,5);
        Assert.assertEquals(-1,qty);

    }

}
