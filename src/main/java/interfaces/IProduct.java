package interfaces;

public interface IProduct {
    double  getPrice();
    String  getDescription();
    void    setPrice(double price);
    boolean isTaxeable();
    void    setTaxeable(boolean taxeable);
    String  getName();
    void    setName(String name);
    String  getID();
}
