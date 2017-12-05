package finalproject;

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
public class SysAdminTest {
    
    public SysAdminTest() {
        
        
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
     * Test of add method, of class SysAdmin.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Account b = new Account("Bill", "Russel","brussel@gmail.com","Brussel","pass",3);
        SysAdmin instance = new SysAdmin("Steve","Rogers","Srogers@gmail.com","Srogers","pass",0);
        instance.add(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SysAdmin.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String b = "Brussel";
        SysAdmin instance = new SysAdmin("Steve","Rogers","Srogers@gmail.com","Srogers","pass",0);
        Account s = new Account("Bill", "Russel","brussel@gmail.com","Brussel","pass",3);
        instance.delete(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class SysAdmin.
     */
    @Test
    public void testEdit() {
        System.out.println("edit");
        String name = "Brussel";
        int newPos = 2;
        Account b = new Account("Bill", "Russel","brussel@gmail.com","Brussel","pass",3);
        SysAdmin instance = new SysAdmin("Steve","Rogers","Srogers@gmail.com","Srogers","pass",0);
        instance.edit(name, newPos);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(2,b.getPosition());
        fail("The test case is a prototype.");
    }
    
}
