/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

/**
 *This is a strategy implementation of the ReceiptFormatStrategy contract that
 * shows a simple line item. After I format it, will update this to say what it includes. 
 * @author Jennifer
 */
public class SimpleReceiptFormat implements OutputFormatStrategy {

    @Override
    public final String formatOutput(Receipt receipt) {
        // needs validation 
        double total = receipt.total();
        StringBuilder sb = new StringBuilder();
        LineItem[] items = receipt.getLineItems();
        for (LineItem item : items) {

            sb.append(String.format("\n%-8s", item.getProduct().getProductId()));
            sb.append(String.format("%-25s", item.getProduct().getProductName()));
            sb.append(String.format("%8.2f", item.getProduct().getUnitCost()));
            sb.append(String.format("%10d", item.getQty()));
            sb.append("  "); 
            sb.append( item.getSubTotal()); 
                    sb.append(item.getProduct().getDiscountedProductTotal(item.getQty()));

        }
        sb.append("\n Total pre-discount: " + total);
        sb.append("\n + Total discount applied:  " + receipt.getTotalDiscount());
        sb.append("\n Total Due: " + receipt.total() - receipt.getTotalDiscount());
        return sb + "\n  simple";
    }

}
