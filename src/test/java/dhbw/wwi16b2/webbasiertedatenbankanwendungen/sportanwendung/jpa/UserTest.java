/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Axel
 */
public class UserTest {
    
    String expUsername = "test1234";    
    String expPassword = "test1234";
    String expEmail = "test@test.de"; 
    String expFirstname = "ftest";
    String expLastname = "ltest"; 
    String expGender = "männlich";
    Date expDate = new Date();
    int expWeight = 50;
    int expHeight = 123;
    
    User expUser = new User(expUsername, expPassword, expEmail, expFirstname, expLastname, expGender, expDate, expWeight, expHeight);
    
    public UserTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUsername method, of class User.
     */
    @Test
    public void testGetUsername() {
        System.out.println("getUsername");
        String result = expUser.getUsername();
        assertEquals(expUsername, result);
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setUsername");
        String altUsername = "test12345";
        expUser.setUsername(altUsername);
        String result = expUser.getUsername();
        assertEquals(altUsername, result);
    }

    /**
     * Test of getPasswordHash method, of class User.
     */
    @Test
    public void testGetPasswordHash() {
        System.out.println("getPasswordHash");
        User instance = new User();
        String expResult = "";
        String result = instance.getPasswordHash();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPasswordHash method, of class User.
     */
    @Test
    public void testSetPasswordHash() {
        System.out.println("setPasswordHash");
        String passwordHash = "";
        User instance = new User();
        instance.setPasswordHash(passwordHash);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class User.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        User instance = new User();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        User instance = new User();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstname method, of class User.
     */
    @Test
    public void testGetFirstname() {
        System.out.println("getFirstname");
        User instance = new User();
        String expResult = "";
        String result = instance.getFirstname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstname method, of class User.
     */
    @Test
    public void testSetFirstname() {
        System.out.println("setFirstname");
        String firstname = "";
        User instance = new User();
        instance.setFirstname(firstname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastname method, of class User.
     */
    @Test
    public void testGetLastname() {
        System.out.println("getLastname");
        User instance = new User();
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastname method, of class User.
     */
    @Test
    public void testSetLastname() {
        System.out.println("setLastname");
        String lastname = "";
        User instance = new User();
        instance.setLastname(lastname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class User.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        User instance = new User();
        String expResult = "";
        String result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGender method, of class User.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        String gender = "";
        User instance = new User();
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBirthdate method, of class User.
     */
    @Test
    public void testGetBirthdate() {
        System.out.println("getBirthdate");
        User instance = new User();
        Date expResult = null;
        Date result = instance.getBirthdate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBirthdate method, of class User.
     */
    @Test
    public void testSetBirthdate() {
        System.out.println("setBirthdate");
        Date birthdate = null;
        User instance = new User();
        instance.setBirthdate(birthdate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWeight method, of class User.
     */
    @Test
    public void testGetWeight() {
        System.out.println("getWeight");
        User instance = new User();
        int expResult = 0;
        int result = instance.getWeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setWeight method, of class User.
     */
    @Test
    public void testSetWeight() {
        System.out.println("setWeight");
        int weight = 0;
        User instance = new User();
        instance.setWeight(weight);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class User.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        User instance = new User();
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHeight method, of class User.
     */
    @Test
    public void testSetHeight() {
        System.out.println("setHeight");
        int height = 0;
        User instance = new User();
        instance.setHeight(height);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        User instance = new User();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class User.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        User instance = new User();
        User.Password expResult = null;
        User.Password result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPassword method, of class User.
     */
    @Test
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "";
        User instance = new User();
        boolean expResult = false;
        boolean result = instance.checkPassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroups method, of class User.
     */
    @Test
    public void testGetGroups() {
        System.out.println("getGroups");
        User instance = new User();
        List<String> expResult = null;
        List<String> result = instance.getGroups();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToGroup method, of class User.
     */
    @Test
    public void testAddToGroup() {
        System.out.println("addToGroup");
        String groupname = "";
        User instance = new User();
        instance.addToGroup(groupname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromGroup method, of class User.
     */
    @Test
    public void testRemoveFromGroup() {
        System.out.println("removeFromGroup");
        String groupname = "";
        User instance = new User();
        instance.removeFromGroup(groupname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
