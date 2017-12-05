/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package project3;

/**
 *
 *@author Chris
 */
public class Account {
    private final String firstName;
    private final String lastName;
    private final String username;
    private final String pass;
    private final String e;
    //private final int position;
    private int position;
    public Account(String fName, String lName, String email, String uName, String password, int pos){
        firstName = fName;
        lastName = lName;
        username = uName;
        pass = password;
        e = email;
        position = pos;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return pass;
    }
    public int getPosition(){
        return position;
    }
    public void setPosition(int newPos){
        position=newPos;
    }        
    
}
