package finalproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denzel Saraka
 */
public class OfficeManager extends WhManager {
    private ArrayList<SalesAssociate> sA = new ArrayList<>();
    private WhManager[] WhManagerArray = new WhManager[1];
    private ArrayList<Double> commission = new ArrayList<>();
    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;
    private int position;
    private String file;
    public OfficeManager(String f, String l, String e, String u, String p, int pos, String fi) {
        super(f, l, e, u, p, pos, fi);
    }

    public void transactions() throws IOException {
        FileWriter fw = new FileWriter("transactions.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        String name = "";
        SalesAssociate salAs = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        bw.write(dateFormat.format(cal));
        bw.newLine();
        for(int i = 0 ; i < sA.size(); i++){
            salAs = sA.get(i);
            ArrayList tr = salAs.getTransactions();
            salesCommission(tr);
            name = salAs.getUsername();
            bw.write(name);
            bw.newLine();
            for(int j = 0; i < tr.size(); j++){
                bw.write(tr.get(i).toString());
                bw.newLine();
            }
        }
    }

    /**
     *
     * @param sa
     * @return
     */
    public String findFile(SalesAssociate sa){
        return sa.getTFile();
    }
        
    public void orderNewParts(){
        ArrayList<Inventory> parts = WhManagerArray[0].getWarehouse().getArrayList();
        int a =0;
        for(int i = 0; i < parts.size(); i++){
            if(parts.get(i).getQuantity() < 5){
                //*TextArea*.append("You need to order more " + parts.get(i).getIName() + "!");
            }
            else{
                a++;
            }
        }
        if(a == parts.size()){
             //*TextArea*.append("You are good on all products!");
        }
        else{
             //*TextArea*.append("All other products are good!");
        }
    }
        
    public void salesCommission(ArrayList<Transaction> t){
        double total = 0.0;
        for(int i = 0; i < t.size(); i++){
            total += t.get(i).getPrice();
        }
        double com = total * .15;
        commission.add(com);
    }
    public ArrayList getSalesAssociates(){
        return sA;
    }
    public void addWhManager(WhManager whm){
        WhManagerArray[0] = whm;
    }

}
