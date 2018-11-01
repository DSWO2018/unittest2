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
        when(secondMockedProduct.getId()).thenReturn("2");
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
        double result = myCart.calculateTotal();
        Assert.assertEquals(0.00, result, 0);
    }
    public void testCalcularSubtotal(){
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(0, subtotal,0);
    }
    @Test
    public void testCalcularTax(){
        double tax = myCart.calculateTax();
        Assert.assertEquals(0, tax, 0);
    }
 
    @Test
    public void testCalcularSubtotalLinea(){
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(0, subtotal, 0);

    }
    public void testAgregarCantidadLinea(){
        myCart.addProduct(mockedProduct);
        int qty = myCart.addQuantityToLineItem(0,5);
        Assert.assertEquals(6,qty);
    }
    @Test
    public void testRemoverCantidadLinea(){
        myCart.addProduct(mockedProduct);
        myCart.addQuantityToLineItem(0,5);
        int qty = myCart.removeQuantityToLineItem(0,5);
        Assert.assertEquals(1,qty);
    }
}
