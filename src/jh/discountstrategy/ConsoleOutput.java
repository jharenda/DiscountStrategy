/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

/**
 *
 * @author Jennifer
 */
public class ConsoleOutput implements OutputStrategy {
    // doesn't work, so waiting to see in class how we go about actually prinitng a receipt
    // guessing I need to pass some items into here, but out of time to test it for now
Receipt r = new Receipt();
    @Override
    public void printReceipt() {
        System.out.println(today + );
    }
    
}
