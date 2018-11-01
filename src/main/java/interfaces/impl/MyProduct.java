package interfaces.impl;

import interfaces.Product;

public class MyProduct implements Product {
    public double getPrice() {
        return 0;
    }

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

    public int getID() {
        return 0;
    }
}
