package interfaces.impl;
import java.util.ArrayList;

/**
 * my cart.
 */
public class MyCart implements ICart {
    /**
     * arraylist.
     */
   private ArrayList<ProductStructure> productList;

    /**
     * constr.
     */
    public MyCart() {
        productList = new ArrayList<ProductStructure>();
    }

    /**
     * add prod.
     * @param product .
     * @return     */
    public final String addProduct(final IProduct product) {
        boolean productExists = false;
        if (product == null) {
            return "Producto No Se Pudo Agregar";
        }
        for (ProductStructure producttemp: productList
             ) {
            if (producttemp.getProd().getID() == product.getID()) {
                producttemp.setQty(producttemp.getqQty() + 1);
                productExists = true;
                break;
            }
        }
        if (!productExists) {
            productList.add(new ProductStructure(product));
            return "Producto Agregado Exitosamente";
        }
        else {
            return "Producto Ya Existe En El Carrito";
        }
    }

    /**
     * remove.
     * @param product .
     * @return     */
    public final String removeProduct(final IProduct product) {
        for (ProductStructure producttemp : productList) {
                if (producttemp.getProd().getID() == product.getID()) {
                    if (producttemp.getqQty() < 2) {
                        productList.remove(product);
                        return "Producto Removido Exitosamente";
                    }
                    else {
                        producttemp.setQty(producttemp.getqQty() - 1);
                        return
                                "Producto Removido Exitosamente" +
                                " pero aun queda alguno en el carro!";
                    }
                }
            }

        return "Producto No Se Encuentra En El Carrito";
    }

    /**
     * total.
     * @return     */
    public final double calculateTotal() {
        return calculateSubTotal() + calculateTax();
    }

    /**
     * sub total.
     * @return     */
    public final double calculateSubTotal() {
        return 0;
    }

    /**
     * tax.
     * @return     */
    public final double calculateTax() {
       final double num = .16;
        double total = 0.0;
        int cont = 0;
        while (cont < productList.size()) {
            if (productList.get(cont).getProd().isTaxeable()) {
                total = total + (calculateLineItemSubTotal(cont) * num);
            }
            cont++;
        }
        return total;
    }

    /**
     * line item subtotal.
     * @param pos .
     * @return     */
    public final double calculateLineItemSubTotal(final int pos) {
        while (pos < productList.size()) {
            double subTotal = productList.get(pos).getqQty();
            return subTotal * productList.get(pos).getProd().getPrice();
        }
        return 0;
    }

    /**
     * add quiantuti.
     * @param pos .
     * @param qty .
     * @return     */
    public final int addQuantityToLineItem(final int pos, final int qty) {
        while (pos < productList.size()) {
            productList.get(pos).setQty(productList.get(pos).getqQty()
                    + qty);
            return productList.get(pos).getqQty();
        }
        return 0;
    }

    /**
     * remove quintity.
     * @param pos .
     * @param qty .
     * @return     */
    public final int removeQuantityToLineItem(final int pos, final int qty) {
        while (pos < productList.size()) {
            //QUITAR Y ARREGLAR EL QTY!
            productList.get(pos).setQty(productList.get(pos).getqQty() - qty);
            if (productList.get(pos).getqQty() <= 0) {
                productList.get(pos).setQty(0);
                productList.remove(pos);
                return 0;
            } else {
                return productList.get(pos).getqQty();
            }
        }
        return 0;
    }

}

/**
 * estructura.
 */
class ProductStructure {
    /**
     * pord.
     */
   private IProduct prod;
    /**
     * qty.
     */
    private int qQty = 0;

    /**
     * get producro.
     * @return     */
    public final IProduct getProd() {
        return prod;
    }

    /**
     * set prod.
     * @param produ   */
    public final void setProd(final IProduct produ) {
        this.prod = produ;
    }

    /**
     * get cantidad.
     * @return     */
    public final int getqQty() {
        return qQty;
    }

    /**
     * set qty.
     * @param qty     */
    public final void setQty(final int qty) {
        qQty = qty;
    }

    /**
     * struct.
     * @param receivedProduct     */
    ProductStructure(final IProduct receivedProduct) {
        prod = receivedProduct;
        qQty += 1;
    }
}
