package interfaces;

import java.util.ArrayList;

public class Cart implements ICart {
    private ArrayList<ProductStructure> productList;

    public Cart() {
        productList = new ArrayList<ProductStructure>();
    }

    public String addProduct(IProduct product) {
        boolean productExists = false;
        if (product == null) {
            return "Producto No Se Pudo Agregar";
        }

        for (ProductStructure producttemp: productList) {
            if (producttemp.prod.getID().equals(product.getID())){
                producttemp.qty += 1;
                productExists = true;
                break;
            }
        }

        if(!productExists){
            productList.add(new ProductStructure(product));
            return "Producto Agregado Exitosamente";
        } else {
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
        return calculateSubtotal() + calculateTax();
    }

    public double calculateSubtotal() {
        double subtotal = 0;
        for (int i = 0; i < productList.size(); i++) {
            subtotal += calculateLineItemSubtotal(i);
        }
        return subtotal;
    }

    public double calculateTax() {
        double tax = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).prod.isTaxeable()) {
                tax += (calculateLineItemSubtotal(i) * 0.16);
            }
        }
        return tax;
    }

    public double calculateLineItemSubtotal(int pos) {
        if(pos < productList.size()) {
            return productList.get(pos).qty * productList.get(pos).prod.getPrice();
        }
        return 0;
    }

    public int addQuantityToLineItem(int pos, int qty) {
        if(pos < productList.size()) {
            productList.get(pos).qty += qty;
            return productList.get(pos).qty;
        }
        return 0;
    }

    public int removeQuantityToLineItem(int pos, int qty) {
        if(pos >= productList.size()) {
            return 0;
        }
        if (productList.get(pos).qty <= qty) {
            productList.remove(pos);
            return 0;
        }
        productList.get(pos).qty -= qty;
        return productList.get(pos).qty;
    }
}

class ProductStructure {
    IProduct prod;
    int qty = 0;

    ProductStructure(IProduct receivedProduct) {
        prod = receivedProduct;
        qty += 1;
    }
}
