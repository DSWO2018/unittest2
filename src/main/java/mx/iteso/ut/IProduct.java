package mx.iteso.ut;

/**
 * interface.
 */
public interface IProduct {
    /**
     *
     * @return r
     */
    int getId();

    /**
     *
     * @return r
     */
    double getPrice();

    /**
     *
     * @return descripcion del producto.
     */
    String getDescription();

    /**
     *
     * @param price precio del producto.
     */
    void setPrice(double price);

    /**
     *
     * @return si es taxable o no
     */
    boolean isTaxable();

    /**
     *
     * @param taxable definimos si es taxeable o no
     */
    void setTaxable(boolean taxable);

    /**
     *
     * @return nombre del producto.
     */
    String getName();

    /**
     *
     * @param name definimos el nombre.
     */
    void setName(String name);
}
