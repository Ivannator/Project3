package finalproject;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denzel Saraka
 */
public class WhManager extends SalesAssociate{
    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;
    private String file;
    private Scanner input;
    protected Warehouse w;
    private ArrayList<Inventory> inventory;
    private int position;
    
    
    public WhManager(String f, String l, String e, String u, String p, int pos, String fi ){
        super(f, l, e, u,p,pos, fi);
    }
    public void read (String a){
        try {

            Scanner input = new Scanner(System.in);

            File file = new File(a);
            input = new Scanner(file);
            while (input.hasNextLine()) {
                String line = input.nextLine();
               String[] split = line.split(",");

                BikePart bp = new BikePart(split[0], Integer.parseInt(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Boolean.parseBoolean(split[4]));
                Inventory in = new Inventory(bp, Integer.parseInt(split[5]));
                addPart(in);
                System.out.println(line);

            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public void addPart(Inventory b) {
        inventory.add(b);
    }    
    public Warehouse getWarehouse(){
        return w;
    }
    
}
