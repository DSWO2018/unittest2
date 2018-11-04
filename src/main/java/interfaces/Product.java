package interfaces;

/**
 * Product implementation.
 */
public class Product implements IProduct {
    /**
     * Price.
     */
    private double price;

    /**
     * Description.
     */
    private String description;

    /**
     * Taxable.
     */
    private boolean taxable;

    /**
     * Name.
     */
    private String name;

    /**
     * ID.
     */
    private String id;

    /**
     *
     * @param anyPrice product price.
     * @param anyDescription product description.
     * @param isTaxable product. taxable info.
     * @param anyName product name.
     * @param anyID product ID.
     */
    public Product(final double anyPrice, final String anyDescription,
                   final boolean isTaxable, final String anyName,
                   final String anyID) {
        this.price = anyPrice;
        this.description = anyDescription;
        this.taxable = isTaxable;
        this.name = anyName;
        this.id = anyID;
    }

    /**
     *
     * @return the product price.
     */
    public double getPrice() {
        return price;
    }

    /**
     *
     * @return the product description.
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param anyPrice the product price.
     */

    public void setPrice(final double anyPrice) {
        this.price = anyPrice;
    }

    /**
     *
     * @return if the product is taxable.
     */
    public boolean isTaxeable() {
        return taxable;
    }

    /**
     *
     * @param isTaxable set the product taxable.
     */
    public void setTaxeable(final boolean isTaxable) {
        this.taxable = isTaxable;
    }

    /**
     *
     * @return the product name.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param anyName the new product name.
     */
    public void setName(final String anyName) {
        this.name = anyName;
    }

    /**
     *
     * @return the product ID.
     */
    public String getID() {
        return id;
    }
}
