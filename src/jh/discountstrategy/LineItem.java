package jh.discountstrategy;

import java.text.NumberFormat;

/**
 * A simulation of a LineItem on a Receipt.
 * JavaDoc incomplete for this class
 * @author Jennifer
 */
public class LineItem {

    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private Product product;
    private int qty;
    private double[] subtotals;

    public final void setQty(int qty)throws IllegalArgumentException {
       if (qty <= 0)
            {
               throw new IllegalArgumentException("Null @ LineItem.setQty");
           }
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

    /**
     * Custom constructor uses required prodId and DatabaseStrategy to lookup
     * Product and store it along with quantity required by customer.
     * @param productId
     * @param qty
     * @param db 
     */
    public LineItem(String productId, int qty, DatabaseStrategy db) {
        // needs validation, or is method doing it for us? 
        setProduct(db.FindProductById(productId));
        setQty(qty);
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

    public final void setProduct(Product product)throws IllegalArgumentException {
    if ( product == null )
            {
               throw new IllegalArgumentException("Null @ LineItem.setProduct");
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
