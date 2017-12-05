package finalproject;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class testLogin extends JDialog
{
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JTextField tfPosition;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JLabel lbPosition;
    private JButton btnLogin;
    private JButton btnCancel;
    private JButton btnNewUser;
    private boolean succeeded;
 
    public testLogin(Frame parent) 
    {
        super(parent, "Login", true);
        
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Username: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Password: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));
        
        lbPosition = new JLabel("Position #: ");
        cs.gridx = 0;
        cs.gridy = 2;
        cs.gridwidth = 1;
        panel.add(lbPosition, cs);
        
        tfPosition = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 2;
        cs.gridwidth = 2;
        panel.add(tfPosition,cs);
 
        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                if (LoginCheck(getUsername(), getPassword())) 
                {
                    JOptionPane.showMessageDialog(testLogin.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                } 
                else 
                {
                    JOptionPane.showMessageDialog(testLogin.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username and password
                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;
                }
            }
        });
        
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
            {
                dispose();
            }
        });
        
        btnNewUser = new JButton("Add User");
        btnNewUser.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                //Add Pop-up for username here
                JTextField FirstName = new JTextField();
                JTextField LastName = new JTextField();
                JTextField UserName = new JTextField();
                JTextField Password = new JTextField();
                JTextField ConfirmPass = new JTextField();
                JTextField Email = new JTextField();
                JTextField ConfirmMail = new JTextField();
                JTextField Position = new JTextField();
                
                
                Object[] message = 
                {
                    "Enter First Name:", FirstName,
                    "Enter Last Name:", LastName,
                    "Enter User name:", UserName,
                    "Enter Password:", Password,
                    "Confirm Password:", ConfirmPass,
                    "Enter Email:", Email,
                    "Confirm Email:", ConfirmMail,
                    "Enter Company Rank:", Position,
                };
                
                int option = JOptionPane.showConfirmDialog(null, message, "Enter", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) 
                {
                    if (Password.getText().trim().equals(ConfirmPass.getText().trim()))
                    {
                        //To add here: Email check for duplicates.  If passed, go to next part
                        JOptionPane.showMessageDialog(testLogin.this,
                            "Welcome to the System, " + FirstName.getText().trim() + "!",
                            "New User",
                            JOptionPane.INFORMATION_MESSAGE);
                            //Add attributes from textfield to the user Object arraylist
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(testLogin.this,
                            "Passwords do not Match!",
                            "New User",
                            JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
                else
                {
                    
                      
                }
                dispose();
            }
        });
        
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
        bp.add(btnNewUser);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
 
    public String getUsername() 
    {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() 
    {
        return new String(pfPassword.getPassword());
    }
    
    public int getPosition(){
        return Integer.parseInt(tfPosition.getText().trim());
    }
    public static boolean LoginCheck(String username, String password) 
    {
        //String UsernameIndex = Search through ArrayList for the UserName
        //String PasswordIndex = take the index of the Username entered and call the password to check the one entered.
        //Delete Erics password for later.
        if (username.equals("Eric") && password.equals("theR4tM4N")) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
 
    public boolean isSucceeded() 
    {
        return succeeded;
    }
}
