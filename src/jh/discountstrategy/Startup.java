package jh.discountstrategy;

import java.text.NumberFormat;

/**
 *
 * @author Jennifer
 */
public class Startup {

    /**
     * Startup class mimics the cashier pushing buttons on the register.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // KLUDGE: do configuration here
        DatabaseStrategy db = new FakeDatabase();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        ScreenOutput gui = new ScreenOutput();
        OutputFormatStrategy verboseOutput = new VerboseReceiptFormat();
        OutputFormatStrategy simpleOutput = new SimpleReceiptFormat();
        // Start talking to objects
        Register reg = new Register();
      
        reg.startNewSale("100", db, "Kohls");
        
    
        
       

        reg.addItemsToSale("11", 1);
        reg.addItemsToSale("12", 2);
        reg.addItemsToSale("17", 1);
        //output not formatted for gui, but could be done in the class
        reg.endSale(gui, simpleOutput);
        reg.endSale(consoleOutput, verboseOutput);

    }

}
