/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Denzel Saraka
 */
public class SalesAssociate {
    protected ArrayList<Transaction> t = new ArrayList<>();
    private String first;
    private String last;
    private String user;
    private String email;
    private String pass;
    private Warehouse w;
    private String tFile;
    private String file;
    
    public SalesAssociate(String f, String l, String e, String u, String p, String fi ){
        first=f;
        last=l;
        email=e;
        user=u;
        pass=p;
        file = fi;
        tFile = u + "T.txt";
        w = new Warehouse(user, file);
        
    }
    
    public void sellPart(String n, int q){
        Inventory part = null;
        for(int i = 0; i < w.getArrayList().size(); i++){
            if(n.equalsIgnoreCase(w.getArrayList().get(i).getIName()))
                part = w.getArrayList().get(i);
        }
        part.downQuantity(q);
        double pr = 0.0;
        if(part.getOnSale() == true)
            pr = part.getSPrice();
        else
            pr = part.getPrice();
        Transaction trans = new Transaction(part.getIName(), pr);
        t.add(trans);
    }
    
    public void invoice(){
        FileWriter fw = new FileWriter(user+"Invoice.txt");
        BufferedWriter bw = new BufferedWriter(fw);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        //*textfield*.append(dateFormat.format(cal) + "\n");
        for(int i = 0; i < t.size(); i++){
            //*textfeld*.append(i.getProduct() + " " + i.getPrice() + "\n");
            bw.write(i.getProduct() + " " + i.getPrice());
            bw.newLine();
        }
    }
    public String getFile(){
        return file;
    }
    public String getTFile(){
        return tFile;
    }
    public ArrayList getTrasactions(){
        return t;
    }
    
}
