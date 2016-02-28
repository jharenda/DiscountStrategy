
package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class NoDiscount implements DiscountStrategy {
    private double discountRate;
    private final int NO_DISCOUNT = 0; 

    public NoDiscount() {
    }

    
    @Override
    public final  double getDiscountAmount(int qty, double unitCost) {
     // needs validation 
     return  NO_DISCOUNT; 
    }

    public final  double getDiscountRate() {
        return discountRate;
    }

    public  final void setDiscountRate(double discountRate) {
        if (discountRate < 0)
            System.out.println("NoDiscount.setDiscountRate given illegal argument.");
        this.discountRate = discountRate;
    }
    
}
