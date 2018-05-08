/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Axel
 */
public class SporttypeTest {
    
    //erwartete Daten
    Sporttype expSporttype = new Sporttype("Fußball");
    int expMet = 7;
    String expName = "Fußball";
    String expPicture = "../../img/fußball.png";
    
    public SporttypeTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getMet method, of class Sporttype.
     */
    @Test
    public void testGetMet() {
        System.out.println("getMet");
        int result = expSporttype.getMet();
        assertEquals("getMet", expMet, result);
    }

    /**
     * Test of setMet method, of class Sporttype.
     */
    @Test
    public void testSetMet() {
        System.out.println("setMet");
        int altMet = 2;
        expSporttype.setMet(altMet);
        int result = expSporttype.getMet();
        assertEquals("setMet", altMet, result);
    }

    /**
     * Test of getName method, of class Sporttype.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        String result = expSporttype.getName();
        assertEquals("getName", expName, result);
    }

    /**
     * Test of setName method, of class Sporttype.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String altName = "Test";
        expSporttype.setName(altName);
        String result = expSporttype.getName();
        assertEquals("setName", altName, result);
    }

    /**
     * Test of getPicture method, of class Sporttype.
     */
    @Test
    public void testGetPicture() {
        System.out.println("getPicture");
        String result = expSporttype.getPicture();
        assertEquals("getPicture", expPicture, result);
    }

    /**
     * Test of setPicture method, of class Sporttype.
     */
    @Test
    public void testSetPicture() {
        System.out.println("setPicture");
        String altPicture = "../../img/tennis.png";
        expSporttype.setPicture(altPicture);
        String result = expSporttype.getPicture();
        assertEquals("setPicture", altPicture, result);
    }
    
}
