
package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class Register {
    private Receipt receipt;
    private String storeName; 
    
    
    
    public final void startNewSale(String custId, DBS db) {
        //needs validation 
        receipt = new Receipt( custId, db); 
    }
    public final  void endSale() {
        
    }
    public  final void addItemToSale(String prodId, int qty) {
     
    }

    public final  Receipt getReceipt() {
        return receipt;
    }

    public final  void setReceipt(Receipt receipt) {
      if(receipt == null) {
            System.out.println("Register.setReceipt method given illegal argument");
        }
        this.receipt = receipt;
    
    }

    public final  String getStoreName() {
        return storeName;
    }

    public final  void setStoreName(String storeName) {
           if(storeName == null) {
            System.out.println("Receipt.setStoreName method given illegal argument");
        }
    
        this.storeName = storeName;
    }
    
    
    
}
