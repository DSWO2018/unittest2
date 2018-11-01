package interfaces;

public interface ICart {
    String  addProduct(IProduct p);
    String  removeProduct(IProduct p);
    double  calculateTotal();
    double  calculateSubtotal();
    double  calculateTax();
    double  calculateLineItemSubtotal(int pos);
    int addQuantityToLineItem(int pos, int qty);
    int removeQuantityToLineItem(int pos, int qty);
}
