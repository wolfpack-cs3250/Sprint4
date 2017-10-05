package com.banner.bannerApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

import java.util.List;

import com.banner.bannerApplication.entities.Course;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", unique = true)
    private Long id;

    @ManyToOne
    private Course studentCourse;

    @Column(unique = true)
    private String firstName;

    @Column(unique = true)
    private String lastName;

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
