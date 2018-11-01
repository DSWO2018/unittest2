package interfaces.impl;

import interfaces.IProduct;
import interfaces.Product;

import java.util.ArrayList;

public class MyCart implements interfaces.ICart {
    private ArrayList<ProductStructure> productList;
    public MyCart(){
        productList = new ArrayList<ProductStructure>();
    }
    public String addProduct(IProduct product) {
        boolean productExists = false;
        if (product == null){
            return "Producto No Se Pudo Agregar";
        }
        for (ProductStructure producttemp: productList
             ) {
            if (producttemp.prod.getID().equals(product.getID())){
                producttemp.Qty += 1;
                productExists = true;
                break;
            }
        }
        if( !productExists ){
            productList.add(new ProductStructure(product));
            return "Producto Agregado Exitosamente";
        }
        else{
            return "Producto Ya Existe En El Carrito";
        }
    }

    public String removeProduct(IProduct product) {
        for (ProductStructure producttemp : productList) {
                if (producttemp.prod.getID().equals(product.getID())) {
                    productList.remove(product);
                    return "Producto Removido Exitosamente";
                }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    public double calculateTotal() {
        return 0;
    }

    public double calculateSubtotal() {
        return 0;
    }

    public double calculateTax() {
        return 0;
    }

    public double calculateLineItemSubtotal(int pos) {
        return 0;
    }

    public int addQuantityToLineItem(int pos, int qty) {
        return 0;
    }

    public int removeQuantityToLineItem(int pos, int qty) {
        return 0;
    }
}
class ProductStructure{
    IProduct prod;
    int Qty = 0;
    ProductStructure(IProduct receivedProduct){
        prod = receivedProduct;
        Qty += 1;
    }
}
