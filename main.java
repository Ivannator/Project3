
import java.io.BufferedWriter;
import java.io.File;
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
public class main {

    public static void main(String[] args) throws IOException {

        WarehouseManager wm = new WarehouseManager();
        WareHouse overall = new WareHouse("overall");
        WareHouse main = new WareHouse("main");
        wm.addWarehouse(main);
        wm.addWarehouse(overall);
        WareHouse wh = null;
        wm.addWarehouse(wh);
        try {
            Scanner input = new Scanner(System.in);

            File file = new File("warehouseDB.txt");

            input = new Scanner(file);
            ArrayList<String> bp = new ArrayList<String>();
            while (input.hasNextLine()) {
                String line = input.nextLine();
                bp.add(line);

            }
            input.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
                try {
                    System.out.print("Enter the file name with extension : ");
                    FileWriter fileWritter = new FileWriter("warehouseDB.txt", true);
                    BufferedWriter b = new BufferedWriter(fileWritter);
                    Scanner input = new Scanner(System.in);

                    File file = new File(input.nextLine());

                    input = new Scanner(file);

                    while (input.hasNextLine()) {
                        String line = input.nextLine();
                        String[] split = line.split(",");
                        BikePart bp = new BikePart(split[0], Integer.parseInt(split[1]),
                                Double.parseDouble(split[2]), Double.parseDouble(split[3]), Boolean.parseBoolean(split[4]), Integer.parseInt(split[5]));
                        overall.addPart(bp);
                        b.write(line);
                        b.newLine();
                        System.out.println(line);
                    }
                    main.read("initialInventory.txt");
                    input.close();

                    b.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

            if (choices.equalsIgnoreCase("Enter")) {//allows you to enter a part by all of it parameters
                FileWriter fileWritter = new FileWriter("warehouseDB.txt", true);
                BufferedWriter b = new BufferedWriter(fileWritter);
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
                BikePart ne = new BikePart(name, Integer.parseInt(num), Double.parseDouble(price),
                        Double.parseDouble(sales), Boolean.parseBoolean(os), Integer.parseInt(q));
                overall.addPart(ne);
                b.write(name + "," + num + "," + price + "," + sales + "," + os + "," + q);
                b.newLine();
                b.close();

            }

            if (choices.equalsIgnoreCase("Sell")) {//Sells part by number

                System.out.println("Enter part number");
                int nums = choice.nextInt();
                overall.sellPart(nums);

            }
            if (choices.equalsIgnoreCase("display")) {//display specific part by name

                System.out.println("Enter part name");
                String nums = choice.nextLine();
                overall.findPart(nums);

            }
            if (choices.equalsIgnoreCase("Sort Name")) {//sorts name
                overall.sortName();
                System.out.println(" ");
                System.out.println("Main WH");
                main.sortName();

            }

            if (choices.equalsIgnoreCase("Quit")) {//quits program
                System.exit(0);
            }
            if (choices.equalsIgnoreCase("Sort Number")) {//sorts number greatest to least
                overall.sortNumber();
                System.out.println(" ");
                System.out.println("Main WH");
                main.sortNumber();
            }

            if (choices.equalsIgnoreCase("Create")) {// Creates Warehouses
                System.out.println("Enter Warehouse Name");
                String name = choice.nextLine();
                wh = new WareHouse(name);

            }
            if (choices.equalsIgnoreCase("Fill")) {//Creates inventory for new Warehouse
                System.out.println("Enter Read to read a file or Enter "
                        + "to enter file Manually");

                if (choice.nextLine().equalsIgnoreCase("Read")) {//reads inventory from file and adds to warehouse
                    System.out.println("Enter file name");
                    String name = choice.nextLine();
                    wh.read(name);
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
                    BikePart ne = new BikePart(name, Integer.parseInt(num), Double.parseDouble(price),
                            Double.parseDouble(sales), Boolean.parseBoolean(os), Integer.parseInt(q));
                    wh.addPart(ne);
                }

            }
            if (choices.equalsIgnoreCase("Find")) {//find warehouse
                System.out.println("Enter warehouse name");
                String nums = choice.nextLine();
                wm.findWarehouse(nums);
            }
        }

    }
}
