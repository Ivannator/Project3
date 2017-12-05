/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Chris
 */
public class Inventory {
    public int quant;
    public BikePart b;
    public Inventory(BikePart bp, int quantity){
        quant = quantity;
        b = bp;
    }
    public int getQuantity(){
        return quant;
    }
    public void setQuantity(int q){
        quant = q;
    }
    public void upQuantity(int q){
            quant += q;
            System.out.println(quant);
    }
    public void downQuantity(int q){
        quant -= q;
        System.out.println(quant);
    }
    public void sellItem(){
        quant--;
    }
    public String toString(){
        String bp = b.toStringB() + "," + quant;
        return bp;
    }
    public String getName(){
        return b.getName();
    }
    public double getPrice(){
        return b.getPrice();
    }
    public String getNum(){
        return b.getPNumString();
    }
    public double getSPrice(){
        return b.getSale();
    }
    public boolean getOnSale(){
        return b.getOnSale();
    }
    public Inventory getInventory(BikePart bp, int q){
        Inventory i = new Inventory(bp,q);
        return i;
    }
    public BikePart getBikePart(){
        return b;
    }

    /**
     *
     * @return
     */
    public String getIName(){
        return b.getName();
    }
    public void upIPrice(int p){
        b.upPrice(p);
    }
    public void upSPrice(int s){
        b.upSalePrice(s);
    }
    public void upOnISale(Boolean bo){
        b.upOnSale(bo);
    }
}
