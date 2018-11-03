import interfaces.impl.iCart;
import interfaces.impl.iProduct;
import interfaces.impl.MyCart;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class FinalTest {

    iCart myCar;
    iProduct producto;
    iProduct producto2;
//int ID, String name, Double price, String descripcion, boolean taxeable
    @Before
    public void setUp() {
        myCar = new MyCart();
        producto = new iProduct(1,"Mono navidad", 250.0,"Adorno navideño",true);
        producto2 = new iProduct(2,"Computadora", 25330.0,"Desktop laptop",true);
    }

    @Test
    public void testFinal() {
        myCar.addProduct(producto);
        producto.setTaxeable(true);
        myCar.addProduct(producto2);
        producto2.setTaxeable(true);
        myCar.addQuantityToLineItem(1,2);
        myCar.addQuantityToLineItem(2,1);
        double total = myCar.calculateTotal();
        assertEquals(25580+25580*.16,total,.001);
    }
}


