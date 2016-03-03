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
    public void printReceipt(String output) {
        // would do validation here to check arugment for validity. 
        System.out.println(output);
    }

}
