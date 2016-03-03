package jh.discountstrategy;

/**
 * An implementation of the DiscountStrategy contract that uses a percent off of
 * the regular price as the discount.
 *
 * @author Jennifer
 */
public class PercentOffDiscount implements DiscountStrategy {

    private double discountRate;
 /**
     * Custom constructor requires a discount rate which is the percent off
     * used for this discount.
     * @param discountRate 
     */
    public PercentOffDiscount(double discountRate) {
        // should do validation for us? 
        this.discountRate = discountRate;
        setDiscountRate(discountRate);
    }
 
    /**
     * Calculates the discount based on the quantity of product purchased and 
     * the unit cost of that product and the percent off
     * @param qty
     * @param unitCost
     * @return qty * unitCost * discount percentage
     */
    @Override
    public final double getDiscountAmount(int qty, double unitCost) {
        // needs validation 
        return unitCost * qty * getDiscountRate();
    }
// No JavaDoc unitil validation is added.\\
    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        // needs validation 

        this.discountRate = discountRate;
    }

}
