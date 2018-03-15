/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author z003ne3b
 */
@Entity
@Table(name="ACTIVITY")
public class Activity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE) 
    private long id =0;
    

    @OneToOne
    @NotNull(message="Es muss eine Sportart angegeben werden")
    private Sporttype sporttype;
    
    @Column(name = "CALORIES")
    private int calories;
    
    @NotNull(message="Es muss ein Datum und eine Uhrzeit angeben werden")
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "DATE")
    private Date date;
    
    @NotNull(message="Es muss eine Dauer angegeben werden")
    @Min(value=1, message="Dauer der Aktivität muss mindestens 1 Minute sein")
    @Column(name = "DURATION")
    private int duration;
    
    @Column(name = "RATING")
    private int rating;

    
    @ManyToOne
    @NotNull(message="Es muss eine Benutzer zugeordnet werden")
    User user;
    
    public Activity() {
    }



    public Activity(Sporttype sporttype, Date date, int duration, int rating, User user) {
        this.sporttype = sporttype;
        this.date = date;
        this.duration = duration;
        this.rating = rating;
        this.calories = (sporttype.getMet()* user.getWeight()* duration)/60;
        this.user = user;
    }

    public Activity(Sporttype sporttype, Date date, int duration, User user) {
        this.sporttype = sporttype;
        this.date = date;
        this.duration = duration;
        this.user = user;
        this.calories = (sporttype.getMet()* user.getWeight()* duration)/60;
    }

    
    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Sporttype getSporttype() {
        return sporttype;
    }

    public void setSporttype(Sporttype sporttype) {
        this.sporttype = sporttype;
    }
    
}
