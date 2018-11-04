package interfaces.impl;

import interfaces.Product;

import java.util.ArrayList;
/**MyCart implements interfaces.*/
public class MyCart implements interfaces.Cart {

    /**a simple ArrayList.*/
    private ArrayList<ProductStructure> productList;
    /**sdfsdf*/
    public MyCart() {
        productList = new ArrayList<ProductStructure>();
    }

    /**addProduct.
     * @param product .
     * @return .*/
    public final String addProduct(final Product product) {

        boolean productExists = false;

        if (product == null) {
            return "Producto No Se Pudo Agregar";
        }

        for (ProductStructure producttemp: productList) {
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
    /**remove.
     * @param product .
     * @return */
    public final String removeProduct(final Product product) {
        for (ProductStructure producttemp : productList) {

                if (producttemp.getProd().getID() == product.getID()) {
                    productList.remove(product);
                    return "Producto Removido Exitosamente";
                }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    /**total.
     * @return .*/
    public final double calculateTotal() {
        double total = calculateSubtotal() + calculateTax();
        return total;
    }
    /**subtotal.
     * @return  .*/
    public final double calculateSubtotal() {
        double subtotal = 0.0;
        int i = 0;
        for (ProductStructure prod : productList) {
            subtotal += calculateLineItemSubtotal(i);
            i++;
        }
        return subtotal;
    }
    /**calculate tax.
     * @return .*/
    public final double calculateTax() {
        final double tax = 0.16;
        double totalTax = 0.0;
        int i = 0;
        for (ProductStructure prod : productList) {
            if (productList.get(i).getProd().isTaxeable()) {
                totalTax += (calculateLineItemSubtotal(i) * tax);
            }
            i++;
        }
        return totalTax;
    }
    /**calculate subtotal per line.
     * @param pos .
     * @return .*/
    public final double calculateLineItemSubtotal(final int pos) {
        double itemSubtotal;
        if (pos < productList.size()) {
            itemSubtotal = productList.get(pos).getQty();
            return itemSubtotal * productList.get(pos).getProd().getPrice();
        } else {
            return 0;
        }
    }
    /**addQtyperLine.
     * @param pos .
     * @param qty .
     * @return .*/
    public final int addQuantityToLineItem(final int pos, final int qty) {
        int quantity;
        final int err = 999;
        if (pos < productList.size()) {
            productList.get(pos).setQty(productList.get(pos).getQty() + qty);
            quantity = productList.get(pos).getQty();
            return quantity;
        } else {
            return err;
        }
    }
    /**removeQtyperLine.
     * @param pos .
     * @param qty .
     * @return */
    public final int removeQuantityToLineItem(final int pos, final int qty) {
        int quantity;
        final int err = 999;
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
            return err;
        }
    }
}
/**estructura.*/
class ProductStructure {
    /**Product prod.*/
    private Product prod;
    /**Qty.*/
    private int qty = 0;
    /**Product Structure.
     * @param receivedProduct .*/
    ProductStructure(final Product receivedProduct) {
        prod = receivedProduct;
        qty += 1;
    }
    /**getProdcuct.
     * @return */
    public Product getProd() {
        return this.prod;
    }
    /**setProduct.
     * @param produ .*/
    public void setProd(final Product produ) {
        this.prod = produ;
    }
    /**getQty.
     * @return */
    public int getQty() {
        return this.qty;
    }
    /**setQty.
     * @param qtty .*/
    public void setQty(final int qtty) {
        this.qty = qtty;
    }
}
