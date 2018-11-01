package interfaces;

public class Product implements IProduct {
    private double price;
    private String description;
    private boolean taxable;
    private String name;
    private String id;

    public Product(double price, String description, boolean taxable, String name, String id) {
        this.price = price;
        this.description = description;
        this.taxable = taxable;
        this.name = name;
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isTaxeable() {
        return taxable;
    }

    public void setTaxeable(boolean taxeable) {
        this.taxable = taxeable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return id;
    }
}
