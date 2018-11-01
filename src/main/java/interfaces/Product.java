package interfaces;

/**
 * interface.
 */
public interface Product {
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

    /**
     *
     * @return
     */
    String getDescription();

    /**
     *
     * @param price
     */
    void setPrice(double price);

    /**
     *
     * @return
     */
    boolean isTaxeable();

    /**
     *
     * @param taxeable
     */
    void setTaxeable(boolean taxeable);

    /**
     *
     * @return
     */
    String getName();

    /**
     *
     * @param name
     */
    void setName(String name);

    /**
     *
     * @return
     */
    String getID();
}
