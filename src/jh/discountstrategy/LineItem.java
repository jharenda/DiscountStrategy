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
            System.out.println("LineItem.setProduct method given illegal argument");
        }
        this.qty = qty;
    }

    public final int getQty() {
        return qty;
    }

    public LineItem() {
    }
 public String getLineItemData () {
    String data = "Prod ID Item Qty\n" + 
            "------\n"
            + this.getProduct().getProductId() + " " +  this.getProduct().getProductName(); 
     return data + " " +  this.getDiscountedSubTotal(); 
 }
    public LineItem(String productId, int qty, DBS db) {
        setProduct(db.FindProductById(productId)); 
        this.qty = qty;
    }

    public final String getProductID() {
        return product.getProductId();
    }

    public final String getProductName() {
        return product.getProductName();
    }

    public final double getProductPrice() {
        return product.getUnitCost();
    }

//    public final double getDiscountTotal(int qty){
//        return product.getDiscountedProductTotal(qty);
//    }
    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if (product == null) {
            System.out.println("LineItem.setProduct method given illegal argument");
        }
        this.product = product;
    }

    public final double getSubTotal() {
        return product.getUnitCost() * qty;
    }

    public final double getDiscountedSubTotal() {
        return (product.getUnitCost() * qty) - product.getDiscountedProductTotal(qty);

    }
}
