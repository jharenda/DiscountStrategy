/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

import java.text.NumberFormat;

/**
 *This is a strategy implementation of the OutputFormatStrategy contract that
 * shows a simple receipt format. 
 * @author Jennifer
 */
public class SimpleReceiptFormat implements OutputFormatStrategy {
private final NumberFormat nf = NumberFormat.getCurrencyInstance();
    @Override
    public final String formatOutput(Receipt receipt) throws IllegalArgumentException {
     if (receipt == null) 
          {
               throw new IllegalArgumentException("Null @ SimoleReceiptFormat.formatOutput");
           }
        
        double total = receipt.total();
        StringBuilder sb = new StringBuilder();
        LineItem[] items = receipt.getLineItems();
        sb.append(receipt.getStoreName()).append("\n"); 
        sb.append(receipt.getDate()+ "\n");
        sb.append(receipt.getCustomer().getName()).append("\n"); 
        sb.append(receipt.lineItemHeader()).append("\n");
        for (LineItem item : items) {

            sb.append(String.format("\n%-8s", item.getProduct().getProductId()));
            sb.append(String.format("%-25s", item.getProduct().getProductName()));
            sb.append(String.format("%5s", item.getQty()));
      
            sb.append("       "); 
            sb.append("         ").append(String.format("%8.2f",  item.getSubTotal())); 
            sb.append("       "); 
            sb.append(String.format("%9.2f",+ item.getDiscountedSubTotal()));
               sb.append("               "); 
                    sb.append(String.format("%9.2f", item.getProduct().getDiscountedProductTotal(item.getQty())));
                    

        }
        sb.append("\n\n Total pre-discount: ").append(nf.format( total));
        sb.append("\n  Total due ").append(nf.format( receipt.getTotalDiscount()));
        sb.append("\n Total  discount applied:  ").append(nf.format((receipt.total() - receipt.getTotalDiscount())));
        return sb + "\n ";
    }

}
