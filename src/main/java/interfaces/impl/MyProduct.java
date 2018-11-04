package interfaces.impl;

import interfaces.Product;

public class MyProduct implements Product {
    /**ID.*/
    private int id;
    /**Price.*/
    private double price;
    /**Description.*/
    private String description;
    /**Name.*/
    private String name;
    /**Tax.*/
    private boolean tax;

    /**Constructor.
     * @param ident .
     * @param cost .
     * @param descrip .
     * @param nam .
     * @param tx .*/
    public MyProduct(final int ident, final double cost,
                      final String descrip, final String nam,
                      final boolean tx) {
        this.id = ident;
        this.price = cost;
        this.description = descrip;
        this.name = nam;
        this.tax = tx;
    }

    /**getID.
     * @return */
    public final int getID() {
        return id;
    }
    /**getPrice.
     * @return */
    public final double getPrice() {
        return price;
    }
    /**getDesc.
     * @return */
    public final String getDescription() {
        return description;
    }
    /**setPrice.
     * @param cost .*/
    public final void setPrice(final double cost) {
        this.price = cost;
    }
    /**Taxeess.
     * @return */
    public final boolean isTaxeable() {
        return tax;
    }
    /**setTaxws.
     * @param tx .*/
    public final void setTaxeable(final boolean tx) {
        this.tax = tx;
    }
    /**getName.
     * @return */
    public final String getName() {
        return name;
    }
    /**detNaame.
     * @param nam .*/
    public final void setName(final String nam) {
        this.name = nam;
    }
}
