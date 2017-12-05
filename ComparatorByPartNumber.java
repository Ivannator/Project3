/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.util.Comparator;

/**
 *
 * @author Chris
 */
public class ComparatorByPartNumber implements Comparator<Inventory> {

    /**
     *
     * @param bp
     * @param bp2
     * @return
     */
    @Override
    public int compare(Inventory bp, Inventory bp2){
        return bp.getNum().compareTo(bp2.getNum());
    }
}
