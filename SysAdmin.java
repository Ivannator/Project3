
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
public class SysAdmin extends WhManager {

    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;
     private ArrayList<Account> a;
    public SysAdmin(String f, String l, String e, String u, String p) {
        super(f, l, e, u, p);
        a= new ArrayList<Account>();
        
    }
    public void add(Account b){
        a.add(b);
    }
    public void delete(String b) {
        for (Account ab : a) {
          if (ab.getUser().equals(b)) {
               System.out.println(ab.getName());
               ab.remove();
            }
        }
        
    }

    public void edit(int originalPos, int newPos) {
        
    }

}
