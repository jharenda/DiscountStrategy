package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class FakeDatabase implements DBS {

    private Customer[] customers = {
        new Customer("100", "Peggy Olsen"),
        new Customer("102", "Don Draper"),
        new Customer("117", "Joan Harris")};

    private Product[] products = {
        new Product("11", "Met's Hat", 29.95, new PercentOffDiscount(.10)),
        new Product("12", "Women's Bluse", 49.95, new FlatAmountDiscount(5.00)),
        new Product("17", "Mens's Belt", 39.95, new NoDiscount())};

    @Override
    public final Customer findCustomerById(String custId) {
         Customer customer = null;
       if(custId == null) {
            System.out.println("FakeDatabase.findCustomerById method given illegal argument");
        }
       else {
       

        for (Customer c : customers) {
            if (c.getCustomerId().equals(custId)) {
                customer = c;
                break;
            }
        }
       }
        return customer;
       
    }
    @Override
    public final Product FindProductById(String productId) {   
        Product product = null;
        
        if(productId == null) {
            System.out.println("FakeDatabase.findProductById method given illegal argument");
        }
        else {
 

        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                product = p;
                break;
            }
        }
        }
        return product;
    
    }
}
