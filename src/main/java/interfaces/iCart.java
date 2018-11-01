package interfaces.impl;

/**
 * interface iCart. */
public abstract interface iCart {
    /**
     *
     * @param p .
     * @return      */
    String addProduct(iProduct p);

    /**
     * remover producto.
     * @param p .
     * @return     */
    String removeProduct(iProduct p);

    /**
     *calcular total.
     * @return     */
    double calculateTotal();

    /**
     *calcular total con impuestos.
     * @return     */
    double calculateSubTotal();

    /**
     *calcular impuestos.
     * @return     */
    double calculateTax(double val);

    /**
     *calculalr subtotal en lina.
     * @param pos .
     * @return r     */
    double calculateLineItemSubTotal(int pos);

    /**
     *agregar cantidad a la linea.
     * @param pos .
     * @param qty .
     * @return     */
    int addQuantityToLineItem(int pos, int qty);

    /**
     *remover cnatidad a la lunea.
     * @param pos .
     * @param qty .
     * @return      */
    int removeQuantityToLineItem(int pos, int qty);

}
