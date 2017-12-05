package com.banner.bannerApplication.entities;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.*;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Section;

@Entity
@Table(name="USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = { @JoinColumn(name="USER_ID")},
            inverseJoinColumns = {@JoinColumn(name="SECTION_ID")}
    )
    private Set<Section> section = new HashSet<Section>();

    @Column(unique = false)
    private String firstName;

    @Column(unique = false)
    private String lastName;

    //@Column(unique = false)
    //private long completedCredits = 666;

    @Column(unique = false)
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

    public void setSection(Set<Section> section){
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

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
