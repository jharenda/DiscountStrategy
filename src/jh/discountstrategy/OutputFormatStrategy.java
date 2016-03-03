/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jh.discountstrategy;

/**
 * The general contract for all receipt format strategy implementations.
 *
 * @author Jennifer
 */
public interface OutputFormatStrategy {

    public abstract String formatOutput(Receipt receipt);
}
