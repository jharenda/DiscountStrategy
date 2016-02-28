package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class Customer {

    private String customerId;
    private String name;
// public methods with parameters need validation 

    public Customer(String customerId, String name) {
        //doing it this way will let the setters do the validation for us. 
        // all methods should be final - open close principle 
        setCustomerId(customerId);
        setName(name);
    }

    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) {
        if (customerId == null) {
            System.out.println("Customer.setCustID method given illegal argument");
        }
        this.customerId = customerId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        if (name == null) {
            System.out.println("Customer.setName method given illegal argument");
        }
        this.name = name;
    }

}
