import interfaces.Cart;
import interfaces.Product;
import interfaces.impl.MyCart;
import interfaces.impl.MyProduct;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntegrationTest {
    Cart myCart;
    Product product;
    Product secondProduct;
    Product thirdProduct;
    Product fourthProduct;



    @Before
    public void setUp(){
        myCart = new MyCart();
        product = new MyProduct("1", "Producto 1", "Descripcion producto 1", 1, true);
        secondProduct = new MyProduct("2", "Producto 2", "Descripcion producto 2", 1, false);
        thirdProduct = new MyProduct("3", "Producto 3", "Descripcion producto 3", 2, true);
        fourthProduct = new MyProduct("4", "Producto 4", "Descripcion producto 4", 2, false);
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
    public void testCalcularTotal(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        myCart.addProduct(thirdProduct);
        myCart.addProduct(fourthProduct);
        double result = myCart.calculateTotal();
        Assert.assertEquals(6.48, result, 0);
    }
    @Test
    public void testCalcularSubtotal(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        myCart.addProduct(thirdProduct);
        myCart.addProduct(fourthProduct);
        double subtotal = myCart.calculateSubtotal();
        Assert.assertEquals(6, subtotal,0);
    }
    @Test
    public void testCalcularTax(){
        myCart.addProduct(product);
        myCart.addProduct(secondProduct);
        myCart.addProduct(thirdProduct);
        myCart.addProduct(fourthProduct);
        double tax = myCart.calculateTax();
        Assert.assertEquals(0.48, tax, 0);
    }

    @Test
    public void testCalcularSubtotalLinea(){
        myCart.addProduct(product);
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(1, subtotal, 0);
    }
    @Test
    public void testCalcularSubtotalLineaEmpty(){
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(0, subtotal, 0);
    }

    @Test
    public void testCalcularSubtotalLineaWrongPos(){
        myCart.addProduct(product);
        double subtotal = myCart.calculateLineItemSubtotal(0);
        Assert.assertEquals(1, subtotal, 0);
    }

    @Test
    public void testAgregarCantidadLinea(){
        myCart.addProduct(product);
        int qty = myCart.addQuantityToLineItem(0,2);
        Assert.assertEquals(3,qty);
    }

    @Test
    public void testAgregarCantidadLineaWrongPos(){
        myCart.addProduct(product);
        int qty = myCart.addQuantityToLineItem(1,2);
        Assert.assertEquals(-1,qty);
    }

    @Test
    public void testRemoverCantidadLinea(){
        myCart.addProduct(product);
        myCart.addQuantityToLineItem(0,2);
        int qty = myCart.removeQuantityToLineItem(0,1);
        Assert.assertEquals(2,qty);
    }

    @Test
    public void testRemoverCantidadLineaWrongPos(){
        myCart.addProduct(product);
        myCart.addQuantityToLineItem(0,2);
        int qty = myCart.removeQuantityToLineItem(1,1);
        Assert.assertEquals(-1,qty);
    }
}
