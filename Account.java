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
    private final String position;
    public Account(String fName, String lName, String uName, String password, String email, String pos){
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
    public String getPosition(){
        return position;
    }
}
