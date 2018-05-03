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
public class IntroPage extends Page {
    
     public IntroPage(SeleniumWrapper seleniumWrapper) throws Exception {
        super(seleniumWrapper);
    }
     
    /**
     *
     * @return
     */
    @Override
     public PageBody getPageBody(){
        return new PageBody(seleniumWrapper);
    }
    
}
