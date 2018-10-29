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
}
class ProductStructure{
    Product prod;
    int Qty = 0;
    ProductStructure(Product receivedProduct){
        prod = receivedProduct;
        Qty += 1;
    }
}
