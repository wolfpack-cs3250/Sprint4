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
    private Set<Position> positions;

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    private String Username;

    public Professor(){
    }
    public Professor(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

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
