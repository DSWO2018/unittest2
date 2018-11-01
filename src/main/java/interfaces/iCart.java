package interfaces.impl;

/**
 * interface iCart. */
public interface iCart {
    /**
     *
     * @param p .
     * @return      */
    String addProduct(iProduct p);

    /**
     * remover producto.
     * @param p .
     * @return r     */
    String removeProduct(iProduct p);

    /**
     *calcular total.
     * @return r     */
    double calculateTotal();

    /**
     *calcular total con impuestos.
     * @return r     */
    double calculateSubTotal();

    /**
     *calcular impuestos.
     * @return r     */
    double calculateTax();

    /**
     *calculalr subtotal en lina.
     * @param pos .
     * @return r     */
    double calculateLineItemSubTotal(int pos);

    /**
     *agregar cantidad a la linea.
     * @param pos .
     * @param qty .
     * @return r     */
    int addQuantityToLineItem(int pos, int qty);

    /**
     *remover cnatidad a la lunea.
     * @param pos .
     * @param qty .
     * @return      */
    int removeQuantityToLineItem(int pos, int qty);

}
