/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.selenium;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.BenutzerPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.HauptPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.RegistrierPage;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects.SportartPage;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author shkel
 */
public class SeleniumWrapper {
    
    private WebDriver driver;
    private String baseUrl;
    
    public SeleniumWrapper(String browser) {
        driver = new FirefoxDriver();
        baseUrl = "https://localhost:8181/sportanwendung/app/home/";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public String getBaseUrl() {
        return baseUrl;
    }
    
    /**
     *
     * @return
     * @throws Exception
     */
    public RegistrierPage gotoRegistrierPage() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.className("menuitem")).click();
        return new RegistrierPage(this);
    }
    
    public HauptPage gotoHauptPage() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.name("j_username")).sendKeys("Selenium2");
        driver.findElement(By.name("j_password")).sendKeys("Selenium");
        driver.findElement(By.className("icon-login")).click();
        return new HauptPage(this);
    }
    
    public SportartPage gotoSportartPage() throws Exception {
        driver.get("https://localhost:8181/sportanwendung/app/home/");
        driver.findElement(By.className("activitytile")).click();
        return new SportartPage(this);
    }
    
    public BenutzerPage gotoBenutzerPage() throws Exception {
        driver.get("https://localhost:8181/sportanwendung/app/user-edit/");
        return new BenutzerPage(this);
    }
    
    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }



    public void click(By element) throws Exception {
        try {
            findElement(element).click();
//            waitForAjaxAndAnimation();
        } catch (Exception e) {
            System.out
                    .println("Attempt to click on element " + element.toString() 
                            + " has failed on page" +  driver.getTitle());
            throw e;
        }
    }

    
  public String getTitle(){
    return   driver.getTitle();
  }
    
    public String getInnerText(By element) {
        return findElement(element).getText();
    }

    public WebElement findElement(By element) {
        return driver.findElement(element);
    }
    
    public List<WebElement> findElements(By element)
    {
        return driver.findElements(element);
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clear(By element) {
        driver.findElement(element).clear();
    }

}
    

