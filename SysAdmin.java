package finalproject;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denzel Saraka
 */
public class SysAdmin extends OfficeManager {

    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;
    private int position;
    private String file;
    private ArrayList<Account> a;
    public SysAdmin(String f, String l, String e, String u, String p, int pos, String fi) {
        super(f, l, e, u, p, pos, fi);
        a= new ArrayList<Account>();
        
    }
    public void add(Account b){
        a.add(b);
    }
    public void delete(String b) {
        for (Account ab : a) {
          if (ab.getUsername().equals(b)) {
               System.out.println(ab.getUsername());
               a.remove(ab);
            }
        }
        
    }

    public void edit(String name, int newPos) {
        for (Account ab : a) {
          if (ab.getUsername().equals(name)) {
               System.out.println(ab.getUsername()+" has recieved a position change");
               ab.setPosition(newPos);
            }
        }

    }
}