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

    @Override
    public void printReceipt(String output) {
        // would do validation here to check arugment for validity. 
        System.out.println(output);
    }

}
