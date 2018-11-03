package interfaces.impl;

import interfaces.Product;

/**
 *
 */
public class MyProduct implements Product {
    /****/
    private int id;
    /****/
    private double price;
    /****/
    private String description;
    /****/
    private String name;
    /****/
    private boolean tax;

    /**
     * @param i .
     * @param p .
     * @param desc .
     * @param n .
     * @param t .
     */
    public MyProduct(final int i, final double p, final String desc,
                      final String n, final boolean t) {
        this.id = i;
        this.price = p;
        this.description = desc;
        this.name = n;
        this.tax = t;
    }

    /**
     * @return .
     */
    public final double getPrice() {
        return price;
    }

    /**
     * @return .
     */
    public final String getDescription() {
        return description;
    }

    /**
     * @param p .
     */
    public final void setPrice(final double p) {
        this.price = p;
    }

    /**
     * @return .
     */
    public final boolean isTaxeable() {
        return tax;
    }

    /**
     * @param taxeable .
     */
    public final void setTaxeable(final boolean taxeable) {
        this.tax = taxeable;
    }

    /**
     * @return .
     */
    public final String getName() {
        return name;
    }

    /**
     * @param n .
     */
    public final void setName(final String n) {
        this.name = n;
    }

    /**
     * @return .
     */
    public final int getID() {
        return id;
    }
}
