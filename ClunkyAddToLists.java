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
 * Write a description of class ClunkyAddToLists here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClunkyAddToLists
{
    private static ArrayList<Account> profiles = new ArrayList<>();
    public static ArrayList<WhManager> wHManagers = new ArrayList<>();
    public static ArrayList<OfficeManager> officeManagers = new ArrayList<>();
    public static ArrayList<SalesAssociate> salesAssociates = new ArrayList<>();
    public static ArrayList<SysAdmin> sysAdmins = new ArrayList<>();
    private static final ArrayList<String> fileNames = new ArrayList<>();
    private static int permissions;
    public static ArrayList<Transaction> t = new ArrayList<>();
    
    public void addWhMan(String fn, String ln, String em, String un, String ps, int pos, String fi)
    {
        WhManager newWHMan = new WhManager(fn, ln, em, un, ps, pos, fi);
        
        boolean exists = false;
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(wHManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < salesAssociates.size(); i++)
        {
            if (un.equals(salesAssociates.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(officeManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(sysAdmins.get(i).getUsername()))
            {
                exists = true;
            }
        }
        
        if (!exists)
        {
            wHManagers.add(newWHMan);
        }
    }
    
    public void addOfficeMan(String fn, String ln, String em, String un, String ps, int pos, String fi)
    {
        OfficeManager newOffMan = new OfficeManager(fn, ln, em, un, ps, pos, fi);
        
        boolean exists = false;
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(wHManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < salesAssociates.size(); i++)
        {
            if (un.equals(salesAssociates.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(officeManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(sysAdmins.get(i).getUsername()))
            {
                exists = true;
            }
        }
        if (!exists)
        {
            officeManagers.add(newOffMan);
        }
    }
    
    public void addSalesAss(String fn, String ln, String em, String un, String ps, int pos, String fi)
    {
        SalesAssociate newSalesAss = new SalesAssociate(fn, ln, em, un, ps, pos, fi);
        
        boolean exists = false;
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(wHManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < salesAssociates.size(); i++)
        {
            if (un.equals(salesAssociates.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(officeManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(sysAdmins.get(i).getUsername()))
            {
                exists = true;
            }
        }
        if (!exists)
        {
            salesAssociates.add(newSalesAss);
        }
    }
    
    public void addSysAdmin(String fn, String ln, String em, String un, String ps, int pos, String fi)
    {
        SysAdmin newSysAdd = new SysAdmin(fn, ln, em, un, ps, pos, fi);
        
        boolean exists = false;
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(wHManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < salesAssociates.size(); i++)
        {
            if (un.equals(salesAssociates.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(officeManagers.get(i).getUsername()))
            {
                exists = true;
            }
        }
        for (int i=0; i < wHManagers.size(); i++)
        {
            if (un.equals(sysAdmins.get(i).getUsername()))
            {
                exists = true;
            }
        }
        
        if (!exists)
        {
            sysAdmins.add(newSysAdd);
        }
    }
}
