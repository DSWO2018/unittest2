package interfaces;

/**
 * IProduct interface.
 */
public interface IProduct {
    /**
     *
     * @return the product price.
     */
    double  getPrice();

    /**
     *
     * @return the product description.
     */
    String  getDescription();

    /**
     *
     * @param price the product price.
     */
    void    setPrice(double price);

    /**
     *
     * @return if the product is taxable.
     */
    boolean isTaxeable();

    /**
     *
     * @param taxeable set the product taxable.
     */
    void    setTaxeable(boolean taxeable);

    /**
     *
     * @return the product name.
     */
    String  getName();

    /**
     *
     * @param name the new product name.
     */
    void    setName(String name);

    /**
     *
     * @return the product ID.
     */
    String  getID();
}
