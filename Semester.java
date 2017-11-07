package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Semester {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_semester", unique = true)
    private long id;

    // For semester we will need both the year and season of semester (i.e. Spring 2018)
    @Column(unique = true)
    private long year;

    @Column(unique = false)
    private String season;

    // maybe include a winter semester?
    public enum Season {
        FALL, SPRING, SUMMER
    }

    public Semester(){}

    public long getSemesterYear(){ return year; }

    public String getSemesterSeason(){ return season; }

    public void setSemesterYear(long year){ this.year = year; }

    public void setSemesterSeason(Season season){ this.season = season.toString(); }

    // Gives us a nice string version of the semester (i.e. Spring 2018)
    public String getSemesterString(){
        return season + " " + year;
    }
}
