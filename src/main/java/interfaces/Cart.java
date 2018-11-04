package interfaces;

/**Interface cart.*/
public interface Cart {
    /**addProduct.
     *@param product .
     * @return */
    String addProduct(Product product);
    /**removeProdcut.
     * @param product .
     * @return */
    String removeProduct(Product product);
    /**total.
     * @return */
    double calculateTotal();
    /**subtotal.
     * @return */
    double calculateSubtotal();
    /**taxes.
     * @return */
    double calculateTax();
    /**itemsubtotal.
     * @param pos .
     * @return  */
    double calculateLineItemSubtotal(int pos);
    /**addQty.
     * @param pos .
     * @param qty .
     * @return */
    int addQuantityToLineItem(int pos, int qty);
    /**removeQty.
     * @param pos .
     * @param qty .
     * @return */
    int removeQuantityToLineItem(int pos, int qty);
}
