package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class PercentOffDiscount implements DiscountStrategy {

    private double discountRate;

    public PercentOffDiscount(double discountRate) {
        // should do validation for us? 
        this.discountRate = discountRate;
        setDiscountRate(discountRate);
    }

    @Override
    public final double getDiscountAmount(int qty, double unitCost) {
        // needs validation 
        return unitCost * qty * getDiscountRate();
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        // needs validation 

        this.discountRate = discountRate;
    }

}
