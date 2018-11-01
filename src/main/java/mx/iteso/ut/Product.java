package mx.iteso.ut;
import java.util.Random;

/**
 * clase.
 */
public class Product implements IProduct {
    /**
     * variable.
     */
    private boolean taxable;

    /**
     * variable.
     */
    private int id;

    /**
     * variable.
     */
    private String description;

    /**
     * variable.
     */
    private String name;

    /**
     * variable.
     */
    private double price;

    /**
     * constructor.
     * @param n name
     * @param p price
     */
    public Product(final String n, final double p) {
        final int bound = 1000000000;
        Random rand = new Random();
        this.id = rand.nextInt(bound) + 1;
        this.name = n;
        this.taxable = true;
        this.price = p;
    }

    /**
     * constructor.
     * @param n name
     * @param p price
     * @param d description
     */
    public Product(final String n, final double p, final String  d) {
        final int bound = 1000000000;
        Random rand = new Random();
        this.id = rand.nextInt(bound) + 1;
        this.name = n;
        this.description = d;
        this.taxable = true;
        this.price = p;
    }

    /**
     * constructor.
     * @param n name
     * @param p price
     * @param i id
     */
    public Product(final String n, final double p, final int i) {
        this.id = i;
        this.name = n;
        this.taxable = true;
        this.price = p;
    }

    /**
     * constructor.
     * @param n name
     * @param p price
     * @param d description
     * @param i id
     */
    public Product(final String n, final double p,
                   final String  d, final int i) {
        this.id = i;
        this.name = n;
        this.description = d;
        this.taxable = true;
        this.price = p;
    }

    /**
     * @return id
     */
    public final int getId() {
        return this.id;
    }

    /**
     *
     * @return r
     */
    public final double getPrice() {
        return this.price;
    }

    /**
     *
     * @return descripcion del producto.
     */
    public final String getDescription() {
        return this.description;
    }

    /**
     *
     * @param p precio del producto.
     */
    public final void setPrice(final double p) {
        this.price = p;
    }

    /**
     *
     * @return si es taxeable o no
     */
    public final boolean isTaxable() {
        return this.taxable;
    }

    /**
     *
     * @param t definimos si es taxeable o no
     */
    public final void setTaxable(final boolean t) {
        this.taxable = t;
    }

    /**
     *
     * @return nombre del producto.
     */
    public final String getName() {
        return this.name;
    }

    /**
     *
     * @param n definimos el nombre.
     */
    public final void setName(final String n) {
        this.name = n;
    }
}
