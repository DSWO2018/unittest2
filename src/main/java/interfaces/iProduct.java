package interfaces.impl;


import interfaces.Product;

public class iProduct implements Product {

    //variables del producto? -< product structure?!! para pasarlo con el constructor a myCart.
    int id;
    double price = 0;
    String descripcion;
    boolean taxeable;
    String name;


    public iProduct(int ID, String name, Double price, String descripcion, boolean taxeable) {
        //CAMBIAR PARA PONERLOS CON LOS SETTERS.
        /*this.id = ID;
        this.price = price;
        this.taxeable = taxeable;
        this.descripcion = descripcion;
        this.name = name;*/
    setName(name);
    setPrice(price);
    setTaxeable(taxeable);
    setDescripcion(descripcion);
    setId(ID);
    }

    /**
     * Get ID.
     *
     * @return     */
    public int getID() {
        return this.id;
    }

    /**
     * Get Price.
     *
     * @return     */
    public double getPrice() {
        return this.price;
    }

    /**
     * Get Descripction.
     *
     * @return     */
    public String getDescription() {
        return this.descripcion;
    }

    /**
     * Set Price.
     *
     * @param price     */
    public void setPrice(double price) {
    this.price=price;
    }
    /**
     * Set ID.
     *
     * @param id     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Set Description.
     *
     * @param descripcion     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    /**
     * Taxeable?.
     *
     * @return     */
    public boolean isTaxeable() {
        return this.taxeable;
    }

    /**
     * set Taxeable.
     *
     * @param taxeable     */
    public void setTaxeable(boolean taxeable) {
    this.taxeable=taxeable;
    }

    /**
     *get Name.
     *
     * @return     */
    public String getName() {
        return this.name;
    }

    /**
     * Set Name.
     *
     * @param name     */
    public void setName(String name) {
    this.name=name;
    }
}
