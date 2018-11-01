package interfaces.impl;


import interfaces.Product;

import java.util.ArrayList;
/**
 * clase.
 */
public class MyCart implements interfaces.Cart {

    /**
     * Var.
     */
    ArrayList<ProductStructure> productList;
    /**
     * Constructor.
     */
    public MyCart() {
        productList = new ArrayList<ProductStructure>();
    }
    /**
     * @param product producto
     * @return r.
     */
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
    /**
     * @param product producto
     * @return r.
     */
    public String removeProduct(Product product) {
        for (ProductStructure productTemp : productList) {
            if (productTemp.product.getID() == product.getID()) {
                productList.remove(productTemp);
                return "Producto Removido Exitosamente";
            }
        }
        return "Producto No Se Encuentra En El Carrito";
    }
    /**
     * @return res.
     */    public double calculateTotal() {
        double total =  calculateSubtotal() + calculateTax();
        return total;
    }

    /**
     *
     * @return res.
     */
    public double calculateSubtotal() {
        double subtotal = 0;
        for (ProductStructure products : productList) {
            subtotal += products.product.getPrice() * products.Qty;
        }
        return subtotal;
    }

    /**
     *
     * @return res.
     */
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
    /**
     * @param pos p.
     * @return r.
     */
    public double calculateLineItemSubtotal(final int pos) {
        double itemSubtotal;
        try{
            ProductStructure products = productList.get(pos);
            itemSubtotal = products.product.getPrice() * products.Qty;
        }catch (Exception e){
            itemSubtotal = 0;
        }
        return itemSubtotal;
    }
    /**
     * @param pos p.
     * @param qty q.
     * @return r.
     */
    public int addQuantityToLineItem(final int pos, final int qty) {
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
    /**
     * @param pos p.
     * @param qty q.
     * @return res.
     */
    public int removeQuantityToLineItem(final int pos, final int qty) {
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

    /**
     *
     */
    class ProductStructure {
        Product product;
        int Qty = 0;
        /**
         *
         */
        ProductStructure(Product receivedProduct) {
            product = receivedProduct;
            Qty += 1;
        }
    }
}