package interfaces.impl;

import interfaces.Product;

public class MyProduct implements Product {

    private String id;
    private String name;
    private String description;
    private double price;
    private boolean taxeable;

    public MyProduct(String id, String name, String description, double price, boolean taxeable){
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.taxeable = taxeable;
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
        return taxeable;
    }

    public void setTaxeable(boolean taxeable) {
        this.taxeable = taxeable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }
}