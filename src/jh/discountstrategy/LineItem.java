package jh.discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author Jennifer
 */
public class LineItem {

    NumberFormat nf = NumberFormat.getCurrencyInstance();
    private Product product;
    private int qty;
    private double[] subtotals;

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

    //needs to be better formatted for allignment 
    public String getLineItemData() {
        String data
                = "----     ------            ------     ------         ------           ------\n"
                + this.getProduct().getProductId() + "       " + this.getProduct().getProductName() + "    " + this.getQty() + "          " + nf.format(getSubTotal()) + "        " + nf.format(this.getDiscountedSubTotal()) + "             " + nf.format(this.getProduct().getDiscount().getDiscountAmount(qty, product.getUnitCost()));
        return data;
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
        double subTotal = 0.0;
        subTotal = product.getUnitCost() * qty;
        return subTotal;
    }

    public final double getDiscountedSubTotal() {
        double total = 0.0;
        total = (product.getUnitCost() * qty) - product.getDiscountedProductTotal(qty);
        return total;
    }
}
