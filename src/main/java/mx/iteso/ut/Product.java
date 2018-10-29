package mx.iteso.ut;

/**
 * clase.
 */
public class Product implements IProduct {

    /**
     * @return
     */
    public int getId() {
        return 0;
    }

    /**
     *
     * @return r
     */
    public double getPrice() { return 0; }

    public String getDescription() {
        return null;
    }

    public void setPrice(double price) {

    }

    public boolean isTaxeable() {
        return false;
    }

    public void setTaxeable(boolean taxeable) {

    }

    public String getName() {
        return null;
    }

    public void setName(String name) {

    }

    public String getID() {
        return null;
    }
}
