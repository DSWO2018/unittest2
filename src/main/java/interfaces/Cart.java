package interfaces;


/**
 * interface.
 */
public interface Cart {
    /**
     *
     * @param product producto
     * @return resultado de la operacion.
     */
    String addProduct(Product product);
    /**
     *
     * @param product p.
     * @return res.
     */
    String removeProduct(Product product);
    /**
     *
     * @return res.
     */
    double calculateTotal();
    /**
     *
     * @return res.
     */
    double calculateSubtotal();
    /**
     *
     * @return res.
     */
    double calculateTax();
    /**
     *
     * @param pos p.
     * @return res.
     */
    double calculateLineItemSubtotal(int pos);

    /**
     *
     * @param pos
     * @param qty
     * @return res.
     */
    int addQuantityToLineItem(int pos, int qty);

    /**
     *
     * @param pos
     * @param qty
     * @return res.
     */
    int removeQuantityToLineItem(int pos, int qty);
}