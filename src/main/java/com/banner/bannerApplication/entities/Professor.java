package com.banner.bannerApplication.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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



    @NotNull
    private String password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
