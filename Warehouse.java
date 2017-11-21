/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import javafx.event.ActionEvent;

/**
 *
 * @author Chris
 */
public class Warehouse {
    public static ArrayList<Inventory> parts = new ArrayList();
    public String name;
    public String fileName;
    public int number;
    public Warehouse(String n, String fName){
        name = n;
        fileName = fName;
    }
    /**
     * 
     * @return 
     */
    public String getWName(){
        return name;
    }
    /**
     * 
     * @return 
     */
    public ArrayList getArrayList(){
        return parts;
    }
    /**
     * 
     * @return 
     */
    public int getNum(){
        return number;
    }
    /**
     * 
     * @return 
     */
    public String getFName(){
        return fileName;
    }
    /**
     * 
     * @param i 
     */
    public static void addArrayList(Inventory i){
        parts.add(i);
    }
    @Override
    public String toString(){
        return name;
    }
    public ArrayList sortNumber(){    
        Collections.sort(parts, new ComparatorByPartNumber());
        return parts;
    }
    public ArrayList sortName(){
        Collections.sort(parts, new ComparatorByPartName());
        return parts;
    }
}
