package interfaces;

/**Cart Interface.*/
public interface Cart {
    /** addProduct Function.
     * @param product .
     * @return String*/
    String addProduct(Product product);

    /** removeProduct Function.
     * @param product .
     * @return String .*/
    String removeProduct(Product product);

    /** addProduct Function.
     * @return double .*/
    double calculateTotal();

    /** calculateSubtotal Function.
     * @return double .*/
    double calculateSubtotal();

    /** calculateFax Function.
     * @return double .*/
    double calculateTax();

    /** calculateLineItemSubtotal Function.
     * @param pos .
     * @return double .*/
    double calculateLineItemSubtotal(int pos);

    /** addQuantityLineItem Function.
     * @param pos .
     * @param qty .
     * @return double .*/
    int addQuantityToLineItem(int pos, int qty);

    /** cremoveQuantityToLineItem Function.
     * @param pos .
     * @param qty .
     * @return double .*/
    int removeQuantityToLineItem(int pos, int qty);
}
