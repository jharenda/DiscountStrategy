
package jh.discountstrategy;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Jennifer
 */
public class Receipt {
    private DBS db; 
    private Customer customer; 
   private final Date date = Calendar.getInstance().getTime();
   private LineItem[] lines = new LineItem[0];

    public Receipt( String custId, DBS db) {
        setDb(db); 
        setCustomer(db.findCustomerById(custId)); 
    }

    public final  DBS getDb() {
        return db;
    }

    public final  void setDb(DBS db) {
         if(db == null) {
            System.out.println("LineItem.setDb method given illegal argument");
        }

        this.db = db;
    }

    public final  Customer getCustomer() {
        return customer;
    }

    public  final void setCustomer(Customer customer) {
        //needs validation 
        this.customer = customer;
    }
     public final void printReceipt(){
         // cant do output here, bu 
         System.out.println(customer.getName() +  date + lines);
    }
}
