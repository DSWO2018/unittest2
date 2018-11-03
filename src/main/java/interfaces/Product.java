package interfaces;

public interface Product {
    int getID();
    double getPrice();
    void setPrice(double price);
    boolean isTaxeable();
    void setTaxeable(boolean taxeable);
    String getName();
    void setName(String name);
}
