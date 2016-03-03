/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class VerboseReceiptFormat implements OutputFormatStrategy {
/**
     * Formats receipt data using information on the receipt.
     * @param receipt - the container of receipt data
     * @return - data in proper format
     */
    @Override
    public final String formatOutput(Receipt receipt) {
        // needs validation 
        StringBuilder sb = new StringBuilder();
        LineItem[] items = receipt.getLineItems();
        for (LineItem item : items) {

            sb.append(String.format("\n%-8s", item.getProduct().getProductId()));
            sb.append(String.format("%-25s", item.getProduct().getProductName()));
            sb.append(String.format("%8.2f", item.getProduct().getUnitCost()));
            sb.append(String.format("%10d", item.getQty()));

        }
        return sb + " verbose";
    }

}