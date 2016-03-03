package jh.discountstrategy;

/**
 * An implementation of the DatabaseStrategy contract. This fakes database
 * access by using arrays of hard-code products and customers. There currently
 * is no way of modifying these.
 *
 * @author Jennifer
 */
public class FakeDatabase implements DatabaseStrategy {

    private Customer[] customers = {
        new Customer("100", "Peggy Olsen"),
        new Customer("102", "Don Draper"),
        new Customer("117", "Joan Harris")};

    private Product[] products = {
        new Product("11", "Met's Hat     ", 29.95, new PercentOffDiscount(.10)),
        new Product("12", "Women's Blouse", 49.95, new FlatAmountDiscount(5.00)),
        new Product("17", "Mens's Belt   ", 39.95, new NoDiscount())};

    /**
     * Finds a customer by its unique id.
     *
     * @param custId
     * @return a Customer object or null if not found
     */
    @Override
    public final Customer findCustomerById(String custId) {
        // needs validation 
        Customer customer = null;

        for (Customer c : customers) {
            if (c.getCustomerId().equals(custId)) {
                customer = c;
                break;
            }
        }

        return customer;

    }

    /**
     * Finds a product by its unique id.
     *
     * @param productId
     * @return a Product object or null if not found
     */
    @Override
    public final Product FindProductById(String productId) {
        // needs validation 
        Product product = null;

        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                product = p;
                break;
            }
        }

        return product;

    }
}
