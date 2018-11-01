import interfaces.Cart;
import interfaces.ICart;
import interfaces.IProduct;
import interfaces.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MyCartTest {
    private ICart myCart;
    private IProduct mockedProduct;
    private IProduct secondMockedProduct;


    @Before
    public void setUp(){
        myCart = new Cart();
        mockedProduct = mock(Product.class);
        secondMockedProduct = mock(Product.class);
        when(mockedProduct.getID()).thenReturn("LR");
        when(secondMockedProduct.getID()).thenReturn("MR");

        when(mockedProduct.getPrice()).thenReturn(100.0);
        when(secondMockedProduct.getPrice()).thenReturn(100.0);

        when(mockedProduct.isTaxeable()).thenReturn(true);
        when(secondMockedProduct.isTaxeable()).thenReturn(false);

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

    @Test
    public void testCalculateTotal() {
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(mockedProduct));
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(secondMockedProduct));

        double result = myCart.calculateTotal();

        Assert.assertEquals(216,result,0);
    }

    @Test
    public void testCalculateSubtotal() {
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(mockedProduct));
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(secondMockedProduct));

        double result = myCart.calculateSubtotal();

        Assert.assertEquals(200,result,0);
    }

    @Test
    public void testCalculateTax() {
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(mockedProduct));
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(secondMockedProduct));

        double result = myCart.calculateTax();

        Assert.assertEquals(16,result,0);
    }

    @Test
    public void testCalculateLineItemSubtotal() {
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(mockedProduct));
        Assert.assertEquals("Producto Ya Existe En El Carrito", myCart.addProduct(mockedProduct));
        Assert.assertEquals("Producto Agregado Exitosamente", myCart.addProduct(secondMockedProduct));

        double result = myCart.calculateLineItemSubtotal(0);
        double result2 = myCart.calculateLineItemSubtotal(1);
        double result3 = myCart.calculateLineItemSubtotal(2);

        Assert.assertEquals(200,result,0);
        Assert.assertEquals(100,result2,0);
        Assert.assertEquals(0,result3,0);
    }

    @Test
    public void testAddQuantityToLineItem() {
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);

        double result = myCart.addQuantityToLineItem(0,2);
        double result2 = myCart.addQuantityToLineItem(1,3);
        double result3 = myCart.addQuantityToLineItem(2,3);

        Assert.assertEquals(3,result,0);
        Assert.assertEquals(4,result2,0);
        Assert.assertEquals(0,result3,0);
    }

    @Test
    public void testRemoveQuantityToLineItem() {
        myCart.addProduct(mockedProduct);
        myCart.addProduct(mockedProduct);
        myCart.addProduct(secondMockedProduct);

        double result = myCart.removeQuantityToLineItem(0,1);
        double result2 = myCart.removeQuantityToLineItem(1,1);
        double result3 = myCart.removeQuantityToLineItem(2,3);

        Assert.assertEquals(1,result,0);
        Assert.assertEquals(0,result2,0);
        Assert.assertEquals(0,result3,0);
    }

}
