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
    private ArrayList<SalesAssociates> sA = new ArrayList<>();
    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;

    public OfficeManager(String f, String l, String e, String u, String p) {
        super(f, l, e, u, p);
    }

    public void transactions() {
        FileWriter fw = new FileWriter("transactions.txt",0);
        BufferedWriter bw = new BufferedWriter(fw);
        String name = "";
        SalesAssociate salAs = null;
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        bw.write(dateFormat.format(cal)));
        bw.newLine();
        for(int i = 0 ; i < sA.size(); i++){
            salAs = sA.get(i);
            ArrayList tr = salAs.getTransactions();
            name = salAs.getUsername();
            bw.write(name);
            bw.newLine();
            for(int i = 0; i < tr.size(); i++){
                bw.write(tr.get(i).getProduct() + " " + tr.get(i).getPrice());
                bw.newLine();
            }
    }
    public String findFile(SalesAssociate sa){
        return sa.getTFile();
    }
        
    public void orderNewParts(){

    }
        
    public void salesCommission(){

    }

}
