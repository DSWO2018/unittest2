import interfaces.IProduct;
import interfaces.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    private IProduct iProduct;

    @Before
    public void setUp(){
        iProduct = new Product(
                100.0,
                "Dongle",
                true,
                "USB C to lighting",
                "usbc"
        );
    }

    @Test
    public void testPrice() {
        Assert.assertEquals(iProduct.getPrice(),100,0);
        iProduct.setPrice(199.0);
        Assert.assertEquals(iProduct.getPrice(),199.0,0);
    }

    @Test
    public void testDescription() {
        Assert.assertEquals(iProduct.getDescription(),"Dongle");
    }

    @Test
    public void testTaxable() {
        Assert.assertTrue(iProduct.isTaxeable());
        iProduct.setTaxeable(false);
        Assert.assertFalse(iProduct.isTaxeable());
    }

    @Test
    public void testName() {
        Assert.assertEquals(iProduct.getName(),"USB C to lighting");
        iProduct.setName("USB-C to Lighting");
        Assert.assertEquals(iProduct.getName(),"USB-C to Lighting");
    }
    @Test
    public void testID() {
        Assert.assertEquals(iProduct.getID(),"usbc");
    }

}
