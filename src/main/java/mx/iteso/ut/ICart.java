package mx.iteso.ut;

/**
 * interface.
 */
public interface ICart {
    /**
     *
     * @param p producto
     * @return resultado de la operacion.
     */
    String addProduct(IProduct p);

    /**
     *
     * @param p proucto
     * @return resultado de la operación.
     */
    String removeProduct(IProduct p);

    /**
     *
     * @return r.
     */
    double calculateTotal();

    /**
     *
     * @return r.
     */
    double calculateSubTotal();

    /**
     *
     * @return r.
     */
    double calculateTax();

    /**
     *
     * @param pos p.
     * @return r.
     */
    double calculateLineItemSubTotal(int pos);

    /**
     *
     * @param pos p
     * @param qty q
     * @return r
     */
    int addQuantityToLineItem(int pos, int qty);

    /**
     *
     * @param pos p
     * @param qty q
     * @return newTotal
     */
    int removeQuantityToLineItem(int pos, int qty);

}
