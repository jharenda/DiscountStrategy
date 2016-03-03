/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

import javax.swing.JOptionPane;

/**
 * Would need to do gui- specific formatting here, but it works otherwise
 *
 * @author Jennifer
 */
public class guiOutput implements OutputStrategy {

    @Override
    public final void printReceipt(String output) {
        // needs validation 
        JOptionPane.showMessageDialog(
                null, output);
    }

}
