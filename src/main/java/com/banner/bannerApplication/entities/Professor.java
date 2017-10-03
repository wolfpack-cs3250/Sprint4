package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @Column(unique=true)
    private String firstName;
    @Column(unique = true)
    private String lastName;

    public void setId(String id){
        this.id=id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
