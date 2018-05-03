/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.selenium.SeleniumWrapper;
import org.openqa.selenium.By;

/**
 *
 * @author shkel
 */
public class BenutzerPage extends Page{
    
    public BenutzerPage(SeleniumWrapper seleniumWrapper) throws Exception {
        super(seleniumWrapper);
    }

    public void addAltPasswort(String AltPasswort)
    {
        seleniumWrapper.findElement(By.name("user_edit_oldpassword")).sendKeys(AltPasswort);
    }
    
    public void addNeuPasswort(String NeuPasswort)
    {
        seleniumWrapper.findElement(By.name("user_edit_password1")).sendKeys(NeuPasswort);
        seleniumWrapper.findElement(By.name("user_edit_password2")).sendKeys(NeuPasswort);
    }
    
    public void addName (String Name)
    {
        seleniumWrapper.findElement(By.name("user_edit_firstname")).clear();
        seleniumWrapper.findElement(By.name("user_edit_firstname")).sendKeys(Name);
    }

   public void submitBenutzer() throws Exception
    {
        seleniumWrapper.findElement(By.className("icon-pencil")).click();
    }

    
}
