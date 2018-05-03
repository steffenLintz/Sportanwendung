/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.test;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.HauptPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.SportartPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.selenium.SeleniumWrapper;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author shkel
 */
public class SportartTest {
    
    private SeleniumWrapper driverWrapper;
    
    @Before
    public void setUp() throws Exception {
        driverWrapper = new SeleniumWrapper("firefox");
    }
    
    @Test
    public void testSportart() throws Exception {
        
        HauptPage hauptPage = driverWrapper.gotoHauptPage();
        SportartPage sportartPage = driverWrapper.gotoSportartPage();
        
        String Sportart ="Tennis";
        sportartPage.selectSportart(Sportart);
        
        String Dauer = "120";
        sportartPage.addDauer(Dauer);
        
        String Distanz = "10";
        sportartPage.addDistanz(Distanz);
        
        String Time = "14:10";
        sportartPage.addTime(Time);
        
        sportartPage.submitSportart();
        
    }
    
}
