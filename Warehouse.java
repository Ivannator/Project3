/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;


/**
 *
 * @author Chris
 */
public class Warehouse 
{
    public static ArrayList<Inventory> parts = new ArrayList();
    public String name;
    public String fileName;
    public int number;
    public Warehouse(String n, String fName)
    {
        name = n;
        fileName = fName;
    }
    
    /**
     * 
     * @return 
     */
    public String getWName()
    {
        return name;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList getArrayList()
    {
        return parts;
    }
    
    /**
     * 
     * @return 
     */
    public int getNum()
    {
        return number;
    }
    
    /**
     * 
     * @return 
     */
    public String getFName()
    {
        return fileName;
    }
    
    /**
     * 
     * @param i 
     */
    public static void addArrayList(Inventory i)
    {
        parts.add(i);
    }
    
    @Override
    public String toString()
    {
        return name;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList sortNumber()
    {    
        Collections.sort(parts, new ComparatorByPartNumber());
        return parts;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList sortName()
    {
        Collections.sort(parts, new ComparatorByPartName());
        return parts;
    }
    
    /**
     * 
     * @param i
     * @param q
     * @param w 
     */
    public void moveParts(Inventory i, int q, Warehouse w)
    {
        Inventory in = null;
        for (Inventory part : Warehouse.parts) 
        {
            if(part.getName().equals(i.getName()))
            {
                in = part;
            }
        }
        BikePart bp = in.getBikePart();
        int n = 0;
        for(int a = 0; a < w.getArrayList().size(); a++)
        {
            Inventory inven = (Inventory) w.getArrayList().get(a);
            if(inven.getName().equals(bp.getName()))
            {
                inven.upQuantity(q);
            }
            else
            {
                n++;
            }
        }
        
        if(n == w.getArrayList().size())
        {
            Inventory inv = new Inventory(bp, q);
            w.addArrayList(inv);
        }
        in.downQuantity(q);
    }
    
    public static void sellPart(String n, int q)
    {
        Inventory part = null;
        for(int i = 0; i < parts.size(); i++)
        {
            if(n.equals(parts.get(i).getIName()))
                part = parts.get(i);
        }
        part.downQuantity(q);
        double pr = 0.0;
        if(part.getOnSale() == true)
            pr = part.getSPrice();
        else
            pr = part.getPrice();
        Transaction trans = new Transaction(part.getIName(), pr, part.getOnSale());
        SalesAssociate.getTransactions().add(trans);
    }
}
