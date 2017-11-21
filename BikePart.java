/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;


/**
 *
 * @author Ivan
 */
public class BikePart {
    private final String pNam;
    private final int pNum;
    private double oPrice;
    private double sPrice;
    private boolean tSale;
    /**
     *@param pName part name
     * @param pNumber part number
     * @param price original price for product
     * @param sale sale price for product
     * @param onSale if product is on sale or not
     * @param quantity mow many of product
     */
    public BikePart(String pName,int pNumber, double price, double sale, boolean onSale){
        pNam = pName;
        pNum = pNumber;
        oPrice = price;
        sPrice = sale;
        tSale = onSale;
    }
    /**
     * @return returns part name
     */
    public String getName(){
        return pNam;
    }
    /**
     * @return returns part number
     */
    public int getPNum(){
        return pNum;
    }
    public String getPNumString(){
        String num = Integer.toString(pNum);
        return num;
    }
    /** 
     * @return returns original price
     */
    public double getPrice(){
        return oPrice;
    }
    /**
     * @return returns sale price
     */
    public double getSale(){
        return sPrice;
    }
    /**
     * @return returns if the product is on sale or not
     */
    public boolean getOnSale(){
        return tSale;
    }
    public void upOnSale(Boolean s){
        tSale = s;
    }
    public void upPrice(double p){
        oPrice = p;
    }
    public void upSalePrice(double s){
        sPrice = s;
    }
   public String toStringB(){
        String bp = pNam + "," + pNum + "," + oPrice + "," + sPrice + "," + tSale;
        return bp;
    } 
}
