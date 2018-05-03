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
public class RegistrierPage extends Page{
    
    public RegistrierPage(SeleniumWrapper seleniumWrapper) throws Exception {
        super(seleniumWrapper);
    }
     
    public void addBenutzername(String comment)
    {
        seleniumWrapper.findElement(By.name("signup_username")).sendKeys(comment);
    }
    
    public void addPasswort(String comment)
    {
        seleniumWrapper.findElement(By.name("signup_password1")).sendKeys(comment);
        seleniumWrapper.findElement(By.name("signup_password2")).sendKeys(comment);
    }
    
    public void addMail(String comment)
    {
        seleniumWrapper.findElement(By.name("signup_email")).sendKeys(comment);
    }
    
    public void addFirstname(String comment)
    {
        seleniumWrapper.findElement(By.name("signup_firstname")).sendKeys(comment);
    }
    
    public void addLastname(String comment)
    {
        seleniumWrapper.findElement(By.name("signup_lastname")).sendKeys(comment);
    }
    
    public void selectGender(String gender)
    {
         new Select(seleniumWrapper.findElement(By.name("signup_gender"))).selectByVisibleText(gender);
    }
    
    public void addDatum(String datum)
    {
        seleniumWrapper.findElement(By.name("signup_birthdate")).sendKeys(datum);
    }
    
    public void addWeight(String comment)
    {
        seleniumWrapper.findElement(By.name("signup_weight")).sendKeys(comment);
    }
    
    public void submitRegiestrierung() throws Exception
    {
        seleniumWrapper.findElement(By.className("icon-pencil")).click();
    }
   
}
