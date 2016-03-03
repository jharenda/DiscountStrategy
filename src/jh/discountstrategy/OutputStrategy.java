/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

/**
 * The general contract for all output strategy implementations.
 *
 * @author Jennifer
 */
public interface OutputStrategy {

    public abstract void printReceipt(String output);
}
