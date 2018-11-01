import interfaces.Cart;
import interfaces.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyCartTest {
    private Cart myCart;
    private Product mockedProduct;
    private Product secondMockedProduct;


    @Before
    public void setUp(){
        myCart = new Cart();
        mockedProduct = mock(Product.class);
        secondMockedProduct = mock(Product.class);
        when(mockedProduct.getID()).thenReturn("LR");
        when(secondMockedProduct.getID()).thenReturn("MR");
    }

    @Test
    public void testAgregadoExitosamente(){
        String result;
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
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        String result = myCart.addProduct(mockedProduct);
        Assert.assertEquals("Producto Ya Existe En El Carrito", result);

    }
    @Test
    public void testProductoNoSePudoRemover(){
        String result = myCart.removeProduct(mockedProduct);
        Assert.assertEquals("Producto No Se Encuentra En El Carrito",result);
    }
    @Test
    public void testProductoRemovidoExitosamente(){
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);
        String result = myCart.removeProduct(mockedProduct);
        Assert.assertEquals("Producto Removido Exitosamente",result);

    }


}
