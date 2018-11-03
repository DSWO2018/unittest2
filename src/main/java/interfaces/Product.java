package interfaces;

/**
 *
 */
public interface Product {
    /**@return . */
    double    getPrice();

    /**@return . */
    String    getDescription();

    /**@param price . */
    void    setPrice(double price);

    /**@return . */
    boolean    isTaxeable();

    /**@param taxeable . */
    void    setTaxeable(boolean taxeable);

    /**@return . */
    String    getName();

    /**@param name . */
    void    setName(String name);

    /**@return . */
    int    getID();
}
