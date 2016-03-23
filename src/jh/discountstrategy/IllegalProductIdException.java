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
public class IllegalProductIdException extends IllegalArgumentException {
// nees to have all the constructiors of the superclass
    
    private static final String ERR_MSG = "Prod. Id must be 5 characters long."; 
    
    
    public IllegalProductIdException() {
         super(ERR_MSG);
    }

    public IllegalProductIdException(String s) {
        super(ERR_MSG);
    }

    public IllegalProductIdException(String message, Throwable cause) {
        super(ERR_MSG, cause);
    }

    public IllegalProductIdException(Throwable cause) {
        super(cause);
    }
    
     
    
}
