import interfaces.Cart;
import interfaces.Product;
import interfaces.impl.MyCart;
import interfaces.impl.MyProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IntegratedTest {
    Cart myCart;
    Product product;
    Product secondProduct;


    @Before
    public void setUp(){
        myCart = new MyCart();
        product = new MyProduct(true,1,59.99,"hules1");
        secondProduct = new MyProduct(false,2,1.01,"hules2");
    }

    @Test
    public void testAgregadoExitosamente(){
        String result = myCart.addProduct(product);
        result = myCart.addProduct(secondProduct);
        Assert.assertEquals("Producto Agregado Exitosamente",result);
    }
    @Test
    public void testProductoNoSePudoAgregar(){
        String result = myCart.addProduct(null);
        Assert.assertEquals("Producto No Se Pudo Agregar",result);
    }
    @Test
    public void testProductoExistente(){

        String result = myCart.addProduct(product);
        result = myCart.addProduct(secondProduct);
        String result2 = myCart.addProduct(product);
        Assert.assertEquals("Producto Ya Existe En El Carrito",result2);

    }
    @Test
    public void testProductoNoSePudoRemover(){
        String result = myCart.removeProduct(product);
        Assert.assertEquals("Producto No Se Encuentra En El Carrito",result);
    }
    @Test
    public void testProductoRemovidoExitosamente(){

        String result = myCart.addProduct(product);
        result = myCart.addProduct(secondProduct);
        String result2 = myCart.removeProduct(product);
        Assert.assertEquals("Producto Removido Exitosamente",result2);
    }
    @Test
    public void testCalculateSubtotal(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        double result  = myCart.calculateSubtotal();
        double subtotal = 59.99 +1.01;
        Assert.assertEquals(subtotal,result,.001);
    }

    @Test
    public void testCalculateTax(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        double result  = myCart.calculateTax();
        double subtotal = 59.99 * .16;
        Assert.assertEquals(subtotal,result,.001);
    }

    @Test
    public void testCalculateTotal(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        double result  = myCart.calculateTotal();
        double subtotal = (59.99 * 1.16) + 1.01;
        Assert.assertEquals(subtotal,result,.001);
    }
    @Test
    public void testCalculateLineSubtotal(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        double result  = myCart.calculateLineItemSubtotal(0);
        double subtotal = 59.99 ;
        Assert.assertEquals(subtotal,result,.001);
    }
    @Test
    public void testCalculateLineSubtotalNull(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        double result  = myCart.calculateLineItemSubtotal(2);
        double subtotal = 0 ;
        Assert.assertEquals(subtotal,result,.001);
    }

    @Test
    public void testAddQuantityToLineItem(){
        myCart.addProduct(product);
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        int result  = myCart.addQuantityToLineItem(0,2);
        int qty = 2 + 2 ;
        Assert.assertEquals(qty,result);
    }

    @Test
    public void testAddQuantityToLineItemNull(){
        myCart.addProduct(product);
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        int result  = myCart.addQuantityToLineItem(3,2);
        int qty = 0;
        Assert.assertEquals(qty,result);
    }

    @Test
    public void testRemoveQuantityToLineItem(){
        myCart.addProduct(product);
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        int result  = myCart.removeQuantityToLineItem(0,1);
        int qty = 1;
        Assert.assertEquals(qty,result);
    }
    @Test
    public void testRemoveQuantityToLineItemNull(){
        myCart.addProduct(product);
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        int result  = myCart.removeQuantityToLineItem(3,1);
        int qty = 0;
        Assert.assertEquals(qty,result);
    }

    @Test
    public void testRemoveQuantityToLineItemOvertake(){
        myCart.addProduct(product);
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        int result  = myCart.removeQuantityToLineItem(0,5);
        int qty = 0;
        Assert.assertEquals(qty,result);
    }

}
