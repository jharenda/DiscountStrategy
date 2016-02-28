package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class Register {

    private Receipt receipt;
    private String storeName = "Kohls ";

    public final void startNewSale(String custId, DBS db, String storeName) {
        //needs validation. SHould check for null or illegal values. 
        receipt = new Receipt(custId, db, this.storeName);
    }

    public final void endSale(OutputStrategy out) {
        out.printReceipt(receipt);

    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        if (receipt == null) {
            System.out.println("Register.setReceipt method given illegal argument");
        }
        this.receipt = receipt;

    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) {
        if (storeName == null) {
            System.out.println("Receipt.setStoreName method given illegal argument");
        }

        this.storeName = storeName;
    }

    public final void addItemsToSale(String prodId, int qty) {

        receipt.addItemToReceipt(prodId, qty);
    }

}
