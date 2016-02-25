/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class LineItem {
     private Product product;
    private int qty;

    public final void setQty(int qty) { 
        if (qty == 0) {
            System.out.println("LineItem.setProduct method given illegal argument");}
        this.qty = qty;
    }

    public final int getQty() {
        return qty;
    }
    

    public LineItem() {
    }

    public LineItem(Product product, int qty) {   
        this.product = product;
        this.qty = qty;
    }
    
    public final String getProductID(){
        return product.getProductId();
    }
    
    public final String getProductName(){
        return product.getProductName();
    }
    
    public final double getProductPrice(){
        return product.getUnitCost();
    }
    
//    public final double getDiscountTotal(int qty){
//        return product.getDiscountedProductTotal(qty);
//    }
    
    public final Product getProduct() {
        return product;
    }
 
    public final void setProduct(Product product) {
        if(product == null) {
            System.out.println("LineItem.setProduct method given illegal argument");
        }
        this.product = product;
    }
    
    public final double getSubTotal(){
        return product.getUnitCost() * qty;
    }
    
    public final double getDiscountedSubTotal(int qty){
        return  (product.getUnitCost()* qty) - product.getDiscountedProductTotal(qty);
        
    } 
}
