package interfaces;
/**Interface Product.*/
public interface Product {
    /**getID.
     * @return */
    int getID();
    /**getPrice.
     * @return */
    double getPrice();
    /**getDescription.
     * @return */
    String getDescription();
    /**setPrice.
     * @param cost .*/
    void setPrice(double cost);
    /**Tacable.
     * @return */
    boolean isTaxeable();
    /**setTaxeable.
     * @param tx .*/
    void setTaxeable(boolean tx);
    /**getName.
     * @return */
    String getName();
    /**setName.
     * @param nam .*/
    void setName(String nam);
}
