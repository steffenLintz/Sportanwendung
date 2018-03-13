/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Activity;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Sporttype;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

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
    
    @EJB
    UserBean userbean;
    
    public List<Activity> findtodaysAcitvities(){
        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        CriteriaQuery<Activity> query = cb.createQuery(Activity.class);
        Root<Activity> from = query.from(Activity.class);
        query.select(from);

        // ORDER BY dueDate, dueTime
        query.orderBy(cb.desc(from.get("Date")));
        
        query.where(cb.equal(from.get("user"), this.userbean.getCurrentUser()));
      

        return em.createQuery(query).getResultList();
    };
    
     public List<Activity> findtodaysAcitvities(){
        
    };
    
    public int calculateCalories(Sporttype sporttype, User user, int duration){
       
       return sporttype.getMet()* user.getWeight()* duration;
        
    }
    
    
}
