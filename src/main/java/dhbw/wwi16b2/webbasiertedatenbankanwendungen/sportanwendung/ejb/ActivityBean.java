/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.ejb;

import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Activity;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.Sporttype;
import dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa.User;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author z003ne3b
 */
@Stateless
public class ActivityBean extends EntityBean<Activity, Long> {

    @EJB
    UserBean userbean;

    public ActivityBean() {
        super(Activity.class);
    }

    public List<Activity> findAllAcitvities() {
        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        CriteriaQuery<Activity> query = cb.createQuery(Activity.class);
        Root<Activity> from = query.from(Activity.class);
        query.select(from);

        query.orderBy(cb.desc(from.get("date")));

        query.where(cb.equal(from.get("user"), this.userbean.getCurrentUser()));

        return em.createQuery(query).getResultList();
    }

    ;


    
    public List<Activity> getTodaysActivites() {

        CriteriaBuilder cb = this.em.getCriteriaBuilder();

        CriteriaQuery<Activity> query = cb.createQuery(Activity.class);
        Root<Activity> from = query.from(Activity.class);
        query.select(from);

        query.orderBy(cb.desc(from.get("date")));

        query.where(cb.equal(from.get("user"), this.userbean.getCurrentUser()));

        Date today = new Date(System.currentTimeMillis());

        Predicate date = cb.between(from.get("date"), new Date(today.getYear(), today.getMonth(), today.getDate(), 0, 0, 0), new Date(today.getYear(), today.getMonth(), today.getDate(), 23, 59, 59));;

        query.where(cb.and(date));
        return em.createQuery(query).getResultList();
    }

    public int calculateCalories(Sporttype sporttype, User user, int duration) {

        return sporttype.getMet() * user.getWeight() * duration;

    }

}
