/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package finalproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Denzel Saraka
 */
public class UserInterface {
    public static Warehouse main = new Warehouse("main", "warehouse.txt");
    public static Warehouse van = new Warehouse("JohnS", "JohnSW.txt");

    public static void main(String[] args) throws IOException {
        SalesAssociate sa = new SalesAssociate("John", "Smith", "jsmith@gmail", "JohnS", "Bik3P@rts", 1, "JohnS.txt");
        WhManager wm = new WhManager("Luke", "Conners", "lconners@gmail.com", "LukeC", "Luk3C0nn3rs", 2, "warehouse.txt");
        Scanner in = new Scanner(System.in);
            System.out.print("Enter username: ");
            String uname = in.next();
            System.out.println(" ");
            System.out.print("Enter you password: ");
            String password = in.next();
            System.out.println(" ");
            if(uname.equalsIgnoreCase("JohnS"))
                if(password.equals(sa.getPassword()))
                    System.out.println("Welcome: " + uname);
                else{
                    System.out.println("You entered the wrong password, Goodbye.");
                    System.exit(0);
                }
            else if(uname.equalsIgnoreCase("Luke"))
                if(password.equals(wm.getPassword())){
                    System.out.println("Welcome: " + uname);
                }
                else{
                    System.out.println("You entered the wrong password, Goodbye.");
                    System.exit(0);
                }
            else{
                System.out.println(uname + " was not found.");
                System.exit(0);
            }
        sa.addWarehouse(van);
        wm.addWarehouse(main);
        Warehouse wh = null;
        wm.addWarehouse(wh);
        FileReader fReader = null;
        try {
            fReader = new FileReader("warehouse.txt");
        } catch (FileNotFoundException ex) {
            System.out.println(fReader + "was not found.");
        }
        BufferedReader bReader = new BufferedReader(fReader);
        String line;
                while((line = bReader.readLine()) != null){
                    String[] ss = line.split(",");
                    BikePart bp = new BikePart(ss[0], Integer.parseInt(ss[1]), Double.parseDouble(ss[2]), Double.parseDouble(ss[3]), ss[4].equals("true"));
                    Inventory i = new Inventory(bp, Integer.parseInt(ss[5]));
                    main.addArrayList(i);
                }
            Scanner input = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        String choices = "";
        while (!choices.equalsIgnoreCase("quit")) {
            System.out.println("Please select your option");
            System.out.println("Read: Read an inventory delivery file");
            System.out.println("Enter: Enter a part");
            System.out.println("Sell: Sell a part ");
            System.out.println("Display: Display a part");
            System.out.println("Sort Name: sort parts by name");
            System.out.println("Sort Number: Sort parts by part number");
            System.out.println("Create: Create Warehouse");
            System.out.println("Fill: Add inventory to warehouse");
            System.out.println("Move: Move Inventory");
            System.out.println("Find: Find Warehouse");
            System.out.println("Quit");
            System.out.println("Enter your choice");
            choices = choice.nextLine();

            if (choices.equalsIgnoreCase("Read")) {//reads in files
                    String file = input.nextLine();
                    fileReader(file);
            }

            if (choices.equalsIgnoreCase("Enter")) {//allows you to enter a part by all of it parameters
                FileWriter fileWritter = new FileWriter("warehouse.txt", true);
                BufferedWriter b = new BufferedWriter(fileWritter);
                System.out.println("Enter part name");
                String name = choice.next();
                System.out.println("Enter part number");
                int num = choice.nextInt();
                System.out.println("Enter price");
                double price = choice.nextDouble();
                System.out.println("Enter sales price");
                double sales = choice.nextDouble();
                System.out.println("Enter true if on sale false if not");
                String os = choice.next();
                System.out.println("Enter quantity");
                String q = choice.next();
                BikePart bp = new BikePart(name, num, price, sales, os.equals("true"));
                    Inventory i = new Inventory(bp, Integer.parseInt(q));
                main.addArrayList(i);
                b.write(name + "," + num + "," + price + "," + sales + "," + os + "," + q);
                b.newLine();
                b.close();

            }

            if (choices.equalsIgnoreCase("Sell")) {//Sells part by number

                System.out.println("Enter part name:");
                String name = choice.nextLine();
                System.out.println("Enter quantity: ");
                int quantity = choice.nextInt();
                main.sellPart(name, quantity);

            }
            if (choices.equalsIgnoreCase("display")) {//display specific part by name

                System.out.println("Enter part name");
                String nums = choice.nextLine();
                System.out.println(main.findPart(nums));

            }
            if (choices.equalsIgnoreCase("Sort Name")) {//sorts name
                main.sortName();
                System.out.println(" ");
                for(int i = 0; i < main.getArrayList().size(); i++){
                    System.out.println(main.getArrayList().get(i).toString());
                }
                System.out.println("Main WH");
                main.sortName();

            }

            if (choices.equalsIgnoreCase("Quit")) {//quits program
                System.exit(0);
            }
            if (choices.equalsIgnoreCase("Sort Number")) {//sorts number greatest to least
                main.sortNumber();
                System.out.println(" ");
                for(int i = 0; i < main.getArrayList().size(); i++){
                    System.out.println(main.getArrayList().get(i).toString());
                }
                System.out.println("Main WH");
                main.sortNumber();
            }

            if (choices.equalsIgnoreCase("Create")) {// Creates Warehouses
                System.out.println("Enter Warehouse Name");
                String name = choice.nextLine();
                wh = new Warehouse(name, name + ".txt");

            }
            if (choices.equalsIgnoreCase("Fill")) {//Creates inventory for new Warehouse
                System.out.println("Enter Read to read a file or Enter "
                        + "to enter file Manually");

                if (choice.nextLine().equalsIgnoreCase("Read")) {//reads inventory from file and adds to warehouse
                    System.out.println("Enter file name");
                    String name = choice.nextLine();
                    main.read(name);
                } else if (choice.nextLine().equalsIgnoreCase("Enter")) {//Allows you to manually enter a part
                    System.out.println("Enter part name");
                    String name = choice.next();
                    System.out.println("Enter part number");
                    String num = choice.next();
                    System.out.println("Enter price");
                    String price = choice.next();
                    System.out.println("Enter sales price");
                    String sales = choice.next();
                    System.out.println("Enter true if on sale false if not");
                    String os = choice.next();
                    System.out.println("Enter quantity");
                    String q = choice.next();
                }

            }
        }

    }
    public static void fileReader(String file) throws FileNotFoundException, IOException{
           String fName = file;
            String line;
            try{
                //sets up writers and readers
                FileReader inpu = new FileReader(fName);
                BufferedReader bReader = new BufferedReader(inpu);
                while((line = bReader.readLine()) != null){
                        String[] aa = line.split(",");
                        int q = Integer.parseInt(aa[5]);
                        BikePart bp = new BikePart(aa[0],Integer.parseInt(aa[1]),Double.parseDouble(aa[2]) , Double.parseDouble(aa[3]), aa[4].equals("true"));
                        Inventory BI = new Inventory(bp, q);
                        Boolean test2 = false;
                        ArrayList<Inventory> temp = main.getArrayList();                        
                        for(int i = 0; i < temp.size(); i++){
                            Inventory in = temp.get(i);
                            if(BI.getIName().equals(in.getIName())){
                                test2 = true;
                            }    
                        }
                        
                        if(test2 == true){
                            for(int i = 0; i < temp.size() - 1; i++){
                                if(BI.getName().equalsIgnoreCase(temp.get(i).getIName())){
                                    if(BI.getPrice() != temp.get(i).getPrice()){
                                        temp.get(i).upIPrice((int) BI.getPrice());
                                    }
                                    if(BI.getSPrice() != temp.get(i).getSPrice()){
                                        temp.get(i).upSPrice((int) BI.getSPrice());
                                    }
                                    if(BI.getOnSale() != temp.get(i).getOnSale()){
                                        temp.get(i).upOnISale(bp.getOnSale());
                                    }
                                    if(BI.getQuantity() != temp.get(i).getQuantity()){
                                        temp.get(i).setQuantity(q);
                                    }
                                }
                            }
                            main.overwriteArrayList(temp);
                        }
                        else{
                            main.getArrayList().add(BI);
                            
                      }
                    }
        System.out.println(" ");
        //reads and prints the file line by line
        

    }catch(FileNotFoundException e){
        System.out.println(fName + " was not found.");
    }
    
        System.out.println(" ");
      
      System.out.println(" ");
    }
}