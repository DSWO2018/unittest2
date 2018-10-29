package mx.iteso.ut;

/**
 * interface.
 */
public interface IProduct {
    /**
     *
     * @return r
     */
    int getId();

    /**
     *
     * @return r
     */
    double getPrice();

    String getDescription();
    void setPrice(double price);
    boolean isTaxeable();
    void setTaxeable(boolean taxeable);
    String getName();
    void setName(String name);
    String getID();
}
