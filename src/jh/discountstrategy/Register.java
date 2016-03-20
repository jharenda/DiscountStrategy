package jh.discountstrategy;

/**
 *This class simulates the cash register at a department store.
 * Need to add more detailed explanation.
 * @author Jennifer
 */
public class Register {

    private Receipt receipt;
    private String storeName; // = "Kohls ";

    public final void startNewSale(String custId, DatabaseStrategy db, String storeName) throws IllegalArgumentException  {
        //needs validation. SHould check for null or illegal values. 
        if(custId == null || custId.isEmpty() || db == null || storeName == null || storeName.isEmpty() ) {
            throw new IllegalArgumentException("Illegal, man");
        }
        else 
        receipt = new Receipt(custId, db, this.storeName);
    }
/**
     * End the sale for a customer and causes a receipt to be output, 
     * possibly to multiple destinations.
     * @param out
     * @param outputFormat
     */
    public final void endSale(OutputStrategy out, OutputFormatStrategy outputFormat) throws IllegalArgumentException{
        if(out == null || outputFormat == null) 
            {
               throw new IllegalArgumentException("output error");
           }
       
        String x = outputFormat.formatOutput(receipt);

        out.printReceipt(x);

    }
 /**
     * Adds an item to a sale order. NOTE: currently no validation of
     * method arguments.
     * @param prodId - the unique id of a product which simulates what a
     * bar code scanner would capture
     * @param qty - the number of this product being purchased
     */
       public final void addItemsToSale(String prodId, int qty) throws IllegalArgumentException {
           if( prodId == null || prodId.isEmpty() || qty <= 0 || qty > 3000){
               throw new IllegalArgumentException("Product id or qty error");
           }
       else
        receipt.addItemToReceipt(prodId, qty);
    }
    // getters and setters- add JavaDoc after validation updated. 
    public final Receipt getReceipt() {
        return receipt;
    }

    public final void setReceipt(Receipt receipt)throws IllegalArgumentException {
        if(receipt == null)
            {
               throw new IllegalArgumentException("Receipt is null");
           }
     
        this.receipt = receipt;

    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setStoreName(String storeName) throws IllegalArgumentException  {
        if(storeName == null || storeName.isEmpty() || storeName.length() <=1){
               throw new IllegalArgumentException("StoreName Error");
           }
      

        this.storeName = storeName;
    }

 

}
