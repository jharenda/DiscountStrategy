package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class FlatAmountDiscount implements DiscountStrategy {

    private double discountRate = 0.0;

    public FlatAmountDiscount(double discountRate) {
        this.discountRate = discountRate;
        setDiscountRate(discountRate);
    }

    @Override
    public final double getDiscountAmount(int qty, double unitCost) {
        // needs validation 
        return discountRate;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        if (discountRate < 0) {
            System.out.println("FlatAmountDiscount.setDiscountRate given illegal argument");
        }
        this.discountRate = discountRate;
    }

}
