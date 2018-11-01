package interfaces.impl;


import java.util.ArrayList;

public class MyCart implements iCart {
    ArrayList<ProductStructure> productList;
    public MyCart(){
        productList = new ArrayList<ProductStructure>();
    }
    public String addProduct(iProduct product) {
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

    public String removeProduct(iProduct product) {
        for (ProductStructure producttemp : productList
                ) {
            {
                if (producttemp.prod.getID() == product.getID()) {
                    if(producttemp.Qty<2) {
                        productList.remove(product);
                        return "Producto Removido Exitosamente";
                    }
                    else {
                        producttemp.Qty--;
                        return "Producto Removido Exitosamente pero aun queda alguno en el carro!";
                    }
                }
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }

    public double calculateTotal() {
        return 0;
    }

    public double calculateSubTotal() {
        return 0;
    }

    public double calculateTax(double val) {
        val=val+val*.16;
        return val;
    }

    public double calculateLineItemSubTotal(int pos) {
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
    iProduct prod;
    int Qty = 0;
    int price=0;
    boolean tax;
    ProductStructure(iProduct receivedProduct){
        prod = receivedProduct;
        Qty += 1;
    }
}
