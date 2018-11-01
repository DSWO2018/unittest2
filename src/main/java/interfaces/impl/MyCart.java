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
            if (producttemp.prod.getId() == product.getId()){
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
                if (producttemp.prod.getId() == product.getId()) {
                    productList.remove(product);
                    return "Producto Removido Exitosamente";
                }
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }

    public double calculateSubtotal() {
        double sub = 0.0;
        for (ProductStructure product : productList){
            sub += product.prod.getPrice() * product.Qty;
        }
        return sub;
    }

    public double calculateTax() {
        double tax = 0.0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).prod.isTaxeable()) {
                tax += (calculateLineItemSubtotal(i) * 0.16);
            }
        }
        return tax;
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
        if(pos < productList.size()){
            productList.get(pos).Qty -= qty;
            if(productList.get(pos).Qty <= 0){
                productList.remove(pos);
                return 0;
            } else{
                return productList.get(pos).Qty;
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
