/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.test;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.RegistrierPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.selenium.SeleniumWrapper;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author shkel
 */
public class RegisriermaskeTest {
    
    private SeleniumWrapper driverWrapper;
    
    @Before
    public void setUp() throws Exception {
        driverWrapper = new SeleniumWrapper("firefox");
    }
    
    @Test
    public void testRegistriermaske() throws Exception {
        
        RegistrierPage registrierPage = driverWrapper.gotoRegistrierPage();
        
        String Benutzername = "Selenium2";
        registrierPage.addBenutzername(Benutzername);
        
        String Passwort = "Selenium";
        registrierPage.addPasswort(Passwort);
        
        String Mail = "selenium@hotmail.de";
        registrierPage.addMail(Mail);
        
        String Vorname = "Sele";
        registrierPage.addFirstname(Vorname);
        
        String Nachname = "nium";
        registrierPage.addLastname(Nachname);

        String Gender = "männlich";
        registrierPage.selectGender(Gender);
        
        String Datum ="01121995";
        registrierPage.addDatum(Datum);
        
        String Gewicht = "85";
        registrierPage.addWeight(Gewicht);
        
        registrierPage.submitRegiestrierung();

    }
}
