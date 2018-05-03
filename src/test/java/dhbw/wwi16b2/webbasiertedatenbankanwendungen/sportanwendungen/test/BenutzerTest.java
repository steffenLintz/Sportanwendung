/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.test;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.BenutzerPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.HauptPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.selenium.SeleniumWrapper;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author shkel
 */
public class BenutzerTest {
    
    private SeleniumWrapper driverWrapper;
    
    @Before
    public void setUp() throws Exception {
        driverWrapper = new SeleniumWrapper("firefox");
    }
    
    @Test
    public void testSportart() throws Exception {
        
        HauptPage hauptPage = driverWrapper.gotoHauptPage();
        BenutzerPage benutzerPage = driverWrapper.gotoBenutzerPage();
        
        String PasswortAlt = "Selenium";
        benutzerPage.addAltPasswort(PasswortAlt);
        
        String PasswortNeu = "Selenium1";
        benutzerPage.addNeuPasswort(PasswortNeu);
        
        String Name = "Test";
        benutzerPage.addName(Name);
        
        benutzerPage.submitBenutzer();
        
}
}
