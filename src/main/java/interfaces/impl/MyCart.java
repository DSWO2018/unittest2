package interfaces.impl;

import interfaces.Product;

import java.util.ArrayList;

public class MyCart implements interfaces.Cart {
    ArrayList<ProductStructure> productList;
    public MyCart(){
        productList = new ArrayList<ProductStructure>();
    }
    public String addProduct(Product product) {
        boolean productExists = false;
        if (product == null){
            return "Producto No Se Pudo Agregar";
        }
        for (ProductStructure producttemp: productList
             ) {
            if (producttemp.prod.getID() == product.getID()){
                producttemp.Qty += 1;
                productExists = true;
                break;
            }
        }
        if( productExists == false ){
            productList.add(new ProductStructure(product));
            return "Producto Agregado Exitosamente";
        }
        else{
            return "Producto Ya Existe En El Carrito";
        }
    }

    public String removeProduct(Product product) {
        for (ProductStructure producttemp : productList
                ) {
            {
                if (producttemp.prod.getID() == product.getID()) {
                    productList.remove(product);
                    return "Producto Removido Exitosamente";
                }
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }
    public double calculateTotal() {
        double total = calculateSubtotal() + calculateTax();
        return total;
    }

    public double calculateSubtotal() {
        double subtotal = 0.0;
        for (ProductStructure prod : productList){
            subtotal += prod.prod.getPrice() * prod.Qty;
        }
        return subtotal;
    }

    public double calculateTax() {
        double tax = 0.16;
        double totaltax = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).prod.isTaxeable()) {
                totaltax += (calculateLineItemSubtotal(i) * tax);
            }
        }
        return totaltax;
    }

    public double calculateLineItemSubtotal(int pos) {
        double itemSubtotal;
        if(pos < productList.size()){
            itemSubtotal = productList.get(pos).Qty;
            return itemSubtotal * productList.get(pos).prod.getPrice();
        } else {
            return 0;
        }
    }

    public int addQuantityToLineItem(int pos, int qty) {
        int quantity;
        if(pos < productList.size()){
            productList.get(pos).Qty += qty;
            quantity = productList.get(pos).Qty;
            return quantity;
        } else
            return -1;
    }

    public int removeQuantityToLineItem(int pos, int qty) {
        int quantity;
        if(pos < productList.size()){
            productList.get(pos).Qty -= qty;
            if(productList.get(pos).Qty <= 0){
                productList.remove(pos);
                return 0;
            } else{
                quantity = productList.get(pos).Qty;
                return quantity;
            }
        } else {
            return -1;
        }
    }
}
class ProductStructure{
    Product prod;
    int Qty = 0;
    ProductStructure(Product receivedProduct){
        prod = receivedProduct;
        Qty += 1;
    }
}
