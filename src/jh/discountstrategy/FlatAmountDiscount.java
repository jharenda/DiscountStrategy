package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class FlatAmountDiscount implements DiscountStrategy {

    private double discountRate = 0.0;

    public FlatAmountDiscount(double discountRate) {
        //this will do the validation for us
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
        // needs validation 
        this.discountRate = discountRate;
    }

}
