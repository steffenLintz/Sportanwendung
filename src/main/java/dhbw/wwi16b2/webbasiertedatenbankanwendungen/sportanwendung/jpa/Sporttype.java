/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dhbw.wwi16b2.webbasiertedatenbankanwendungen.sportanwendung.jpa;

import java.io.*;
import javax.persistence.*;

/**
 *
 * @author geizzo
 */
@Entity
@Table(name = "SPORTTYPE")
public class Sporttype implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id = 0;

    private int met;

    private String name;

    private String picture;

    @OneToOne(mappedBy = "sporttype")
    private Activity activity = null;

    public Sporttype() {
    }

    public Sporttype(String name) {
        this.name = name;

        switch (this.name) {
            case "Fußball":
                this.met = 7;
                this.picture = "../../img/fußball.png";
                break;
            case "Tennis":
                this.met = 8;
                this.picture = "../../img/tennis.png";
                break;
            case "Schwimmen":
                this.met = 6;
                this.picture = "../../img/schwimmen.png";
                break;
            case "Fahrrad":
                this.met = 10;
                this.picture ="../../img/fahrrad.png";
                break;
            case "Laufen":
                this.met = 12;
                this.picture = "../../img/laufen.png";
                break;
            case "Kraftsport":
                this.met = 8;
                this.picture = "../../img/kraftsport.png";
                break;
        }
    }

    public long getId() {
        return id;
    }

    public int getMet() {
        return met;
    }

    public void setMet(int met) {
        this.met = met;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
