/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author z003ne3b
 */
@Entity
@Table(name="ACTIVITY")
public class Activity implements Serializable {
    @Id
    @GeneratedValue
    private long id =0;
    
    @NotNull(message="Es muss eine Sportart ausgewählt sein")
    private Sporttype sporttype;
    
    private int calories;
    
    @NotNull(message="Es muss ein Datum angeben werden")
    private Date date;
    
    @NotNull(message="Es muss eine Dauer angegeben werden")
    private int duration;
    
    private int rating;

    public Activity(Sporttype sporttype, Date date, int duration, int rating) {
        this.sporttype = sporttype;
        this.date = date;
        this.duration = duration;
        this.rating = rating;
    }
    

    
    public Activity(Sporttype sporttype, Date date, int duration) {
        this.sporttype = sporttype;
        this.date = date;
        this.duration = duration;
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
