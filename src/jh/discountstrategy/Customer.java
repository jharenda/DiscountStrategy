package jh.discountstrategy;

/**
 * A simulation of a customer.
 *
 * @author Jennifer
 */
public class Customer {

    private String customerId;
    private String name;
// public methods with parameters need validation 

    /**
     * Custom constructor initializes required fields.
     *
     * @param name - name of customer
     * @param customerId - an unique customer id
     *
     */
    public Customer(String customerId, String name){
        //doing it this way will let the setters do the validation for us. 
        // all methods should be final - open close principle 
        setCustomerId(customerId);
        setName(name);
    }

    // GETTERS/SETTERS DON'T NEED DOCS UNTIL VALIDATION CODE ADDED //
    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) throws IllegalArgumentException {
        if ( customerId == null || customerId.isEmpty())
            {
               throw new IllegalArgumentException("Null @ Customer.setCustomerId");
           }
        this.customerId = customerId;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) throws IllegalArgumentException {
         if ( name == null || name.isEmpty())
            {
               throw new IllegalArgumentException("Null @ Customer.setName");
           }
        this.name = name;
    }

}
