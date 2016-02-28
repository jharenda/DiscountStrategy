package jh.discountstrategy;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jennifer
 */
public class Receipt {

    NumberFormat nf = NumberFormat.getCurrencyInstance();
    private DBS db;
    private Customer customer;
    private final Date date = Calendar.getInstance().getTime();
    private LineItem[] lineItems;
    private double total;
    private double totalDiscount;
    private String storeName;

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        if (storeName == null || storeName.length() < 1) {
            System.out.println("Receipt.setStoreName given illegal arugument ");
        }
        this.storeName = storeName;
    }

    public Receipt(String custId, DBS db, String storeName) {
        setDb(db);
        setStoreName(storeName);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }

    public String lineItemHeader() {
        String header = "ID       Name              Qty        Subtotal       Sbt. After Dis   Saved\n";
        return header;
    }

    public Date getDate() {
        return date;
    }

    public final DBS getDb() {
        return db;
    }

    public final void setDb(DBS db) {
        if (db == null) {
            System.out.println("LineItem.setDb method given illegal argument");
        }

        this.db = db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setCustomer(Customer customer) {
        if (customer == null) {
            System.out.println("Receipt.setCustomer given illegal argument");
        }

        this.customer = customer;
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

    public final void addItemToReceipt(String productID, int qty) {
        //would need to validate parameters that are being passed in
        LineItem item = new LineItem(productID, qty, db);
        addItemToArray(lineItems, item);
    }

    private void addItemToArray(LineItem[] origArray, LineItem item) {
        LineItem[] temp = new LineItem[origArray.length + 1];
        System.arraycopy(origArray, 0, temp, 0, origArray.length);
        temp[temp.length - 1] = item;
        lineItems = temp;
    }

    public LineItem[] getLineItems() {
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

    public void setLineItems(LineItem[] lineItems) {
        //should be validated somehow
        this.lineItems = lineItems;
    }

}
