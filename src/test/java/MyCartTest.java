import interfaces.Cart;
import interfaces.Product;
import interfaces.impl.MyCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Matchers.doubleThat;
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
        when(mockedProduct.getPrice()).thenReturn(2.00);
        when(secondMockedProduct.getPrice()).thenReturn(5.00);
        when(mockedProduct.isTaxeable()).thenReturn(true);
        when(secondMockedProduct.isTaxeable()).thenReturn(false);
    }

    @Test
    public void testAgregado(){
        String result = myCart.addProduct(mockedProduct);
        Assert.assertEquals("Producto Agregado Exitosamente",result);
        String result2 = myCart.addProduct(secondMockedProduct);
        Assert.assertEquals("Producto Agregado Exitosamente",result2);
}
    @Test
    public void testNoAgregado(){
        String result = myCart.addProduct(null);
        Assert.assertEquals("Producto No Se Pudo Agregar",result);
    }
    @Test
    public void testSiExistencia(){
        myCart.addProduct(mockedProduct);
        String result = myCart.addProduct(mockedProduct);
        Assert.assertEquals("Producto Ya Existe En El Carrito",result);
    }
    @Test
    public void testRemoveError(){
        String result = myCart.removeProduct(mockedProduct);
        Assert.assertEquals("Producto No Se Encuentra En El Carrito",result);
    }
    @Test
    public void testRemove(){
        myCart.addProduct(mockedProduct);
        String result = myCart.removeProduct(mockedProduct);
        Assert.assertEquals("Producto Removido Exitosamente",result);
    }
    @Test
    public void testCalcTotal(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        myCart.addQuantityToLineItem(0, 5);
        myCart.addQuantityToLineItem(1,2);
        double expected = myCart.calculateTotal();
        Assert.assertEquals(28.92,expected,.001);
    }
    @Test
    public void testCalcSubTotal() {
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(27.00, subtotal, 0);
    }
    @Test
    public void testCalcSubTotalError() {
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(23.00, subtotal, 0);
    }
    @Test
    public void testRemoveQty() {
        myCart.addProduct(mockedProduct);
        myCart.addQuantityToLineItem(0, 10);
        int remQty = myCart.removeQuantityToLineItem(0, 10);
        Assert.assertEquals(6, remQty);
    }
    @Test
    public void testRemoveQtyError(){
        int remQty = myCart.addQuantityToLineItem(0, 10);
        Assert.assertEquals(999, remQty);
    }
}
