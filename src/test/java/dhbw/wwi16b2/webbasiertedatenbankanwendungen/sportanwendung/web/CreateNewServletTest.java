/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Axel
 */
public class CreateNewServletTest {
    
    HttpServletRequest request;
    HttpServletResponse response;
    
    public CreateNewServletTest() {
    }
    
    @Before
    public void setUp() {
        this.request = mock(HttpServletRequest.class);
        this.response = mock(HttpServletResponse.class);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doGet method, of class CreateNewServlet.
     */
    @org.junit.Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");

        //request.setParameter();
        CreateNewServlet instance = new CreateNewServlet();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class CreateNewServlet.
     */
    @org.junit.Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CreateNewServlet instance = new CreateNewServlet();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
