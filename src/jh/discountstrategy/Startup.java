
package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // KLUDGE: do configuration here
    DBS db = new FakeDatabase(); 
    
    
    // Start talking to objects
    Register reg = new Register(); 
    reg.startNewSale("100", db);
    
    }
    
}
