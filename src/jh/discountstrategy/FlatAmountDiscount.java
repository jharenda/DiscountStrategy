package jh.discountstrategy;

/**
 * An implementation of the DiscountStrategy contract representing a flat dollar
 * amount off the regular price.
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

    /**
     * Gets a flat amount off the regular price regardless of quantity.
     *
     * @param qty - the quantity of product purchased. NOTE: not currently
     * validated
     * @param unitCost - the original price of one product. NOTE: not currently
     * validated.
     * @return
     */
    @Override
    public final double getDiscountAmount(int qty, double unitCost) {
        // needs validation 
        return discountRate;
    }
// Getters and Setters do not need JavaDoc Unitl Validation Added// 

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) {
        // needs validation 
        this.discountRate = discountRate;
    }

}
