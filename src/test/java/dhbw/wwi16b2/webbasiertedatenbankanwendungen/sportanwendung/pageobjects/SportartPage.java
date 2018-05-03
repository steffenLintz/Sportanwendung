/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.selenium.SeleniumWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author shkel
 */
public class SportartPage extends Page{
    
    public SportartPage(SeleniumWrapper seleniumWrapper) throws Exception {
        super(seleniumWrapper);
    }
    
    public void selectSportart(String sportart)
    {
         new Select(seleniumWrapper.findElement(By.name("activity_sporttype"))).selectByVisibleText(sportart);
    }
    
    public void addDauer(String dauer)
    {
        seleniumWrapper.findElement(By.name("activity_duration")).sendKeys(dauer);
    }
    
    public void addDistanz(String distanz)
    {
        seleniumWrapper.findElement(By.name("activity_distance")).sendKeys(distanz);
    }
    
    public void addTime(String time)
    {
        seleniumWrapper.findElement(By.name("activity_time")).click();
        seleniumWrapper.findElement(By.name("activity_time")).sendKeys(time);
    }
    
    public void submitSportart() throws Exception
    {
        seleniumWrapper.findElement(By.className("icon-pencil")).click();
    }
}
