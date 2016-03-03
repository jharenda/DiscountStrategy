package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public interface DiscountStrategy {

    public abstract double getDiscountAmount(int qty, double unitCost);

}
