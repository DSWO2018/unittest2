
package interfaces.impl;

import interfaces.Product;

import java.util.ArrayList;

/**MyCart Class.*/
public class MyCart implements interfaces.Cart {
    /** var productList.*/
    private ArrayList<ProductStructure> productList;
    /** var IVA.*/
    private static final double IVA = 0.16;
    /** MyCart constructor.*/
    public MyCart() {
        productList = new ArrayList<ProductStructure>();
    }
    /**addProduct Function.
     * @param product .
     * @return String*/
    public final String addProduct(final Product product) {
        boolean productExists = false;
        if (product == null) {
            return "Producto No Se Pudo Agregar";
        }
        for (ProductStructure producttemp: productList
             ) {
            if (producttemp.getProd().getId() == product.getId()) {
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
    /**removeProduct Function.
     * @param product .
     * @return String*/
    public final String removeProduct(final Product product) {
        for (ProductStructure producttemp : productList) {
            if (producttemp.getProd().getId() == product.getId()) {
                productList.remove(product);
                return "Producto Removido Exitosamente";
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }
    /**calculateTotal Function.
     * @return double*/
    public final double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }
    /**calculateSubtotal Function.
     * @return double*/
    public final double calculateSubtotal() {
        double sub = 0.0;
        for (ProductStructure product : productList) {
            sub += product.getProd().getPrice() * product.getQty();
        }
        return sub;
    }
    /**calculateTax Function.
     * @return String*/
    public final double calculateTax() {
        double tax = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProd().isTaxeable()) {
                tax += (calculateLineItemSubtotal(i) * IVA);
            }
        }
        return tax;
    }
    /**calculateLineItemSubtotal Function.
     * @param pos .
     * @return double*/
    public final double calculateLineItemSubtotal(final int pos) {
        double itemSubtotal;
        if (pos < productList.size()) {
            itemSubtotal = productList.get(pos).getQty();
            return itemSubtotal * productList.get(pos).getProd().getPrice();
        } else {
            return 0;
        }
    }
    /**addQuantityToLineItem Function.
     * @param pos .
     * @param qty .
     * @return int*/
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
    /**removeQuantityToLineItem Function.
     * @param pos .
     * @param qty .
     * @return int*/
    public final int removeQuantityToLineItem(final int pos, final int qty) {
        if (pos < productList.size()) {
            productList.get(pos).setQty(productList.get(pos).getQty() - qty);
            if (productList.get(pos).getQty() <= 0) {
                productList.remove(pos);
                return 0;
            } else {
                return productList.get(pos).getQty();
            }
        } else {
            return -1;
        }
    }
}
/**Class ProductStructure.*/
class ProductStructure {
    /** var prod.*/
    private  Product prod;
    /** var qty.*/
    private int qty = 0;
    /** Constructor .
     * @param receivedProduct .*/
    ProductStructure(final Product receivedProduct) {
        prod = receivedProduct;
        qty += 1;
    }
    /**getQty Function.
     * @return int*/
    public int getQty() {
        return qty;
    }
    /**getProduct Function.
     * @return Product*/
    public Product getProd() {
        return prod;
    }
    /**setQty Function.
     * @param pqty .*/
    public void setQty(final int pqty) {
        qty = pqty;
    }
}
