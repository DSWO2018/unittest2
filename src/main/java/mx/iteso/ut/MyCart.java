package mx.iteso.ut;

import java.util.ArrayList;

/**
 * Clase.
 */
public class MyCart implements ICart {

    /**
     * Variable.
     */
    private ArrayList<ProductStruct> productList;

    /**
     * Constructor.
     */
    public MyCart() {
        productList = new ArrayList<ProductStruct>();
    }

    /**
     * explicacion.
     * @param p producto
     * @return r.
     */
    public String addProduct(final IProduct p) {
        if (p == null) {
            return "Producto no se pudo agregar";
        }
        boolean productExists = false;
        for (ProductStruct productTemp: productList) {
            if (productTemp.product.getId() == p.getId()) {
                productTemp.quantity += 1;
                productExists = true;
                break;
            }
        }
        if (!productExists) {
            productList.add(new ProductStruct(p, 1));
            return "Producto agregado exitosamente";
        } else {

            return "Producto ya existe en el carrito";
        }
    }

    /**
     * explicacion.
     * @param p producto
     * @return r.
     */
    public String removeProduct(final IProduct p) {
        for (ProductStruct producttemp : productList) {
            if (producttemp.product.getId() == p.getId()) {
                productList.remove(producttemp.product);
                return "Producto Removido Exitosamente";
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    /**
     * explicacion.
     * @return r.
     */
    public double calculateTotal() {
        return calculateSubTotal() + calculateTax();
    }

    /**
     * explicacion.
     * @return r.
     */
    public double calculateSubTotal() {
        double total = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            total += calculateLineItemSubTotal(i);
        }
        return total;
    }

    /**
     * explicacion.
     * @return r.
     */
    public double calculateTax() {
        final double tax = 0.16;
        double total = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).product.isTaxable()) {
                total += (calculateLineItemSubTotal(i) * tax);
            }
        }
        return total;
    }

    /**
     * explicacion.
     * @param pos p.
     * @return r.
     */
    public double calculateLineItemSubTotal(final int pos) {
        if (pos >= productList.size()) {
            return 0;
        } else {
            double qty = (double) (productList.get(pos).quantity);
            return qty * productList.get(pos).product.getPrice();
        }
    }

    /**
     * explicacion.
     * @param pos p.
     * @param qty q.
     * @return r.
     */
    public int addQuantityToLineItem(final int pos, final int qty) {
        if (pos >= productList.size()) {
            return -1;
        } else {
            productList.get(pos).quantity += qty;
            return productList.get(pos).quantity;
        }
    }

    /**
     * explicacion.
     * @param pos p.
     * @param qty q.
     * @return r.
     */
    public int removeQuantityToLineItem(final int pos, final int qty) {
        if (pos >= productList.size()) {
            return -1;
        } else {
            productList.get(pos).quantity -= qty;
            if (productList.get(pos).quantity <= 0) {
                productList.remove(pos);
                return 0;
            } else {
                return productList.get(pos).quantity;
            }
        }
    }
}

/**
 *
 */
class ProductStruct {
    /**
     * product.
     */
    public IProduct product;

    /**
     * product.
     */
    public int quantity;

    /**
     *
     * @param p p.
     * @param q q.
     */
    ProductStruct(final IProduct p, final int q) {
        this.product = p;
        this.quantity = q;
    }
}
