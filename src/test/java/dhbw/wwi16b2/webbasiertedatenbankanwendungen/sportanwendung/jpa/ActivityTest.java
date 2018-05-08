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
    
    //erwartete Daten Benutzerobjekt
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
    
    //Erwartete Daten Aktivitätenobjekt
    int expDuration = 20;
    int expRating = 2;
    Sporttype expSporttype = new Sporttype("Fußball");
    Activity activity = new Activity(expSporttype, expDate, expDuration, expRating, expUser);
    
    int expMet = 7;
    
    public ActivityTest() {
    }
    
    @Before
    public void setUp() {
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
        assertEquals("getSetId", expResult, result);
    }
    
    /**
     * Test of getCalories method, of class Activity.
     */
    @Test
    public void testGetCalories() {
        System.out.println("getCalories");
        int result = activity.getCalories();
        assertEquals("getCalories", CaloriesCalculationTest.calcCalories(expMet, expWeight, expDuration), result);
    }

    /**
     * Test of setCalories method, of class Activity.
     */
    @Test
    public void testSetCalories() {
        System.out.println("setCalories");
        activity.setCalories();
        int result = activity.getCalories();
        assertEquals("setCalories", CaloriesCalculationTest.calcCalories(expMet, expWeight, expDuration), result);
    }

    /**
     * Test of getDate method, of class Activity.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Date result = activity.getDate();
        assertEquals("getDate", expDate, result);
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
        assertEquals("setDate", testDate, result);
    }

    /**
     * Test of getDuration method, of class Activity.
     */
    @Test
    public void testGetDuration() {
        System.out.println("getDuration");
        int result = activity.getDuration();
        assertEquals("getDuration", expDuration, result);
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
        assertEquals("setDuration", testDuration, result);
    }

    /**
     * Test of getRating method, of class Activity.
     */
    @Test
    public void testGetRating() {
        System.out.println("getRating");
        activity.setRating(expRating);
        int result = activity.getRating();
        assertEquals("getRating", expRating, result);
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
        assertEquals("setRating", testRating, result);
    }

    /**
     * Test of getSporttype method, of class Activity.
     */
    @Test
    public void testGetSporttype() {
        System.out.println("getSporttype");
        Sporttype result = activity.getSporttype();
        assertEquals("getSporttype", expSporttype, result);
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
        assertEquals("setSporttype", testSporttype, result);
    }
    
}
