package jh.discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author Jennifer
 */
public class LineItem {

    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private Product product;
    private int qty;
    private double[] subtotals;

    public final void setQty(int qty) {
        // needs validation 
        this.qty = qty;
    }

    public final int getQty() {
        return qty;
    }

    public LineItem() {
    }

    //needs to be better formatted for allignment 
    public final String getLineItemData() {
        String data
                = "----     ------            ------     ------         ------           ------\n"
                + this.getProduct().getProductId() + "       " + this.getProduct().getProductName() + "    " + this.getQty() + "          " + nf.format(getSubTotal()) + "        " + nf.format(this.getDiscountedSubTotal()) + "             " + nf.format(this.getProduct().getDiscount().getDiscountAmount(qty, product.getUnitCost()));
        return data;
    }

    public LineItem(String productId, int qty, DatabaseStrategy db) {
        // needs validation, or is method doing it for us? 
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

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        // needs validation 
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
