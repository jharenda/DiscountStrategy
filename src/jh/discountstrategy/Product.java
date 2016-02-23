
package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class Product {
    // product wouldn't know about quantity- that depends on the sale
    // discounts depend on products, so need discount here
    private String productId;
    private String productName;
    private double unitCost; 
    private DiscountStrategy discount; 

    public Product(String productId, String productName, double unitCost, DiscountStrategy discount) {
      setProductId(productId);
      setProductName(productName);
      setUnitCost(unitCost);
      setDiscount(discount);
    }
    

    public final String getProductId() {
        return productId;
    }

    public  final void setProductId(String productId) {
        // needs validation 
        this.productId = productId;
    }

    public  final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
         // needs validation 
        this.productName = productName;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost) {
         // needs validation 
        this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public  final void setDiscount(DiscountStrategy discount) {
         // needs validation 
        this.discount = discount;
    }
    
    
    
}
