package jh.discountstrategy;

/**
 * An implementation of the DiscountStrategy contract that represents no
 * discount whatsoever.
 * @author Jennifer
 */
public class NoDiscount implements DiscountStrategy {

    private double discountRate;
    private final int NO_DISCOUNT = 0;

    public NoDiscount() {
    }
// Getters and Setters- no JavaDoc until validation\\
    @Override
    public final double getDiscountAmount(int qty, double unitCost)throws IllegalArgumentException {
     if ( qty <= 0  || unitCost <= 0)
            {
               throw new IllegalArgumentException("0 @ NoDiscount.getDiscountAmt");
           }
        return NO_DISCOUNT;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    public final void setDiscountRate(double discountRate) throws IllegalArgumentException {
      if (discountRate !=0 )
            {
               throw new IllegalArgumentException("Bad discount Rate @ NoDiscount.setDiscountRate");
           }
       this.discountRate = NO_DISCOUNT; 
    }

}
