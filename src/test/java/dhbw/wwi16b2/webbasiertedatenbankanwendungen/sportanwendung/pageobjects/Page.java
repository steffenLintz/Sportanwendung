/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.pageobjects;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendungen.selenium.SeleniumWrapper;

/**
 *
 * @author shkel
 */
public class Page {
    
    protected SeleniumWrapper seleniumWrapper;

    public Page(SeleniumWrapper seleniumWrapper) throws Exception {
        this.seleniumWrapper = seleniumWrapper;
  }
    
    public PageBody getPageBody(){
    return new PageBody(seleniumWrapper);
  }
    
    public class PageBody{
        public PageBody(SeleniumWrapper seleniumWrapper){
        //IMPLEMENT ME
    }
  }
}
