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


}
