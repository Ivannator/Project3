/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denzel Saraka
 */
public class WarehouseTypes {
    public enum Warehouse{
        Main, Sales;
        
    }
    Warehouse name;
    public WarehouseTypes(Warehouse n){
        name=n;
    }
    public void selectWH(){
        switch(name){
            case Main:
                System.out.println("Main warehouse");
                break;
            case Sales:
                System.out.println("Sales Van");
                break;
        }
    }
        
}
