
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

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
            System.out.println("Quit");
            System.out.println("Enter your choice");
            choices = choice.nextLine();

            if (choices.equalsIgnoreCase("Read")) {
                try {
                    System.out.print("Enter the file name with extension : ");
                    FileWriter fileWritter = new FileWriter("warehouseDB.txt", true);
                    BufferedWriter b = new BufferedWriter(fileWritter);
                    Scanner input = new Scanner(System.in);

                    File file = new File(input.nextLine());

                    input = new Scanner(file);

                    while (input.hasNextLine()) {
                        String line = input.nextLine();
                        b.write(line);
                        b.newLine();
                        System.out.println(line);
                    }
                    input.close();

                    b.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

            if (choices.equalsIgnoreCase("Enter")) {
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
                
                b.write(name + "," + num + "," + price + "," + sales + "," + os + "," + q);
                b.newLine();
                b.close();

            }

            if (choices.equalsIgnoreCase("Sell")) {

                try {
                    Scanner input = new Scanner(System.in);
                    String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
                    File file = new File("warehouseDB.txt");
                    System.out.println("Enter part number");
                    String nums = choice.nextLine();
                    input = new Scanner(file);

                    List<String> list = new ArrayList<>();
                    while (input.hasNextLine()) {
                        String line = input.nextLine();
                        String[] split = line.split(",");
                        list.add(line);
                        if (line.contains(nums)) {
                            // a match!
                            System.out.println(line);
                            System.out.println(timeStamp);

                            break;
                        } else {
                            System.out.println("Error not found");
                        }
                        //System.out.println(line);

                    }

                    input.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
            if (choices.equalsIgnoreCase("display")) {

                try {
                    Scanner input = new Scanner(System.in);

                    File file = new File("warehouseDB.txt");
                    System.out.println("Enter part name");
                    String nums = choice.nextLine();
                    input = new Scanner(file);

                    List<String> list = new ArrayList<>();
                    while (input.hasNextLine()) {
                        String line = input.nextLine();
                        String[] split = line.split(",");
                        list.add(line);
                        if (line.contains(nums)) {
                            // a match!
                            System.out.println(line);
                            break;
                        } else {
                            System.out.println("Error not found");
                        }
                        //System.out.println(line);

                    }

                    input.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (choices.equalsIgnoreCase("Sort Name")) {
                try {
                    Scanner input = new Scanner(System.in);

                    File file = new File("warehouseDB.txt");
                    input = new Scanner(file);

                    List<String> list = new ArrayList<>();
                    while (input.hasNextLine()) {
                        String line = input.nextLine();
                        list.add(line);

                    }
                    Collections.sort(list);
                    for (String counter : list) {
                        System.out.println(counter);
                    }

                    input.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (choices.equalsIgnoreCase("Quit")) {
                System.exit(0);
            }
        }

    }

}
