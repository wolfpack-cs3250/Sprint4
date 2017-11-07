package com.banner.bannerApplication.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
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
    private long id;

    @ManyToOne
    private Section section;

    @Column(unique = false)
    private String firstName;

    @Column(unique = false)
    private String lastName;

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

    public String[] getDone() {
        return Arrays.copyOf(done, done.length);
    }

    public long getId() {
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


}
