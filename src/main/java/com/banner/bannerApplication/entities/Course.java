package com.banner.bannerApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import com.banner.bannerApplication.entities.User;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_course", unique = true)
    private Long id;

    @OneToMany(mappedBy = "studentCourse")
    private List<User> students = new ArrayList<User>();

    // private List<Section> sections;


    @Column(unique = false)
    private String courseName;

    @Column(unique = false)
    private String department;

    @Column(unique = false)
    private String number;

    @Column(unique = false)
    private int credits;

    @Column(unique = false)
    private String description;

    @Column(unique = false)
    private String learningObjective;

    @Column(unique = false)
    private String prereqs;

    @Column(unique = false)
    private String coreq;

    public Long getCourseId() { return id; }

    public String getCoreq() {
        return coreq;
    }

    public void setCoreq(String coreq) {
        this.coreq = coreq;
    }

    public String getPrereqs() {

        return prereqs;
    }

    public void setPrereqs(String prereqs) {
        this.prereqs = prereqs;
    }

    public String getLearningObjective() {

        return learningObjective;
    }

    public void setLearningObjective(String learningObjective) {
        this.learningObjective = learningObjective;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {

        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getNumber() {

        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDepartment() {

        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    // Students getters and setters
    public void setStudents(List<User> students) {
        this.students = students;
    }

    public List<User> getStudents() {
        return students;
    }
}
