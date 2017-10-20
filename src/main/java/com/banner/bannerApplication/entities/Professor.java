package com.banner.bannerApplication.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private Long id;

    @OneToMany(mappedBy = "professor")
    private Set<Section> sections = new HashSet<>();

    @Column(unique = false)
    private String firstName;

    @Column(unique = false)
    private String lastName;

    public Professor(){}
    public Professor(String firstname, String lastname){
        this.firstName = firstname;
        this.lastName = lastname;
    }

    public Set<Section> getSections(){
        return sections;
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
