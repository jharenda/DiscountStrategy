package jh.discountstrategy;

/**
 *Simulates a real product in a POS system
 * @author Jennifer
 */
public class Product {

    // product wouldn't know about quantity- that depends on the sale
    // discounts depend on products, so need discount here
    private String productId;
    private String productName;
    private double unitCost;
    private DiscountStrategy discount;

    
     /**
     * Custom constructor validates all required information
     * @param productId - unique id of product purchased
     * @param productName - the name of the product
     * @param unitCost - the original price for sale of one item
     * @param discount - the discount strategy used for this product
     */
    public Product(String productId, String productName, double unitCost, DiscountStrategy discount) {
        setProductId(productId);
        setProductName(productName);
        setUnitCost(unitCost);
        setDiscount(discount);
    }
// Rest of methods- no JavaDoc until Validation occurs. 
    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId)throws IllegalArgumentException {
       if ( productId == null || productId.isEmpty() )
            {
               throw new IllegalArgumentException("null/empty @ Productf.setProductId");
           }
        this.productId = productId;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) throws IllegalArgumentException{
       if ( productName == null || productName.isEmpty())
            {
               throw new IllegalArgumentException("null/empty @ Product.getProductName");
           }
        this.productName = productName;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final void setUnitCost(double unitCost)throws IllegalArgumentException {
        if ( unitCost <= 0)
            {
               throw new IllegalArgumentException("0 @ Product.setUnitcost");
           }
        this.unitCost = unitCost;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setDiscount(DiscountStrategy discount)throws IllegalArgumentException {
      if (discount == null)
            {
               throw new IllegalArgumentException("null @ Product.setDiscountAmount");
           }
        this.discount = discount;
    }

    public final double getDiscountedProductTotal(int qty)throws IllegalArgumentException {
      if ( qty <= 0 )
            {
               throw new IllegalArgumentException("0 @ Product.getDiscountedProductTotal");
           }
        return discount.getDiscountAmount(qty, unitCost);
    }

}
