package interfaces.impl;

import interfaces.Product;
/** Class MyProduct.*/
public class MyProduct implements Product {
    /**Var id.*/
    private String id;
    /**Var name.*/
    private String name;
    /**Var description.*/
    private String description;
    /**Var price.*/
    private double price;
    /**Var taxeable.*/
    private boolean taxeable;

    /**Constructor.
     * @param pid .
     * @param pname .
     * @param pdescription .
     * @param pprice .
     * @param ptaxeable .*/
    public MyProduct(final String pid, final String pname,
                     final String pdescription,
                     final double pprice, final boolean ptaxeable) {
        this.id = pid;
        this.name = pname;
        this.description = pdescription;
        this.price = pprice;
        this.taxeable = ptaxeable;
    }
    /**getPrice Function.
     * @return double*/
    public final double getPrice() {
        return price;
    }
    /**getDescription Function.
     * @return String*/
    public final String getDescription() {
        return description;
    }
    /**setPrice Function.
     * @param pprice .*/
    public final void setPrice(final double pprice) {
        this.price = pprice;
    }
    /**isTaxeable Function.
     * @return boolean*/
    public final boolean isTaxeable() {
        return taxeable;
    }
    /**setTaxeable Function.
     * @param ptaxeable .*/
    public final void setTaxeable(final boolean ptaxeable) {
        this.taxeable = ptaxeable;
    }
    /**getName Function.
     * @return String .*/
    public final String getName() {
        return name;
    }
    /**setName Function.
     * @param pname .*/
    public final void setName(final String pname) {
        this.name = pname;
    }
    /**getId Function.
     * @return String*/
    public final String getId() {
        return id;
    }
}
