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

     // GETTERS/SETTERS DON'T NEED DOCS UNTIL VALIDATION CODE ADDED //
    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) {
        // needs validation 
        this.customerId = customerId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        // needs validation 
        this.name = name;
    }

}
