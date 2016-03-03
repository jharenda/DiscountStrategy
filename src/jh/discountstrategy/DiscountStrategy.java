package jh.discountstrategy;

/**
 * The general contract for all discount strategy implementations
 *
 * @author Jennifer
 */
public interface DiscountStrategy {

    public abstract double getDiscountAmount(int qty, double unitCost);

}
