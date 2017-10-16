package com.banner.bannerApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Global {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String schoolName;
    private long freshmanCredits;
    private long sophomoreCredits;
    private long juniorCredits;
    private long seniorCredits;
    private long creditsCompleted;

    // Set id number
    public void setId(String id){ this.id = id; }

    // Get id number
    public String getId(){ return id; }

    // Get School Name
    public String getSchoolName(){
        return schoolName;
    }

    // Set School Name
    public void setSchoolName(String school){
        schoolName = school;
    }

    // Set Freshmen credits
    public void setFreshmanCredits(long freshmanCredits) {
        this.freshmanCredits = freshmanCredits;
    }

    // Get Freshmen credits
    public long getFreshmanCredits() {
        return freshmanCredits;
    }

    // Set Sophomore Credits
    public void setSophomoreCredits(long sophomoreCredits) {
        this.sophomoreCredits = sophomoreCredits;
    }

    // Get Sophomore Credits
    public long getSophomoreCredits() {
        return sophomoreCredits;
    }

    // Set Junior Credits
    public void setJuniorCredits(long juniorCredits) {
        this.juniorCredits = juniorCredits;
    }

    // Get Junior Credits
    public long getJuniorCredits() {
        return juniorCredits;
    }

    // Set Senior Credits
    public void setSeniorCredits(long seniorCredits) {
        this.seniorCredits = seniorCredits;
    }

    // Get Senior Credits
    public long getSeniorCredits() {
        return seniorCredits;
    }

    // Set completed credits
    public void setCreditsCompleted(){ creditsCompleted = getFreshmanCredits()+getSophmoreCredits()+getJuniorCredits()+getSeniorCredits();}

    // Get total completed credits (adds up total completed credits)
    public long getCompletedCredits(){ return creditsCompleted; }
}
