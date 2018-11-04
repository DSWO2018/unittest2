package interfaces;

/**
 * ICart interface.
 */
public interface ICart {
    /**
     *
     * @param p to be added.
     * @return message.
     */
    String  addProduct(IProduct p);

    /**
     *
     * @param p to be removed.
     * @return message.
     */

    String  removeProduct(IProduct p);

    /**
     *
     * @return the total cart.
     */
    double  calculateTotal();

    /**
     *
     * @return the subtotal cart.
     */
    double  calculateSubtotal();

    /**
     *
     * @return the tax cart.
     */
    double  calculateTax();

    /**
     *
     * @param pos product position in line.
     * @return subtotal.
     */
    double  calculateLineItemSubtotal(int pos);

    /**
     *
     * @param pos product position in line.
     * @param qty quantity to add.
     * @return new quantity.
     */
    int addQuantityToLineItem(int pos, int qty);

    /**
     *
     * @param pos product position in line.
     * @param qty quantity to remove.
     * @return new quantity.
     */
    int removeQuantityToLineItem(int pos, int qty);
}
