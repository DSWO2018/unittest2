import interfaces.Cart;
import interfaces.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.mock;
import static org.mockito.when;

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

        when(mockedProduct.getPrice()).thenReturn(98.99);
        when(mockedProduct.isTaxeable()).thenReturn(true);
        when(secondMockedProduct.getPrice()).thenReturn(1.01);
        when(secondMockedProduct.isTaxeable()).thenReturn(false);

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
    public void testCalculateSubtotal(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        double result  = myCart.calculateSubtotal();
        double subtotal = 98.99 +1.01;
        Assert.assertEquals(subtotal,result,result);
    }

    @Test
    public void testCalculateTax(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        double result  = myCart.calculateTax();
        double subtotal = 98.99 * .16;
        Assert.assertEquals(subtotal,result,result);
    }

    @Test
    public void testCalculateTotal(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        double result  = myCart.calculateTotal();
        double subtotal = (98.99 * .16) + 1.01;
        Assert.assertEquals(subtotal,result,result);
    }
    @Test
    public void testCalculateLineSubtotal(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        double result  = myCart.calculateLineItemSubtotal(0);
        double subtotal = 99.99 ;
        Assert.assertEquals(subtotal,result,result);
    }
    @Test
    public void testCalculateLineSubtotalNull(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        double result  = myCart.calculateLineItemSubtotal(2);
        double subtotal = 0 ;
        Assert.assertEquals(subtotal,result,result);
    }

    @Test
    public void testAddQuantityToLineItem(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        int result  = myCart.addQuantityToLineItem(0,2);
        int qty = 2 + 2 ;
        Assert.assertEquals(qty,result);
    }

    @Test
    public void testAddQuantityToLineItemNull(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        int result  = myCart.addQuantityToLineItem(3,2);
        int qty = 0;
        Assert.assertEquals(qty,result);
    }

    @Test
    public void testRemoveQuantityToLineItem(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        int result  = myCart.removeQuantityToLineItem(0,1);
        int qty = 1;
        Assert.assertEquals(qty,result);
    }
    @Test
    public void testRemoveQuantityToLineItemNull(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        int result  = myCart.removeQuantityToLineItem(3,1);
        int qty = 0;
        Assert.assertEquals(qty,result);
    }

    @Test
    public void testRemoveQuantityToLineItemOvertake(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        int result  = myCart.removeQuantityToLineItem(0,5);
        int qty = 0;
        Assert.assertEquals(qty,result);
    }
}


