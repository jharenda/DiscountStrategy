/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

import javax.swing.JOptionPane;

/**
 *
 * @author Jennifer
 */
public class ScreenOutput  implements OutputStrategy{
     @Override

     public final void printReceipt(String output) {
    try {  JOptionPane.showMessageDialog(null, output);
    }catch (IllegalArgumentException e ){
        System.out.println(e.getMessage()); 
    }
         
}
}
    

