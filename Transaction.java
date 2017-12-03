/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

/**
 *
 *@author Chris
 */
public class Transaction {
    private final String product;
    private final double price;
    private final boolean sale;
    public Transaction(String p, double pr, Boolean s){
        this.product = p;
        this.price = pr;
        this.sale = s;
    }
    public String getProduct(){
        return product;
    }
    public double getPrice(){
        return price;
    }
    public boolean getSale(){
        return sale;
    }
}
