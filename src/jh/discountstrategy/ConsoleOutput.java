/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

/**
 * An implementation of the the OutputStrategy contract which simulates the
 * printed paper receipt that comes out of a real Cash Register.
 *
 * @author jennifer
 */
public class ConsoleOutput implements OutputStrategy {

    /**
     * Outputs the receipt data to selected destination.
     *
     * @param output - the data to output. NOTE: not currently validated!
     */
    @Override
    public void printReceipt(String output) throws IllegalArgumentException {
        if (output == null || output.isEmpty())
            {
               throw new IllegalArgumentException("Null @ ConsoleOutput.printReceipt");
           }
       try {  System.out.println(output);
    }catch (IllegalArgumentException e ){
        System.out.println(e.getMessage()); 
    }
          
        System.out.println(output);
    }

}
