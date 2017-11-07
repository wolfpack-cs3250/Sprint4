package com.banner.bannerApplication.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Section;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(unique = true)
    private Long id;

    @ManyToOne
    private Section section;

    @Column(unique = false)
    private String firstName;

    @Column(unique = false)
    private String lastName;

    @NotNull
    private String password;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    private String Username;

    //@Column(unique = false)
    //private long completedCredits = 666;

    @Column(unique = true)
    private String[] done;

    @OneToMany(mappedBy = "user")
    private Set<Section> sections = new HashSet<>();

    @Column(name="Registered", nullable = false)
    @ElementCollection(targetClass = long.class)
    private List<Long> inProgess;

    public void setInProgress(long classId) {
        inProgess.add(classId);
    }

    public void removeInprgoress(String classname) {
        inProgess.remove(classname);
    }

    public Set<Section> getSections(){
        return sections;
    }

    public void setSection(Section section){
        this.section = section;
    }

    public String[] getDone() {
        return Arrays.copyOf(done, done.length);
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setPassword(String password){this.password=password;}
    public String getPassword(){return password;}


}
