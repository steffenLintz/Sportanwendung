/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Activity;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Sporttype;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Axel
 */
public class ActivityBeanTest {
    static EJBContainer container;
    static User user = new User();
    
    public ActivityBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
    
    /**
     * Test of findAllAcitvities method, of class ActivityBean.
     */
    @Test
    public void testFindAllAcitvities() throws Exception {
        System.out.println("findAllAcitvities");
        Sporttype test = new Sporttype("test");
        Date date = new Date();
        int duration = 0;
        int rating = 0;
        Activity activity = new Activity(test, date, duration, rating, user);
        List<Activity> expResult = null;
        expResult.add(activity);
        ActivityBean instance = (ActivityBean)container.getContext().lookup("java:global/classes/ActivityBean");
        List<Activity> result = instance.findAllAcitvities();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodaysActivites method, of class ActivityBean.
     */
    @Test
    public void testGetTodaysActivites() throws Exception {
        System.out.println("getTodaysActivites");
        ActivityBean instance = (ActivityBean)container.getContext().lookup("java:global/classes/ActivityBean");
        List<Activity> expResult = null;
        List<Activity> result = instance.getTodaysActivites();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateCalories method, of class ActivityBean.
     */
    @Test
    public void testCalculateCalories() throws Exception {
        System.out.println("calculateCalories");
        Sporttype sporttype = null;
        User user = null;
        int duration = 0;
        ActivityBean instance = (ActivityBean)container.getContext().lookup("java:global/classes/ActivityBean");
        int expResult = 0;
        int result = instance.calculateCalories(sporttype, user, duration);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
