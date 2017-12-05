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
    private ArrayList<SalesAssociates> sA = new ArrayList<>();
    private WhManager WhManagerArray[1];
    private ArrayList<Double> commision = new ArrayList<>();
    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;
    private position;
    public OfficeManager(String f, String l, String e, String u, String p) {
        super(f, l, e, u, p);
        position=3;
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
            salesCommision(tr);
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
        ArrayList parts = WhManager[0].getWarehouse().getArrayList();
        int a =0;
        for(int i = 0; i < parts.size(); i++){
            if(parts.get(i).getQuantity() < 5)
                //*TextArea*.append("You need to order more " + parts.get(i).getIName() + "!");
            else
                a++;
        }
        if(a == parts.size())
             //*TextArea*.append("You are good on all products!");
        else
             //*TextArea*.append("All other products are good!");
    }
        
    public void salesCommission(ArrayList t){
        double total = 0.0;
        for(int i = 0; i < t.size(); i++){
            total += t.get(i).getPrice();
        }
        double com = total * .15;
        commision.add(com);
    }

}
