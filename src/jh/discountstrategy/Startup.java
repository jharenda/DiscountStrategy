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
        DBS db = new FakeDatabase();
        ConsoleOutput consoleOutput = new ConsoleOutput();
        guiOutput gui = new guiOutput();
        // Start talking to objects
        Register reg = new Register();
        reg.startNewSale("100", db, "KOHLS");

        reg.addItemsToSale("11", 2);
        reg.addItemsToSale("12", 2);
        reg.addItemsToSale("17", 1);
        //output not formatted for gui, but could be done in the class
        reg.endSale(gui);
        reg.endSale(consoleOutput);

    }

}
