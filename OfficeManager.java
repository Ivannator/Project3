/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denzel Saraka
 */
public class OfficeManager extends SalesAssociate {

    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;

    public OfficeManager(String f, String l, String e, String u, String p, String fi) {
        super(f, l, e, u, p, fi);
    }

    public void transactions() {

    }
    public String findFile(SalesAssociate sa){
        return sa.getTFile();
    }

}
