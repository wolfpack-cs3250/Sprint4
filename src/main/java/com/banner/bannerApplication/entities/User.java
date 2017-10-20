package com.banner.bannerApplication.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Section;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "student_id", unique = true)
    private Long id;

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

    @Column(name="Registered", nullable = false)
    @ElementCollection(targetClass = long.class)
    private List<Long> inProgess;

    public void setInProgress(long classId) {
        inProgess.add(classId);
    }

    public void removeInprgoress(String classname) {
        inProgess.remove(classname);
    }

    public String[] getDone() {
        return Arrays.copyOf(done, done.length);
    }

    public Long getStudentId() {
        return id;
    }

    public Section getSection() {
        return section;
    }
    public void setSection(Section section){
        this.section = section;
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
