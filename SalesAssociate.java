/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denzel Saraka
 */
package finalproject;

import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SalesAssociate 
{
    public static ArrayList<Transaction> t = new ArrayList<>();
    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;
    private Warehouse w;
    private String tFile;
    private String file;
    private int position;
    
    public SalesAssociate(String f, String l, String e, String u, String p, int pos, String fi)
    {
        first=f;
        last=l;
        email=e;
        user=u;
        pass=p;
        file = fi;
        position=pos;
        tFile = u + "T.txt";
        w = new Warehouse(user, file);
        
    }
    
    public int getPosition()
    {
        return position;
    }
    
    public void setPosition(int p)
    {
        position=p;
    }
    
    public void sellPart(String n, int q, Warehouse w)
    {
        Inventory part = null;
        for(int i = 0; i < w.getArrayList().size(); i++)
        {
            Inventory temp = (Inventory) w.getArrayList().get(i);
            if(n.equals(temp.getIName()))
                part = (Inventory) w.getArrayList().get(i);
        }
        part.downQuantity(q);
        double pr = 0.0;
        if(part.getOnSale() == true)
            pr = part.getSPrice();
        else
            pr = part.getPrice();
        Transaction trans = new Transaction(part.getIName(), pr, part.getOnSale());
        t.add(trans);
    }
    
    public void invoice() throws IOException
    {
        FileWriter fw = new FileWriter(user+"Invoice.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        //*textfield*.append(dateFormat.format(cal) + "\n");
        for(int i = 0; i < t.size(); i++){
            //*textfeld*.append(i.getProduct() + " " + i.getPrice() + " " + i.getSale() + "\n");
            bw.write(t.get(i).toString());
            bw.newLine();
        }
    }
    
    public String getFile()
    {
        return file;
    }
    public String getUsername(){
        return user;
    }
    
    public String getTFile()
    {
        return tFile;
    }
    
    public static ArrayList getTransactions()
    {
        return t;
    }
    
    public void sortPartsName()
    {
        w.sortName();
    }
    
    public void sortPartsNumber()
    {
        w.sortNumber();
    }
    public Warehouse getWarehouse(){
        return w;
    }
    
    public void move(SalesAssociate sa, String part, int quantity)
    {
        Warehouse ware = sa.getWarehouse();
        ArrayList<Inventory> sales = ware.getArrayList();
        Inventory input1 = null;
        for(int j = 0; j < sales.size(); j++)
        {
            Inventory temp = sales.get(j);
            if(part.equals(temp.getIName().equals(part)))
                input1 = sales.get(j);
        }
        this.w.moveParts(input1, quantity, ware);
    }
    
}
