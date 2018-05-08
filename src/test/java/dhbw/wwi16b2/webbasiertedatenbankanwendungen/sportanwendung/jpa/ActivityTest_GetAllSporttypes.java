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
public class ActivityTest_GetAllSporttypes {
    
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
    
    //Instanzen aller möglicher Sportarten
    Sporttype expSporttypeFußball = new Sporttype("Fußball");
    Sporttype expSporttypeLaufen = new Sporttype("Laufen");
    Sporttype expSporttypeTennis = new Sporttype("Tennis");
    Sporttype expSporttypeSchwimmen = new Sporttype("Schwimmen");
    Sporttype expSporttypeKraftsport = new Sporttype("Kraftsport");
    Sporttype expSporttypeFahrrad = new Sporttype("Fahrrad");
    
    //Instanzen aller Aktivitäten zu den Sportarten
    int expDuration = 20;
    int expRating = 2;
    Activity activityFußball = new Activity(expSporttypeFußball, expDate, expDuration, expRating, expUser);
    Activity activityLaufen = new Activity(expSporttypeLaufen, expDate, expDuration, expRating, expUser);
    Activity activityTennis = new Activity(expSporttypeTennis, expDate, expDuration, expRating, expUser);
    Activity activitySchwimmen = new Activity(expSporttypeSchwimmen, expDate, expDuration, expRating, expUser);
    Activity activityKraftsport = new Activity(expSporttypeKraftsport, expDate, expDuration, expRating, expUser);
    Activity activityFahrrad = new Activity(expSporttypeFahrrad, expDate, expDuration, expRating, expUser);
    
    //Erwarteter Met-Wert für jede Sportart
    int expMetFußball = 7;
    int expMetLaufen = 12;
    int expMetTennis = 8;
    int expMetSchwimmen = 6;
    int expMetKraftsport = 8;
    int expMetFahrrad = 10;
    
    public ActivityTest_GetAllSporttypes() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    //Test, ob die Sportarten den Aktivitäten richtig zugeordnet werden
    @Test
    public void testGetAllSporttypes() {
        System.out.println("getAllSporttype");
        assertEquals("SporttypeFußball", expSporttypeFußball, activityFußball.getSporttype());
        assertEquals("SporttypeLaufen", expSporttypeLaufen, activityLaufen.getSporttype());
        assertEquals("SporttypeTennis", expSporttypeTennis, activityTennis.getSporttype());
        assertEquals("SporttypeSchwimmen", expSporttypeSchwimmen, activitySchwimmen.getSporttype());
        assertEquals("SporttypeKraftsport", expSporttypeKraftsport, activityKraftsport.getSporttype());
        assertEquals("SporttypeFahrrad", expSporttypeFahrrad, activityFahrrad.getSporttype());
    }

    /* Testen, ob Attribute der einzelnen Sportarten mit den erwarteten Attributen übereinstimmen 
    *   --> Verifikation, dass alle Sportarten richtig angelegt wurden
    */
    @Test
    public void testGetMetAllSporttypes() {
        System.out.println("GetMetAllSporttypes");
        assertEquals("MetFußball", expMetFußball, expSporttypeFußball.getMet());
        assertEquals("MetLaufen", expMetLaufen, expSporttypeLaufen.getMet());
        assertEquals("MetTennis", expMetTennis, expSporttypeTennis.getMet());
        assertEquals("MetSchwimmen", expMetSchwimmen, expSporttypeSchwimmen.getMet());
        assertEquals("MetKraftsport", expMetKraftsport, expSporttypeKraftsport.getMet());
        assertEquals("MetFahrrad", expMetFahrrad, expSporttypeFahrrad.getMet());
    }
    
}
