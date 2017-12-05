package finalproject;

import javax.swing.*;
import javafx.scene.*;
import javafx.scene.control.*;
import java.awt.*;
import java.awt.event.*;

class Menu
{
    private static int permissions;
    
    public static void main(String args[])
    {
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
                        if (input.equals(sorter[0]))
                        {
                            String WarehouseInput = Warehouse.getText().trim();
                        
                            //Code here (Alphabet Sort)
                        
                            JOptionPane.showMessageDialog(frame,
                            "Warehouse has been sorted Alphabetically",
                            "Sort Complete",JOptionPane.PLAIN_MESSAGE);
                        }
                        else if (input.equals(sorter[1]))
                        {
                            String WarehouseInput = Warehouse.getText().trim();
                        
                            //Code here (Number Sort)
                        
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
                    JTextField ItemSerial = new JTextField();
                    JTextField ListPrice = new JTextField();
                    JTextField SalePrice = new JTextField();
                    JTextField OnSale = new JTextField();
                    JTextField Quantity = new JTextField();
                    JTextField Warehouse = new JTextField();

                    Object[] message = 
                    {
                        "Enter Item Name: ", ItemName,
                        "Enter Serial Number: ", ItemSerial,
                        "Enter List Price: ", ListPrice,
                        "Enter Sales Price: ", SalePrice,
                        "Is the item on Sale?: ", OnSale,
                        "How many are being Sold: ", Quantity,
                        "Enter Warehouse selling: ", Warehouse,
                    };
                    
                    String ItemInput = ItemName.getText().trim();
                    String SerialInput = ItemSerial.getText().trim();
                    double ListPriceInput = Double.parseDouble(ListPrice.getText().trim());
                    double SalePriceInput = Double.parseDouble(SalePrice.getText().trim());
                    boolean SaleCheckerInput = Boolean.parseBoolean(OnSale.getText().trim());
                    int QuantityInput = Integer.parseInt(Quantity.getText().trim());
                    String WarehouseInput = Warehouse.getText().trim();
                    
                    int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) 
                    {
                        if (1 == 1)
                        {
                            //Code for increasing item quantity in warehouse
                        }
                        else
                        {
                            //Code for adding item to array List
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
                    JTextField Quantity = new JTextField();
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
                        
                        //Create Warehouse code here
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
        m5.add(m51);
        
        JMenuItem m52 = new JMenuItem("Delete User");
        m52.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent ev) 
            {
                if (permissions == 0)
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
        m5.add(m52);
        
        /**
         * Menu 6: Help
         */
        JMenuItem m61 = new JMenuItem("Help");
        //Sell Item Code Here
        m1.add(m61);
        
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