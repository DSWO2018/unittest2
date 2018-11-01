package interfaces;

public interface Cart {
    String addProduct(Product product);
    String removeProduct(Product product);
    double calculateTotal();
    double calculateSubtotal();
    double calculateTax();
    double calculateLineItemSubtotal(int pos);
    int    addQuantityToLineItem(int pos, int qty);
    int    removeQuantityToLineItem(int pos, int qty);
}
