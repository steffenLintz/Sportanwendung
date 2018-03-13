/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author z003ne3b
 */
@Stateless
public class ActivityBean {
    @PersistenceContext
    EntityManager em;
    
    @Resource
    EJBContext ctx;
    
    public void calculateCalories(Sporttype sporttype, User user, int dura){
        int met=sporttype.getmet();
        int weight = user.getWeight();
        int duration = dura;
        
        int result = met*weight* duration;
    }
    
    
}
