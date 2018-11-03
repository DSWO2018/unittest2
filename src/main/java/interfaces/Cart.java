package interfaces;

/**
 * cart.
 */
public interface Cart {
    /**
     * add.
     * @param product .
     * @return     */
    String addProduct(Product product);

    /**
     * REMOVE.
     * @param product .
     * @return     */
    String removeProduct(Product product);

    /**
     * subtotal.
     * @return     */
    double calculateSubTotal();
}
