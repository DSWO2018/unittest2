package interfaces.impl;

import interfaces.Product;

import java.util.ArrayList;

public class MyCart implements interfaces.Cart {
    ArrayList<ProductStructure> productList;

    public MyCart() {
        productList = new ArrayList<ProductStructure>();
    }

    public String addProduct(Product product) {
        if (product == null) {
            return "Producto No Se Pudo Agregar";
        }
        for (ProductStructure producttemp : productList) {
            if (producttemp.product.getID() == product.getID()) {
                producttemp.Qty += 1;
                return "Producto Ya Existe En El Carrito";
            }
        }
        productList.add(new ProductStructure(product));
        return "Producto Agregado Exitosamente";
    }

    public String removeProduct(Product product) {
        for (ProductStructure productTemp : productList) {
            if (productTemp.product.getID() == product.getID()) {
                productList.remove(productTemp);
                return "Producto Removido Exitosamente";
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    public double calculateTotal() {
        double total =  calculateSubtotal() + calculateTax();
        return total;
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (ProductStructure products : productList) {
            subtotal += products.product.getPrice() * products.Qty;
        }
        return subtotal;
    }

    public double calculateTax() {
        double tax = 0;
        double iva = .16;
        for (ProductStructure products : productList) {
            if (products.product.isTaxeable()){
                tax += products.product.getPrice() * products.Qty * iva;
            }
        }
        return tax;
    }

    public double calculateLineItemSubtotal(int pos) {
        double itemSubtotal;
        try{
            ProductStructure products = productList.get(pos);
            itemSubtotal = products.product.getPrice() * products.Qty;
        }catch (Exception e){
            itemSubtotal = 0;
        }
        return itemSubtotal;
    }

    public int addQuantityToLineItem(int pos, int qty) {
        int newQty;
        try{
            ProductStructure products = productList.get(pos);
            products.Qty+=qty;
            newQty = products.Qty;
        }catch (Exception e){
            newQty = 0;
        }
        return newQty;
    }

    public int removeQuantityToLineItem(int pos, int qty) {
        int newQty;
        try{
            ProductStructure products = productList.get(pos);
            products.Qty-=qty;
            if(products.Qty <=0 ){
                productList.remove(products);
                newQty = 0;
            }else {
                newQty = products.Qty;
            }
        }catch (Exception e){
            newQty = 0;
        }
        return newQty;
    }

    class ProductStructure {
        Product product;
        int Qty = 0;

        ProductStructure(Product receivedProduct) {
            product = receivedProduct;
            Qty += 1;
        }
    }
}
