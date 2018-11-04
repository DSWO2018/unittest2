import interfaces.Cart;
import interfaces.Product;
import interfaces.impl.MyCart;
import interfaces.impl.MyProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Integration {
    Cart myCart;
    Product product1;
    Product product2;

    @Before
    public void setUp(){
        myCart = new MyCart();
        product1 = new MyProduct(1, 50.00, "Mario Kart", "Videogame", true);
        product2 = new MyProduct(2, 20.00, "The Legend of Zelda", "Figure", false);

    }

    @Test
    public void testAgregadoExitosamente(){
        String result = myCart.addProduct(product1);
        result = myCart.addProduct(product2);
        Assert.assertEquals("Producto Agregado Exitosamente",result);
    }
    @Test
    public void testProductoNoSePudoAgregar(){
        String result = myCart.addProduct(null);
        Assert.assertEquals("Producto No Se Pudo Agregar",result);
    }
    @Test
    public void testProductoExistente(){

        String result = myCart.addProduct(product1);
        result = myCart.addProduct(product2);
        String result2 = myCart.addProduct(product1);
        Assert.assertEquals("Producto Ya Existe En El Carrito",result2);

    }
    @Test
    public void testProductoNoSePudoRemover(){
        String result = myCart.removeProduct(product1);
        Assert.assertEquals("Producto No Se Encuentra En El Carrito",result);
    }
    @Test
    public void testProductoRemovidoExitosamente(){

        String result = myCart.addProduct(product1);
        result = myCart.addProduct(product2);
        String result2 = myCart.removeProduct(product1);
        Assert.assertEquals("Producto Removido Exitosamente",result2);

    }
    @Test
    public void testCalcularTotal(){
        myCart.addProduct(product1);
        myCart.addProduct(product2);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        double total = myCart.calculateTotal();
        Assert.assertEquals(408.00, total, 0);
    }
    @Test
    public void testCalcularSubtotalExito(){
        myCart.addProduct(product1);
        myCart.addProduct(product2);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(360.00, subtotal, 0);
    }
    @Test
    public void testCalcularSubtotalError(){
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(0, subtotal,0);
    }
    @Test
    public void testCalcularTax(){
        myCart.addProduct(product1);
        myCart.addProduct(product2);
        myCart.addQuantityToLineItem(0,5);
        myCart.addQuantityToLineItem(1, 2);
        double tax = myCart.calculateTax();
        Assert.assertEquals(48, tax, 0);
    }

    @Test
    public void testCalcularSubtotalLineaExito(){
        myCart.addProduct(product1);
        myCart.addQuantityToLineItem(0,5);
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(300, subtotal, 0);

    }
    @Test
    public void testCalcularSubtotalLineaError(){
        myCart.addProduct(product1);
        myCart.addQuantityToLineItem(0,5);
        double subtotal = myCart.calculateLineItemSubtotal(1);
        Assert.assertEquals(0, subtotal, .001);
    }
    @Test
    public void testAgregarCantidadLineaExito(){
        myCart.addProduct(product1);
        int qty = myCart.addQuantityToLineItem(0,5);
        Assert.assertEquals(6,qty);
    }
    @Test
    public void testAgregarCantidadLineaError(){
        int qty = myCart.addQuantityToLineItem(0,5);
        Assert.assertEquals(999,qty);

    }
    @Test
    public void testRemoverCantidadLineaExito(){
        myCart.addProduct(product1);
        myCart.addQuantityToLineItem(0,5);
        int qty = myCart.removeQuantityToLineItem(0,5);
        Assert.assertEquals(1,qty);
    }
    @Test
    public void testRemoverCantidadLineaError(){
        int qty = myCart.addQuantityToLineItem(0,5);
        Assert.assertEquals(999,qty);

    }


}