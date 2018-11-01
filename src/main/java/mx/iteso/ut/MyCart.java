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
    public final String addProduct(final IProduct p) {
        if (p == null) {
            return "Producto no se pudo agregar";
        }
        boolean productExists = false;
        for (ProductStruct productTemp: productList) {
            if (productTemp.getProduct().getId() == p.getId()) {
                productTemp.setQuantity(productTemp.getQuantity() + 1);
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
    public final String removeProduct(final IProduct p) {
        for (ProductStruct producttemp : productList) {
            if (producttemp.getProduct().getId() == p.getId()) {
                productList.remove(producttemp.getProduct());
                return "Producto Removido Exitosamente";
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    /**
     * explicacion.
     * @return r.
     */
    public final double calculateTotal() {
        return calculateSubTotal() + calculateTax();
    }

    /**
     * explicacion.
     * @return r.
     */
    public final double calculateSubTotal() {
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
    public final double calculateTax() {
        final double tax = 0.16;
        double total = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProduct().isTaxable()) {
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
    public final double calculateLineItemSubTotal(final int pos) {
        if (pos >= productList.size()) {
            return 0;
        } else {
            double qty = (double) (productList.get(pos).getQuantity());
            return qty * productList.get(pos).getProduct().getPrice();
        }
    }

    /**
     * explicacion.
     * @param pos p.
     * @param qty q.
     * @return r.
     */
    public final int addQuantityToLineItem(final int pos, final int qty) {
        if (pos >= productList.size()) {
            return -1;
        } else {
            productList.get(pos).setQuantity(productList.get(pos).getQuantity()
                    + qty);
            return productList.get(pos).getQuantity();
        }
    }

    /**
     * explicacion.
     * @param pos p.
     * @param qty q.
     * @return r.
     */
    public final int removeQuantityToLineItem(final int pos, final int qty) {
        if (pos >= productList.size()) {
            return -1;
        } else {
            productList.get(pos).setQuantity(productList.get(pos).getQuantity()
                    - qty);
            if (productList.get(pos).getQuantity() <= 0) {
                productList.remove(pos);
                return 0;
            } else {
                return productList.get(pos).getQuantity();
            }
        }
    }
}

/**
 *
 */
class ProductStruct {

    /**
     * producto.
     */
    private IProduct product;

    /**
     * cantidad.
     */
    private int quantity;

    /**
     *
     * @param p p.
     * @param q q.
     */
    ProductStruct(final IProduct p, final int q) {
        this.setProduct(p);
        this.setQuantity(q);
    }

    /**
     * metodo.
     * @return cantidad.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     *
     * @param q cantidad
     */
    public void setQuantity(final int q) {
        this.quantity = q;
    }

    /**
     * producto.
     * @return producto
     */
    public IProduct getProduct() {
        return product;
    }

    /**
     *
     * @param p p.
     */
    public void setProduct(final IProduct p) {
        this.product = p;
    }
}
