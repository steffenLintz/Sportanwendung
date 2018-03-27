/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.util.Date;
import javax.ejb.embeddable.EJBContainer;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Axel
 */
public class UserBeanTest {
    
    Date expDate = new Date();
    String expUsername = "test1234";    
    String expPassword = "test1234";
    String expEmail = "test@test.de"; 
    String expFirstname = "ftest";
    String expLastname = "ltest"; 
    String expGender = "männlich"; 
    int expWeight = 50;
    int expHeight = 123;
    
    User expUser = new User(expUsername, expPassword, expEmail, expFirstname, expLastname, expGender, expDate, expWeight, expHeight);
    EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
    
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    //request.login(expUsername, expPassword);

    public UserBeanTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCurrentUser method, of class UserBean.
     */
    @Test
    public void testGetCurrentUser() throws Exception {
        System.out.println("getCurrentUser");
        UserBean instance = (UserBean)container.getContext().lookup("java:global/classes/UserBean");
        User result = instance.getCurrentUser();
        assertEquals(expUser, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of signup method, of class UserBean.
     */
    @Test
    public void testSignup() throws Exception {
        System.out.println("signup");
        String username = "";
        String passwordHash = "";
        String email = "";
        String firstname = "";
        String lastname = "";
        String gender = "";
        Date birthdate = null;
        int weight = 0;
        int height = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserBean instance = (UserBean)container.getContext().lookup("java:global/classes/UserBean");
        instance.signup(username, passwordHash, email, firstname, lastname, gender, birthdate, weight, height);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changePassword method, of class UserBean.
     */
    @Test
    public void testChangePassword() throws Exception {
        System.out.println("changePassword");
        User user = null;
        String oldPassword = "";
        String newPassword = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserBean instance = (UserBean)container.getContext().lookup("java:global/classes/UserBean");
        instance.changePassword(user, oldPassword, newPassword);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class UserBean.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        User user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserBean instance = (UserBean)container.getContext().lookup("java:global/classes/UserBean");
        instance.delete(user);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UserBean.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        User user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserBean instance = (UserBean)container.getContext().lookup("java:global/classes/UserBean");
        User expResult = null;
        User result = instance.update(user);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
