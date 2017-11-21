/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.Comparator;

/**
 *
 * @author Chris
 */
public class ComparatorByPartName implements Comparator<Inventory> {
    @Override
    public int compare(Inventory i, Inventory in) {
        return i.getIName().compareTo(in.getIName());
    }
    
}
