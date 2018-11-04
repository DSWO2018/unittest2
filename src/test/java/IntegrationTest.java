import interfaces.Cart;
import interfaces.ICart;
import interfaces.IProduct;
import interfaces.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegrationTest {
    private ICart myCart;
    private IProduct firstProduct;
    private IProduct secondProduct;

    @Before
    public void setUp(){
        myCart = new Cart();

        firstProduct = new Product(100, "Cable USB C for iPhone",
                true, "USB C Dongle", "USBC");
        secondProduct = new Product(200, "Cable USB A for iPhone",
                false, "USB A Dongle", "USBA");
    }

    @Test
    public void testAddProducts() {
        String result = myCart.addProduct(firstProduct);
        String result2 = myCart.addProduct(firstProduct);

        Assert.assertEquals("Producto Agregado Exitosamente", result);
        Assert.assertEquals("Producto Ya Existe En El Carrito", result2);
    }

    @Test
    public void testChargeProducts() {
        myCart.addProduct(firstProduct);
        myCart.addProduct(secondProduct);

        Assert.assertEquals(316, myCart.calculateTotal(), 0);
    }

    @Test
    public void testDeleteProducts() {
        myCart.addProduct(firstProduct);
        myCart.addProduct(secondProduct);

        Assert.assertEquals("Producto Removido Exitosamente", myCart.removeProduct(firstProduct));
    }

    @Test
    public void testFailDeleteProducts(){
        String result = myCart.removeProduct(firstProduct);
        Assert.assertEquals("Producto No Se Encuentra En El Carrito", result);
    }



}
