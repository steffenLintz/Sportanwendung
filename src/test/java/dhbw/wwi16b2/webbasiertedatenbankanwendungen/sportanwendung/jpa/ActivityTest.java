/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Axel
 */
public class ActivityTest {
    
    Sporttype expSporttype = new Sporttype("Fußball");
    Date expDate = new Date();
    int expDuration = 20;
    int expRating = 2;
    
    String expUsername = "test1234";    
    String expPassword = "test1234";
    String expEmail = "test@test.de"; 
    String expFirstname = "ftest";
    String expLastname = "ltest"; 
    String expGender = "männlich"; 
    int expWeight = 50;
    int expHeight = 123;
    
    User expUser = new User(expUsername, expPassword, expEmail, expFirstname, expLastname, expGender, expDate, expWeight, expHeight);
    
    Activity activity = new Activity(expSporttype, expDate, expDuration, expRating, expUser);
    
    int expCalories = (7 * expWeight * expDuration)/60;
    
    Long l = expSporttype.getId();
    
    public ActivityTest() {
    }
    
    @Before
    public void setUp() {
        System.out.println(l);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class Activity.
     */
    @Test
    public void testGetSetId() {
        System.out.println("getId");
        long expResult = 0L;
        activity.setId(expResult);
        long result = activity.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setId method, of class Activity.
     */
    
    /*@Test
    public void testSetId() {
        System.out.println("setId");
        long expResult = 0L;
        activity.setId(expResult);
        long result = activity.getId();
        assertEquals(expResult, result);
    }
    */
    
    /**
     * Test of getCalories method, of class Activity.
     */
    @Test
    public void testGetCalories() {
        System.out.println("getCalories");
        int result = activity.getCalories();
        assertEquals(expCalories, result);
    }

    /**
     * Test of setCalories method, of class Activity.
     */
    @Test
    public void testSetCalories() {
        System.out.println("setCalories");
        int calories = 0;
        activity.setCalories(calories);
        int result = activity.getCalories();
        assertEquals(calories, result);
    }

    /**
     * Test of getDate method, of class Activity.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Date result = activity.getDate();
        assertEquals(expDate, result);
    }

    /**
     * Test of setDate method, of class Activity.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date testDate = new Date();
        activity.setDate(testDate);
        Date result = activity.getDate();
        assertEquals(testDate, result);
    }

    /**
     * Test of getDuration method, of class Activity.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        int result = activity.getDuration();
        assertEquals(expDuration, result);
    }

    /**
     * Test of setDuration method, of class Activity.
     */
    @Test
    public void testSetDuration() {
        System.out.println("setDuration");
        int testDuration = 0;
        activity.setDuration(testDuration);
        int result = activity.getDuration();
        assertEquals(testDuration, result);
    }

    /**
     * Test of getRating method, of class Activity.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        int result = activity.getRating();
        assertEquals(expRating, result);
    }

    /**
     * Test of setRating method, of class Activity.
     */
    @Test
    public void testSetRating() {
        System.out.println("setRating");
        int testRating = 0;
        activity.setRating(testRating);
        int result = activity.getRating();
        assertEquals(testRating, result);
    }

    /**
     * Test of getSporttype method, of class Activity.
     */
    @Test
    public void testGetSporttype() {
        System.out.println("getSporttype");
        Sporttype result = activity.getSporttype();
        assertEquals(expSporttype, result);
    }

    /**
     * Test of setSporttype method, of class Activity.
     */
    @Test
    public void testSetSporttype() {
        System.out.println("setSporttype");
        Sporttype testSporttype = new Sporttype ("Laufen");
        activity.setSporttype(testSporttype);
        Sporttype result = activity.getSporttype();
        assertEquals(testSporttype, result);
    }
    
}
