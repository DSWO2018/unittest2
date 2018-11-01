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
        when(mockedProduct.getId()).thenReturn("1");
        when(mockedProduct.isTaxeable()).thenReturn(true);
        when(mockedProduct.getPrice()).thenReturn(1.0);
        when(secondMockedProduct.getId()).thenReturn("2");
        when(secondMockedProduct.isTaxeable()).thenReturn(false);
        when(secondMockedProduct.getPrice()).thenReturn(1.0);
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
        double result = myCart.calculateTotal();
        Assert.assertEquals(2.16, result, 0);
    }
    @Test
    public void testCalcularSubtotal(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(2, subtotal,0);
    }
    @Test
    public void testCalcularTax(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        double tax = myCart.calculateTax();
        Assert.assertEquals(0.16, tax, 0);
    }

    @Test
    public void testCalcularSubtotalLinea(){
        myCart.addProduct(mockedProduct);
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(1, subtotal, 0);
    }
    @Test
    public void testCalcularSubtotalLineaEmpty(){
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(0, subtotal, 0);
    }

    @Test
    public void testCalcularSubtotalLineaWrongPos(){
        myCart.addProduct(mockedProduct);
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(1, subtotal, 0);
    }

    @Test
    public void testAgregarCantidadLinea(){
        myCart.addProduct(mockedProduct);
        int qty = myCart.addQuantityToLineItem(0,2);
        Assert.assertEquals(3,qty);
    }

    @Test
    public void testAgregarCantidadLineaWrongPos(){
        myCart.addProduct(mockedProduct);
        int qty = myCart.addQuantityToLineItem(1,2);
        Assert.assertEquals(-1,qty);
    }

    @Test
    public void testRemoverCantidadLinea(){
        myCart.addProduct(mockedProduct);
        myCart.addQuantityToLineItem(0,2);
        int qty = myCart.removeQuantityToLineItem(0,1);
        Assert.assertEquals(2,qty);
    }

    @Test
    public void testRemoverCantidadLineaWrongPos(){
        myCart.addProduct(mockedProduct);
        myCart.addQuantityToLineItem(0,2);
        int qty = myCart.removeQuantityToLineItem(1,1);
        Assert.assertEquals(-1,qty);
    }
}