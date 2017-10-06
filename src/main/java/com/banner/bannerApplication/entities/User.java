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

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "student_id", unique = true)
    private Long id;
  
    @ManyToOne
    private Course studentCourse;

    @Column(unique = false)
    private String firstName;

    @Column(unique = false)
    private String lastName;

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

    // Course Getters and setters
    public Course getCourse() {
        return studentCourse;
    }

    public void setCourse(Course course) {
        this.studentCourse = course;
    }

}
