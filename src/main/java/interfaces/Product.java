package interfaces;
/** Interface Product. */
public interface Product {
    /** getPrice Function.
     * @return double*/
    double getPrice();
    /** getDescription Function.
     * @return Strinf*/
    String getDescription();
    /** setPrice Function.
     * @param price .*/
    void setPrice(double price);
    /** isTaxeable Function.
     * @return boolean*/
    boolean isTaxeable();
    /** setTaxeable Function.
     * @param taxeable .*/
    void setTaxeable(boolean taxeable);
    /** getName Function.
     * @return String*/
    String getName();
    /** setName Function.
     * @param name .*/
    void setName(String name);
    /** getId Function.
     * @return String*/
    String getId();
}
