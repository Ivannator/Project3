package finalproject;

import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javafx.collections.*;
import javafx.scene.*;
import javafx.scene.control.*;

/**
 * Write a description of class AsAnExample here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu2
{
    private static ArrayList<Account> profiles = new ArrayList<>();
    public static ArrayList<WhManager> wHManagers = new ArrayList<>();
    public static ArrayList<OfficeManager> officeManagers = new ArrayList<>();
    public static ArrayList<SalesAssociate> salesAssociates = new ArrayList<>();
    public static ArrayList<SysAdmin> sysAdmins = new ArrayList<>();
    private static final ArrayList<String> fileNames = new ArrayList<>();
    private static int permissions;
    public static ArrayList<Transaction> t = new ArrayList<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        FileReader fReader = null;
        fReader = new FileReader("profiles.txt");
        BufferedReader bReader = new BufferedReader(fReader);
        String line;
            if((line = bReader.readLine()) != null){
                while((line = bReader.readLine()) != null){
                    fileNames.add(line);
                }
            }
        if(fileNames != null){
            for(int i = 0; i < fileNames.size(); i++){
                String name = fileNames.get(i);
                fReader = new FileReader(name);
                bReader = new BufferedReader(fReader);
                  while((line = bReader.readLine()) != null){
                    String[] ss = line.split(",");
                    String user = ss[3];
                    Account acc = new Account(ss[0], ss[1], ss[2], ss[3], ss[4], Integer.parseInt(ss[5]));
                    profiles.add(acc);
                    int p = Integer.parseInt(ss[5]);
                    switch (p) {
                        case 0:
                            SysAdmin sysa = new SysAdmin(ss[0], ss[1], ss[2], ss[3], ss[4], Integer.parseInt(ss[5]), ss[6]);
                            sysAdmins.add(sysa);
                            System.out.println("SYSA");
                            break;
                        case 1:
                            SalesAssociate sa = new SalesAssociate(ss[0], ss[1], ss[2], ss[3], ss[4], Integer.parseInt(ss[5]), ss[6]);
                            salesAssociates.add(sa);
                            System.out.println("SA");
                            break;
                        case 3:
                            OfficeManager om = new OfficeManager(ss[0], ss[1], ss[2], ss[3], ss[4], Integer.parseInt(ss[5]), ss[6]);
                            officeManagers.add(om);
                            System.out.println("OM");
                            break;
                        case 2:
                            WhManager wm = new WhManager(ss[0], ss[1], ss[2], ss[3], ss[4], Integer.parseInt(ss[5]), ss[6]);
                            wHManagers.add(wm);
                            System.out.println("WM");
                            break;
                        default:
                            break;
                    }
                }
                for(int a = 0; a < wHManagers.size(); a++){
                    WhManager whm = wHManagers.get(a);
                   for(int b = 0; b < officeManagers.size(); b++){
                       OfficeManager ofM = officeManagers.get(b);
                       ofM.addWhManager(whm);
                   }
                  }
                    }
                    
                } 
        fReader = new FileReader("warehouse.txt");
        bReader = new BufferedReader(fReader);
        line = "";
        if(bReader.readLine() != null){
                while((line = bReader.readLine()) != null){
                    String[] ss = line.split(",");
                    BikePart bp = new BikePart(ss[0], Integer.parseInt(ss[1]), Double.parseDouble(ss[2]), Double.parseDouble(ss[3]), ss[4].equals("true"));
                    Inventory in = new Inventory(bp, Integer.parseInt(ss[5]));
                    WhManager whman = null;
                    whman = wHManagers.get(0);
                    whman.addPart(in);
                }
            }
          
        final JFrame frame = new JFrame("JDialog Demo");
        final JButton btnLogin = new JButton("Click to login");
        ArrayList<Account> AccountList = new ArrayList<>();
        ArrayList<Warehouse> WarehouseList = new ArrayList<>();
        
        btnLogin.addActionListener(
                new ActionListener()
                {
                    public void actionPerformed(ActionEvent e) 
                    {
                        testLogin loginDlg = new testLogin(frame);
                        loginDlg.setVisible(true);
                        // if logon successfully
                        if(loginDlg.isSucceeded())
                        {
                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                            //Create the Frame
                            JFrame frame = new JFrame("Bike Shop Manager");
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.setSize(400,400);
        
                            //Create the MenuBar and define the characteristics here
                            JMenuBar mb = new JMenuBar();
                            JMenu m1 = new JMenu("File");
                            JMenu m2 = new JMenu("Sales");
                            JMenu m3 = new JMenu("Inventory");
                            JMenu m4 = new JMenu("Office");
                            JMenu m5 = new JMenu("Admin");
                            JMenu m6 = new JMenu("Help");
                            mb.add(m1);
                            mb.add(m2);
                            mb.add(m3);
                            mb.add(m4);
                            mb.add(m5);
                            mb.add(m6);
                            
        
                            //Add Options to each of the menu lists.
                            /**
                             * Menu 1: File
                             */
                            JMenuItem m11 = new JMenuItem("Open");
                            //Import Code Here
                            m1.add(m11);
        
                            JMenuItem m12 = new JMenuItem("Save as");
                            //Save Data Here
                            m1.add(m12);
        
                            JMenuItem m13 = new JMenuItem("Exit");
                            m13.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    System.exit(0);
                                }
                            });
                            m1.add(m13);
        
                            /**
                             * Menu 2: Sales
                             */
                            JMenuItem m21 = new JMenuItem("Sell Item");
                            m21.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 1 || permissions == 0)
                                    {
                                        JTextField ItemName = new JTextField();
                                        JTextField Quantity = new JTextField("0");
                                        JTextField Warehouse = new JTextField();

                                        Object[] message = 
                                        {
                                            "Enter Item Name: ", ItemName,
                                            "How many are being Sold: ", Quantity,
                                            "Enter Warehouse selling: ", Warehouse,
                                        };
                    
                                        String ItemInput = ItemName.getText().trim();
                                        String QuantityInput = Quantity.getText().trim();
                                        int UsedIQuantity = Integer.parseInt(QuantityInput);
                                        String WarehouseInput = Warehouse.getText().trim();
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {
                                            if (1 == 1) //Check if item exists in inventory to begin with
                                            {
                                                Warehouse TempWH = null;
                                            for (int i=0; i < WarehouseList.size(); i++)
                                            {
                                                if (WarehouseInput.equals(WarehouseList.get(i).getWName()))
                                                {
                                                    TempWH = WarehouseList.get(i);
                                                }
                                                TempWH.sellPart(ItemInput, UsedIQuantity);
                                            }
                                        }
                                        else //If item does not exist
                                        {
                                            JOptionPane.showMessageDialog(frame,
                                            "You do not have this item to sell!",
                                            "Continue",
                                            JOptionPane.ERROR_MESSAGE);
                                            }
                                        
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                                }
                            });
                            m2.add(m21);
        
                            /**
                             * Menu 3: Inventory
                             */        
                            JMenuItem m31 = new JMenuItem("Sort Item");
                            m31.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 2 || permissions == 0)
                                    {
                                        String[] sorter = {"Alphabetically", "Numerically"};
                    
                                        String input = (String) JOptionPane.showInputDialog(null, "How will this sort?", "Inventory Sort", JOptionPane.QUESTION_MESSAGE, null, sorter, sorter[0]);
                    
                                        JTextField Warehouse = new JTextField();
                                        Object[] message = 
                                        {
                                            "Enter Warehouse Name: ", Warehouse,
                                        };
                        
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {    
                                            String WarehouseInput = Warehouse.getText().trim();
                                            Warehouse TempWH = null;
                                            for (int i=0; i < WarehouseList.size(); i++)
                                            {
                                                if (WarehouseInput.equals(WarehouseList.get(i).getWName()))
                                                {
                                                    TempWH = WarehouseList.get(i);
                                                }
                                            }
                                            if (input.equals(sorter[0]))
                                            {
                                                TempWH.getWName();
                        
                                                JOptionPane.showMessageDialog(frame,
                                                "Warehouse has been sorted Alphabetically",
                                                "Sort Complete",JOptionPane.PLAIN_MESSAGE);
                                            }
                                            else if (input.equals(sorter[1]))
                                            {
                                                TempWH.sortNumber();
                        
                                                JOptionPane.showMessageDialog(frame,
                                                "Warehouse has been sorted Numerically",
                                                "Sort Complete",JOptionPane.PLAIN_MESSAGE);
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(frame,
                                                "How the heck did you end up here?",
                                                "What are you doing!?",
                                                JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m3.add(m31);
        
                            JMenuItem m32 = new JMenuItem("Add Item");
                            m32.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 2 || permissions == 0)
                                    {
                                        JTextField ItemName = new JTextField();
                                        JTextField ItemSerial = new JTextField("0");
                                        JTextField ListPriceIn = new JTextField("0");
                                        JTextField SalePriceIn = new JTextField("0");
                                        JTextField OnSale = new JTextField("false");
                                        JTextField Quantity = new JTextField("0");
                                        JTextField Warehouse = new JTextField();

                                        Object[] message = 
                                        {
                                            "Enter Item Name: ", ItemName,
                                            "Enter Serial Number: ", ItemSerial,
                                            "Enter List Price: ", ListPriceIn,
                                            "Enter Sales Price: ", SalePriceIn,
                                            "Is the item on Sale?: ", OnSale,
                                            "How many are being Sold: ", Quantity,
                                            "Enter Warehouse selling: ", Warehouse,
                                        };
                    
                                        String ItemInput = ItemName.getText().trim();
                                        int SerialInput = Integer.parseInt(ItemSerial.getText().trim());
                                        double ListPriceInput = Double.parseDouble(ListPriceIn.getText().trim());
                                        double SalePriceInput = Double.parseDouble(SalePriceIn.getText().trim());
                                        boolean SaleCheckerInput = Boolean.parseBoolean(OnSale.getText().toString());
                                        int QuantityInput = Integer.parseInt(Quantity.getText().trim());
                                        String WarehouseInput = Warehouse.getText().trim();
                    
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {
                                            Warehouse TempWH = null;
                                            for (int i=0; i < WarehouseList.size(); i++)
                                            {
                                                if (WarehouseInput.equals(WarehouseList.get(i).getWName()))
                                                {
                                                    TempWH = WarehouseList.get(i);
                                                }
                                            }
                                            if (1 == 1)
                                            {
                                                BikePart toAdd = new BikePart(ItemInput, SerialInput, ListPriceInput, SalePriceInput, SaleCheckerInput);
                                                Inventory toWarehouse = new Inventory(toAdd, QuantityInput);
                                                
                                            }
                                            
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m3.add(m32);
        
                            JMenuItem m33 = new JMenuItem("Ship Item");
                            m33.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 2 || permissions == 0)
                                    {
                                        JTextField ItemName = new JTextField();
                                        JTextField Quantity = new JTextField("0");
                                        JTextField Warehouse1 = new JTextField();
                                        JTextField Warehouse2 = new JTextField();

                                        Object[] message = 
                                        {
                                            "Enter Item Name: ", ItemName,
                                            "How many are being shipped: ", Quantity,
                                            "Enter Warehouse shipping: ", Warehouse1,
                                            "Enter Warehouse recieving: ", Warehouse2,
                                        };
                
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {
                                            if (1 == 1)
                                            {
                                                String ItemInput = ItemName.getText().trim();
                                                int QuantityInput = Integer.parseInt(Quantity.getText().trim());
                                                String FromWarehouse = Warehouse1.getText().trim();
                                                String ToWarehouse = Warehouse2.getText().trim();
                                                //Code for shipping between Warehouses
                                                Warehouse TempWH1 = null;
                                                for (int i=0; i < WarehouseList.size(); i++)
                                                {
                                                    if (ToWarehouse.equals(WarehouseList.get(i).getWName()))
                                                    {
                                                        TempWH1 = WarehouseList.get(i);
                                                    }
                                                }
                                            }
                                            else
                                            {
                                                JOptionPane.showMessageDialog(frame,
                                                "This item does not exist in the Warehouse, and cannot be shipped.",
                                                "Continue",
                                                JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m3.add(m33);
        
                            JMenuItem m34 = new JMenuItem("Sort Item");
                            m34.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 2 || permissions == 0)
                                    {
                                        //Sell Item Code Here
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m3.add(m34);
        
                            JMenuItem m35 = new JMenuItem("Display Inventory");
                            m35.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 2 || permissions == 0)
                                    {
                                        JTextField Warehouse = new JTextField();
                                        Object[] message = 
                                        {
                                            "Enter Warehouse Name: ", Warehouse,
                                        };
                        
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {
                                            String WarehouseInput = Warehouse.getText().trim();
                        
                                            //Input to display Warehouse inventory
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m3.add(m35);
        
                            /**
                             * Menu 4: Office
                             */
                            JMenuItem m41 = new JMenuItem("View Transactions");
                            m41.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 3 || permissions == 0)
                                    {
                                        //Transactions code here
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m4.add(m41);
        
                            JMenuItem m42 = new JMenuItem("Add Warehouse");
                            m42.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 3 || permissions == 0)
                                    {
                                        JTextField Warehouse = new JTextField();
                                        Object[] message = 
                                        {
                                            "Enter Warehouse Name: ", Warehouse,
                                        };
                        
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {
                                            String WarehouseInput = Warehouse.getText().trim();
                                            String WarehouseFile = WarehouseInput + ".txt";
                                            Warehouse NewWarehouse = new Warehouse(WarehouseInput, WarehouseFile);
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m4.add(m42);
        
                            /**
                             * Menu 5: Admin
                             */
                            JMenuItem m51 = new JMenuItem("Modify User");
                            m51.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 0)
                                    {
                                        JTextField UserToDelete = new JTextField();
                                        Object[] message = 
                                        {
                                            "Enter Username: ", UserToDelete,
                                        };
                        
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {
                                            String UserNameInput = UserToDelete.getText().trim();

                                            JTextField UserAccount = new JTextField(); //call Username
                                            JTextField FirstName = new JTextField(); //call First name
                                            JTextField LastName = new JTextField(); //call Last name
                                            JTextField Password = new JTextField(); //call Password
                                            JTextField Position = new JTextField("0"); //call Position
                                            JTextField Email = new JTextField(); //call E-mail
                        
                                            Object[] newPopup = 
                                            {
                                                "Change Username: ", UserAccount,
                                                "Change First Name: ", FirstName,
                                                "Change Last Name: ", LastName,
                                                "Change Password: ", Password,
                                                "Change Position: ", Position,
                                                "Change E-Mail:: ", Email,
                                            };
                        
                                            int editUser = JOptionPane.showConfirmDialog(null, newPopup, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                            if (option == JOptionPane.OK_OPTION) 
                                            {   
                                                String UserInput = UserAccount.getText().trim();
                                                String FirstNameInput = FirstName.getText().trim();
                                                String LastNameInput = LastName.getText().trim();
                                                String PasswordInput = Password.getText().trim();
                                                int ChoiceInput = Integer.parseInt(Position.getText().trim());
                                                String EmailInput = Email.getText().trim();
                                            }
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m5.add(m51);
        
                            JMenuItem m52 = new JMenuItem("Delete User");
                            m52.addActionListener(new ActionListener() 
                            {
                                public void actionPerformed(ActionEvent ev) 
                                {
                                    if (permissions == 0)
                                    {
                                        JTextField UserToDelete = new JTextField();
                                        Object[] message = 
                                        {
                                            "Enter Username: ", UserToDelete,
                                        };
                        
                                        int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                                        if (option == JOptionPane.OK_OPTION) 
                                        {
                                            String UserNameInput = UserToDelete.getText().trim();
                        
                                            //Code to Delete User here (Using UserNameInput)
                                        }
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(frame,
                                        "You do not have permission to use this feature.",
                                        "Continue",
                                        JOptionPane.ERROR_MESSAGE);
                                    }
                                }
                            });
                            m5.add(m52);
        
                            /**
                             * Menu 6: Help
                             */
                            JMenuItem m61 = new JMenuItem("Help");
                            //MISC helpo box Here
                            m6.add(m61);
        
                            /**
                             * Create the panel at bottom and add components here.
                             */
                            JPanel panel = new JPanel();
                            JLabel label = new JLabel("Add Note");
                            JTextField tf = new JTextField(10);
                            JButton send = new JButton("Send");
                            JButton reset = new JButton("Reset");
                            panel.add(label);
                            panel.add(tf);
                            panel.add(send);
                            panel.add(reset);
                            JTextArea ta = new JTextArea();
        
                            //Construct the Interface
                            frame.getContentPane().add(BorderLayout.SOUTH,panel);
                            frame.getContentPane().add(BorderLayout.NORTH,mb);
                            frame.getContentPane().add(BorderLayout.CENTER,ta);
                            frame.setVisible(true);
                        }
                    }
                });
 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 100);
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(btnLogin);
        frame.setVisible(true);
    }
}
