package interfaces;

/**
 *
 */
public interface Cart {
    /**
     * @param product .
     * @return .
     */
    String addProduct(Product product);

    /**
     * @param product .
     * @return .
     */
    String removeProduct(Product product);

    /**@return . */
    double calculateTotal();

    /**@return . */
    double calculateSubtotal();

    /**@return . */
    double calculateTax();

    /**
     * @param pos .
     * @return .
     */
    double calculateLineItemSubtotal(int pos);

    /**
     * @param pos .
     * @param qty .
     * @return .
     */
    int    addQuantityToLineItem(int pos, int qty);

    /**
     * @param pos .
     * @param qty .
     * @return .
     */
    int    removeQuantityToLineItem(int pos, int qty);
}
