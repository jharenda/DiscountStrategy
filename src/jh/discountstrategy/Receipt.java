package jh.discountstrategy;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *This class simulates a receipt. JavaDoc incomplete 
 * @author Jennifer
 */
public class Receipt {

    private NumberFormat nf = NumberFormat.getCurrencyInstance();
    private DatabaseStrategy db;
    private Customer customer;
    private final Date date = Calendar.getInstance().getTime();
    private LineItem[] lineItems;
    private double total;
    private double totalDiscount;
    private String storeName;

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName)throws IllegalArgumentException {
        // needs validation 
        this.storeName = storeName;
    }
 /**
     * Custom constructor initializes required fields.
     * @param storeName - name of seller
     * @param custId - an unique customer id
     * @param db - the persistence solution
     */
    public Receipt(String custId, DatabaseStrategy db, String storeName) {
        setDb(db);
        setStoreName(storeName);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }

    public final String lineItemHeader() {
        String header = "ID       Name                       Qty             Subtotal       Sbt. After Dis        Saved\n----    ----------                       -----            ------------        ------------------       ---------";
        return header;
    }

    public final Date getDate() {
        return date;
    }

    public final DatabaseStrategy getDb() {
        return db;
    }

    public final void setDb(DatabaseStrategy db)throws IllegalArgumentException {
   if (db == null)
  
            {
               throw new IllegalArgumentException("null @ Receipt.setDb");
           }  
   

        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) throws IllegalArgumentException{
       if (customer == null)
            {
               throw new IllegalArgumentException("null @ Receipt.setCustomer");
           }
        this.customer = customer;
    }

    public final double total() {
        double preDiscountTotal = getSubTotalBeforeDiscount();
        return preDiscountTotal;
    }

    public final String printReceipt() {
        //System.out.println(getTotalDiscount());
        double preDiscountTotal = getSubTotalBeforeDiscount();
        double postDiscountTotal = getTotalDiscount();
        double amtSaved = preDiscountTotal - postDiscountTotal;
        StringBuilder sb;
        sb = new StringBuilder(storeName + "\n" + customer.getName() + "\n" + date + "\n" + lineItemHeader() + "\n");
        LineItem[] items = getLineItems();
        for (LineItem item : items) {

            sb.append(item.getLineItemData());
            sb.append("\n");

        }
        sb.append("\n");
        sb.append("Total prior to discount: ").append(nf.format(preDiscountTotal));
        sb.append("\n");
        sb.append("Total After disount: ").append(nf.format(postDiscountTotal));
        sb.append("\n");
        sb.append("Total Discounts applied: ").append(nf.format((amtSaved)));
        String rec = sb.toString();
        return rec;

    }

    public final void addItemToReceipt(String productId, int qty)throws IllegalArgumentException {
      if ( qty <= 0  ||productId == null || productId.isEmpty())
            {
               throw new IllegalArgumentException("0 or null/empty @ Receipt.addItemToReceipt");
           }
        LineItem item = new LineItem(productId, qty, db);
        addItemToArray(lineItems, item);
    }

    private final void addItemToArray(LineItem[] origArray, LineItem item)throws IllegalArgumentException {
       if ( origArray == null || item == null)
            {
               throw new IllegalArgumentException("null @ Receipt.addItemToArray");
           }
        LineItem[] temp = new LineItem[origArray.length + 1];
        System.arraycopy(origArray, 0, temp, 0, origArray.length);
        temp[temp.length - 1] = item;
        lineItems = temp;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final double getSubTotalBeforeDiscount() {
        total = 0.0;
        for (LineItem item : lineItems) {
            total += item.getSubTotal();
        }
        return total;
    }

    public final double getTotalDiscount() {
        totalDiscount = 0.0;
        for (LineItem item : lineItems) {
            totalDiscount += item.getDiscountedSubTotal();
        }
        return totalDiscount;
    }

    public final void setLineItems(LineItem[] lineItems)throws IllegalArgumentException {
    if ( lineItems == null)
            {
               throw new IllegalArgumentException("null @ Receipt.setLineItems");
           }
        this.lineItems = lineItems;
    }

}
