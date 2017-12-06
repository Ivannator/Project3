package finalproject;


/**
 * Write a description of class DisplayInvetoryCopyPaste here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DisplayInvetoryCopyPaste
{
    public int sampleMethod(int y)
    {
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
                                            
                        Warehouse TempWH = null;
                        for (int i=0; i < WarehouseList.size(); i++)
                        {
                            if (WarehouseInput.equals(WarehouseList.get(i).getWName()))
                            {
                                TempWH = WarehouseList.get(i);
                            }
                        }
                                            
                        StringBuffer str=new StringBuffer();
                        ArrayList<Inventory> parts = TempWH.getArrayList();
                                            
                        for(int y = 0; y < parts.size(); y++)
                        {    
                            for(int z = 0; z < 5; z++)
                            {
                                Inventory currentValue = parts.get(z);
                                str.append(currentValue).append(" ");
                            }
                            Inventory amount = parts.get(5);
                            str.append(amount).append(" ");
                            str.append("\n");
                        }

                        JOptionPane.showMessageDialog(null,"Name  |  Serial  |  Sales Price | List Price | on sale? | Quantity:"+"\n" + str);
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
    }
}
