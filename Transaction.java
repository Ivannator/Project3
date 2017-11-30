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
public class Transactions {
    private final int month;
    private final int day;
    private final int year;
    private final String product;
    private final double price;
    public Transaction(int m, int d, int y, String p, double pr){
        this.month = m;
        this.day = d;
        this.year = y;
        this.product = p;
        this.price = pr;
    }
    public int getMonth(){
        return month;
    }
    public int getDay(){
        return day;
    }
    public int getYear(){
        return year;
    }
    public String getProduct(){
        return product;
    }
    public double getPrice(){
        return price;
    }
}
