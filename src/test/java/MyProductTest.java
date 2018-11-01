import interfaces.impl.MyProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyProductTest {
    MyProduct product;
    @Before
    public void setUp(){
        product = new MyProduct("1", "Producto Test Name", "Producto Test Description",
                1, true);
    }

    @Test
    public void getPriceTest(){
        Assert.assertEquals(1, product.getPrice(), 0);
    }

    @Test
    public void getDescriptionTest(){
        Assert.assertEquals("Producto Test Description", product.getDescription());
    }

    @Test
    public void setPriceTest(){
        product.setPrice(10);
        Assert.assertEquals(10, product.getPrice(), 0);
    }

    @Test
    public void isTaxeableTest(){
        Assert.assertEquals(true, product.isTaxeable());
    }


    @Test
    public void setTaxeableTest(){
        product.setTaxeable(false);
        Assert.assertEquals(false, product.isTaxeable());
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("Producto Test Name", product.getName());
    }

    @Test
    public void setNameTest(){
        product.setName("Set Name Test");
        Assert.assertEquals("Set Name Test", product.getName());
    }

    @Test
    public void getIdTest(){
        Assert.assertEquals("1", product.getId());
    }

}
