package interfaces.impl;

import interfaces.Product;

/**
 * Created by Palaf on 03/11/2018.
 */
public class MyProduct implements Product {
    boolean taxeable;
    int ID;
    double price;
    String name;

    @Override
    public String toString() {
        return "MyProduct{" +
                "taxeable=" + taxeable +
                ", ID=" + ID +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    public MyProduct(boolean taxeable, int ID, double price, String name) {
        this.taxeable = taxeable;
        this.ID = ID;
        this.price = price;
        this.name = name;
    }

    public int getID() {
        return this.ID;
    }

    public double getPrice() {
        return this.price;
    }


    public void setPrice(double price) {
        this.price=price;
    }

    public boolean isTaxeable() {
        return this.taxeable;
    }

    public void setTaxeable(boolean taxeable) {
        this.taxeable=taxeable;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name=name;
    }
}
