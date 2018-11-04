package interfaces;

import java.util.ArrayList;

/**
 * Cart class.
 */
public class Cart implements ICart {
    /**
     * The product list.
     */
    private ArrayList<ProductStructure> productList;

    /**
     * Tax constant.
     */
    private final double taxConstant = 0.16;
    /**
     * Constructor as.
     */
    public Cart() {
        productList = new ArrayList<ProductStructure>();
    }

    /**
     *
     * @param product to be added.
     * @return message.
     */
    public String addProduct(final IProduct product) {
        boolean productExists = false;
        if (product == null) {
            return "Producto No Se Pudo Agregar";
        }

        for (ProductStructure producttemp: productList) {
            if (producttemp.getProd().getID().equals(product.getID())) {
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
     *
     * @param product to be removed.
     * @return message.
     */
    public String removeProduct(final IProduct product) {
        for (ProductStructure producttemp : productList) {
            if (producttemp.getProd().getID().equals(product.getID())) {
                productList.remove(product);
                return "Producto Removido Exitosamente";
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    /**
     *
     * @return the total cart.
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    /**
     *
     * @return the subtotal cart.
     */
    public double calculateSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < productList.size(); i++) {
            subtotal += calculateLineItemSubtotal(i);
        }
        return subtotal;
    }

    /**
     *
     * @return the tax cart.
     */
    public double calculateTax() {
        double tax = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProd().isTaxeable()) {
                tax += (calculateLineItemSubtotal(i) * taxConstant);
            }
        }
        return tax;
    }

    /**
     *
     * @param pos product position in line.
     * @return subtotal.
     */
    public double calculateLineItemSubtotal(final int pos) {
        if (pos < productList.size()) {
            return productList.get(pos).getQty()
                    * productList.get(pos).getProd().getPrice();
        }
        return 0;
    }

    /**
     *
     * @param pos product position in line.
     * @param qty quantity to add.
     * @return new quantity.
     */
    public int addQuantityToLineItem(final int pos, final int qty) {
        if (pos < productList.size()) {
            productList.get(pos).setQty(productList.get(pos).getQty() + qty);
            return productList.get(pos).getQty();
        }
        return 0;
    }

    /**
     *
     * @param pos product position in line.
     * @param qty quantity to remove.
     * @return new quantity.
     */
    public int removeQuantityToLineItem(final int pos, final int qty) {
        if (pos >= productList.size()) {
            return 0;
        }
        if (productList.get(pos).getQty() <= qty) {
            productList.remove(pos);
            return 0;
        }

        productList.get(pos).setQty(productList.get(pos).getQty() - qty);
        return productList.get(pos).getQty();
    }
}

/**
 * ProductStructure holding the products.
 */
class ProductStructure {
    /**
     * Product.
     */
    private IProduct prod;

    /**
     * Quantity.
     */
    private int qty = 0;

    /**
     *
     * @param receivedProduct product to add.
     */
    ProductStructure(final IProduct receivedProduct) {
        prod = receivedProduct;
        qty += 1;
    }

    /**
     *
     * @return product.
     */
    public IProduct getProd() {
        return prod;
    }

    /**
     *
     * @return quantity.
     */
    public int getQty() {
        return qty;
    }

    /**
     *
     * @param quantity quantity to add.
     */
    public void setQty(final int quantity) {
        this.qty = quantity;
    }
}
