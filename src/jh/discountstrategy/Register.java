package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class Register {

    private Receipt receipt;
    private String storeName = "Kohls ";

    public final void startNewSale(String custId, DatabaseStrategy db, String storeName) {
        //needs validation. SHould check for null or illegal values. 
        receipt = new Receipt(custId, db, this.storeName);
    }

    public final void endSale(OutputStrategy out, OutputFormatStrategy outputFormat) {
        // needs validation 
        String x = outputFormat.formatOutput(receipt);

        out.printReceipt(x);

    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt) {
        // needs validation 
        this.receipt = receipt;

    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) {
        // needs validation 

        this.storeName = storeName;
    }

    public final void addItemsToSale(String prodId, int qty) {
        // needs validation 
        receipt.addItemToReceipt(prodId, qty);
    }

}
