package interfaces.impl;

import interfaces.Product;

import java.util.ArrayList;

/**
 *
 */
public class MyCart implements interfaces.Cart {
    /****/
    private ArrayList<ProductStructure> productList;
    /****/
    public MyCart() {
        productList = new ArrayList<ProductStructure>();
    }

    /**
     * @param product .
     * @return .
     */
    public final String addProduct(final Product product) {
        boolean productExists = false;
        if (product == null) {
            return "Producto No Se Pudo Agregar";
        }
        for (ProductStructure producttemp: productList
             ) {
            if (producttemp.getProd().getID() == product.getID()) {
                producttemp.setQty(producttemp.getQty() + 1);
                productExists = true;
                break;
            }
        }
        if (!productExists) {
            productList.add(new ProductStructure(product));
            return "Producto Agregado Exitosamente";
        } else {
            return "Producto Ya Existe En El Carrito";
        }
    }

    /**
     * @param product .
     * @return .
     */
    public final String removeProduct(final Product product) {
        for (ProductStructure producttemp : productList) {
                if (producttemp.getProd().getID() == product.getID()) {
                    productList.remove(product);
                    return "Producto Removido Exitosamente";
                }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    /**
     * @return .
     */
    public final double calculateTotal() {
        double total = calculateSubtotal() + calculateTax();
        return total;
    }

    /**
     * @return .
     */
    public final double calculateSubtotal() {
        double subtotal = 0.0;
        for (int i = 0; i < productList.size(); i++) {
           subtotal += calculateLineItemSubtotal(i);
        }
        return subtotal;
    }

    /**
     * @return .
     */
    public final double calculateTax() {
        final double tax = 0.16;
        double totaltax = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProd().isTaxeable()) {
                totaltax += (calculateLineItemSubtotal(i) * tax);
            }
        }
        return totaltax;
    }

    /**
     * @param pos .
     * @return .
     */
    public final double calculateLineItemSubtotal(final int pos) {
        double itemSubtotal;
        if (pos < productList.size()) {
            itemSubtotal = productList.get(pos).getQty();
            return itemSubtotal * productList.get(pos).getProd().getPrice();
        } else {
            return 0;
        }
    }

    /**
     * @param pos .
     * @param qty .
     * @return .
     */
    public final int addQuantityToLineItem(final int pos, final int qty) {
        int quantity;
        if (pos < productList.size()) {
            productList.get(pos).setQty(productList.get(pos).getQty() + qty);
            quantity = productList.get(pos).getQty();
            return quantity;
        } else {
            return -1;
        }
    }

    /**
     * @param pos .
     * @param qty .
     * @return .
     */
    public final int removeQuantityToLineItem(final int pos, final int qty) {
        int quantity;
        if (pos < productList.size()) {
            productList.get(pos).setQty(productList.get(pos).getQty() - qty);
            if (productList.get(pos).getQty() <= 0) {
                productList.remove(pos);
                return 0;
            } else {
                quantity = productList.get(pos).getQty();
                return quantity;
            }
        } else {
            return -1;
        }
    }
}

/**
 *
 */
class ProductStructure {
    /****/
    private Product prod;
    /****/
    private int qty = 0;
    /**
     * @param receivedProduct .
     */
    ProductStructure(final Product receivedProduct) {
        prod = receivedProduct;
        qty += 1;
    }

    /**
     * @return .
     */
    public Product getProd() {
        return prod;
    }

    /**
     * @param p .
     */
    public void setProd(final Product p) {
        this.prod = p;
    }

    /**
     * @return .
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param q .
     */
    public void setQty(final int q) {
        this.qty = q;
    }
}
