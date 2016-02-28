package jh.discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author Jennifer
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     NumberFormat nf = NumberFormat.getCurrencyInstance();
        // KLUDGE: do configuration here
        DBS db = new FakeDatabase();
 
        // Start talking to objects
        Register reg = new Register();
        reg.startNewSale("100", db);
        System.out.println(reg.getStoreName());
        Customer customer = reg.getReceipt().getCustomer();
        System.out.println( reg.getReceipt().getDate());
        System.out.println("Customer " + customer.getName() + " found and added to receipt.");
        reg.addItemsToSale("11", 2);
        reg.addItemsToSale("12", 2);
        reg.addItemsToSale("17", 1);
        LineItem[] items = reg.getReceipt().getLineItems();
         System.out.println(reg.getReceipt().lineItemHeader());
        for (LineItem item : items) {
           
            System.out.println(item.getLineItemData());
        }
      double preTotal = reg.getReceipt().getSubTotalBeforeDiscount()- reg.getReceipt().getTotalDiscount();
      double finalDiscount = reg.getReceipt().getSubTotalBeforeDiscount();
        //System.out.println()("Total amount saved: " + (reg.getReceipt().getSubTotalBeforeDiscount()- reg.getReceipt().getTotalDiscount()));
       System.out.println();
       
        System.out.println("Pre- discount total:  " + nf.format((finalDiscount))); 
        System.out.println("Amount saved:          " +nf.format(preTotal ));
       
        System.out.println("Total after discount: " + nf.format((finalDiscount-preTotal)));
        
    }

}
