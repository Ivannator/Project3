/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Denzel Saraka
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class Account.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        Account instance = new Account("Steve", "Robins","SRobins","pass","srobins@gmail.com",1);
        String expResult = "SRobins";
        String result = instance.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Account instance = new Account("Steve", "Robins","SRobins","pass","srobins@gmail.com",1);;
        String expResult = "pass";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Account.
     */
    @Test
    public void testGetPosition() {
        System.out.println("getPosition");
        Account instance = new Account("Steve", "Robins","SRobins","pass","srobins@gmail.com",1);;
        int expResult = 1;
        int result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosition method, of class Account.
     */
    @Test
    public void testSetPosition() {
        System.out.println("setPosition");
        int newPos = 3;
        Account instance = new Account("Steve", "Robins","SRobins","pass","srobins@gmail.com",1);;
        instance.setPosition(newPos);
        assertEquals(3, instance.getPosition());
        
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
