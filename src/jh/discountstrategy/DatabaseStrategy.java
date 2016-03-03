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
public interface DatabaseStrategy {

   public abstract Product FindProductById(String productId);

   public abstract Customer findCustomerById(String custId);
    
}
