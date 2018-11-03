import interfaces.impl.MyProduct;
import org.junit.*;

/**
 * Created by Palaf on 03/11/2018.
 */
public class MyProductTest {

    MyProduct myProduct;



    @Before
    public void setUp(){
    myProduct = new MyProduct(true,2,55.5,"hules");
    }



    @Test
    public void testGetID() throws Exception {
        int resul = 2;
        Assert.assertEquals(resul,myProduct.getID());

    }

    @Test
    public void testGetPrice() throws Exception {
        double result = 55.5;
        Assert.assertEquals(result,myProduct.getPrice(),.01);
    }



    @Test
    public void testIsTaxeable() throws Exception {
        boolean result = true;
        Assert.assertEquals(result,myProduct.isTaxeable());
    }



    @Test
    public void testGetName() throws Exception {
        String result = "hules";
        Assert.assertEquals(result,myProduct.getName());
    }

}