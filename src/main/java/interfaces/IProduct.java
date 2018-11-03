package interfaces.impl;


import interfaces.Product;

/**
 * iproduct.
 */
public class IProduct implements Product {

    //variables del producto? -< product structure?!
    // ! para pasarlo con el constructor a myCart.
    /**
     * var.
     */
    private int  id;
    /**
     * var.
     */
    private double price = 0;
    /**
     * var.
     */
    private String descripcion;
    /**
     * var.
     */
    private boolean taxeable;
    /**
     * var.
     */
    private String name;

    /**
     * contrscutor.
     * @param iD .
     * @param namee .
     * @param pricee .
     * @param descripcioon .
     * @param taxeablee     */
    public IProduct(final int iD, final String namee,
                    final Double pricee, final String descripcioon,
                    final boolean taxeablee) {
        //CAMBIAR PARA PONERLOS CON LOS SETTERS.
        /*this.id = ID;
        this.price = price;
        this.taxeable = taxeable;
        this.descripcion = descripcion;
        this.name = name;*/
    setName(namee);
    setPrice(pricee);
    setTaxeable(taxeablee);
    setDescripcion(descripcioon);
    setId(iD);
    }

    /**
     * Get ID.
     *
     * @return     */
    public final int getID() {
        return this.id;
    }

    /**
     * Get Price.
     *
     * @return     */
    public final double getPrice() {
        return this.price;
    }

    /**
     * Get Descripction.
     *
     * @return     */
    public final String getDescription() {
        return this.descripcion;
    }

    /**
     * Set Price.
     *
     * @param prices     */
    public final void setPrice(final double prices) {
    this.price = prices;
    }
    /**
     * Set ID.
     *
     * @param idd    */
    public final void setId(final int idd) {
        this.id = idd;
    }

    /**
     * Set Description.
     *
     * @param descripcioon     */
    public final void setDescripcion(final String descripcioon) {
        this.descripcion = descripcioon;
    }



    /**
     * Taxeable?.
     *
     * @return     */
    public final boolean isTaxeable() {
        return this.taxeable;
    }

    /**
     * set Taxeable.
     *
     * @param taxeablee     */
    public final void setTaxeable(final boolean taxeablee) {
    this.taxeable = taxeablee;
    }

    /**
     *get Name.
     *
     * @return     */
    public final String getName() {
        return this.name;
    }

    /**
     * Set Name.
     *
     * @param namee     */
    public final void setName(final String namee) {
    this.name = namee;
    }
}
