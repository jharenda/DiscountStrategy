package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class QtyDiscount implements DiscountStrategy {

    private double discountRate;
    private int minQty;
    private final int NO_DISCOUNT = 0;

    public QtyDiscount(double discountRate, int minQty) {
        this.discountRate = discountRate;
        setDiscountRate(discountRate);
        setMinQty(minQty);
    }

    public final int getMinQty() {
        return minQty;
    }

    public final void setMinQty(int minQty) {
        if (minQty < 1) {
            System.out.println("QtyDiscount.setMinQty given illegal arugment");
        }

        this.minQty = minQty;
    }

    @Override
    public final double getDiscountAmount(int qty, double unitCost) {
        // needs validation 
        if (qty >= minQty) {
            return unitCost * qty * discountRate;
        } else {
            return NO_DISCOUNT;
        }
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        if (discountRate < 0){
            System.out.println("QtyDiscount.setDiscountRate given illegal arugment.");
        }
        this.discountRate = discountRate;
    }

}
