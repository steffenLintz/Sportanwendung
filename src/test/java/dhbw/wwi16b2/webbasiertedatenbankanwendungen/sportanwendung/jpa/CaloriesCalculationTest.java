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
public class CaloriesCalculationTest {
    
    //Instanzen aller möglicher Sportarten
    Sporttype expSporttypeFußball = new Sporttype("Fußball");
    Sporttype expSporttypeLaufen = new Sporttype("Laufen");
    Sporttype expSporttypeTennis = new Sporttype("Tennis");
    Sporttype expSporttypeSchwimmen = new Sporttype("Schwimmen");
    Sporttype expSporttypeKraftsport = new Sporttype("Kraftsport");
    Sporttype expSporttypeFahrrad = new Sporttype("Fahrrad");

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
    
    //erwartete Daten Aktivitätenobjekt
    int expDuration = 20;
    int expRating = 2;
    Activity activity = new Activity(expSporttypeFußball, expDate, expDuration, expRating, expUser);
    
    int expMet = 7;
    
    //Kalorienberechnung als Methode
    public static int calcCalories (int met, int weight, int duration) {
        return (met * weight * duration)/60;
    }
    
    public CaloriesCalculationTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    //Kalorien jeder Sportart berechnen und prüfen
    @Test
    public void testGetAllCalories () {
        int result = activity.getCalories();
        assertEquals("CaloriesFußball", calcCalories(expMet, expWeight, expDuration), result);
        
        //Neues Aktivtätenobjekt, um Kalorienberewchnung für nächste Sportart auszuführen; gleiches Schema für jede Sportart
        activity = new Activity(expSporttypeLaufen, expDate, expDuration, expRating, expUser);
        expMet = 12;
        assertEquals("CaloriesLaufen", calcCalories(expMet, expWeight, expDuration), activity.getCalories());
        
        activity = new Activity(expSporttypeTennis, expDate, expDuration, expRating, expUser);
        expMet = 8;
        assertEquals("CaloriesTennis", calcCalories(expMet, expWeight, expDuration), activity.getCalories());
        
        activity = new Activity(expSporttypeSchwimmen, expDate, expDuration, expRating, expUser);
        expMet = 6;
        assertEquals("CaloriesSchwimmen", calcCalories(expMet, expWeight, expDuration), activity.getCalories());
        
        activity = new Activity(expSporttypeKraftsport, expDate, expDuration, expRating, expUser);
        expMet = 8;
        assertEquals("CaloriesKraftsport", calcCalories(expMet, expWeight, expDuration), activity.getCalories());
        
        activity = new Activity(expSporttypeFahrrad, expDate, expDuration, expRating, expUser);
        expMet = 10;
        assertEquals("CaloriesFahrrad", calcCalories(expMet, expWeight, expDuration), activity.getCalories());
    }
    
}
