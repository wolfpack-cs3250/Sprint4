//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Section{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sectionNumber;

    @ManyToOne
    private Course course;

    @ManyToOne
    private Professor professor;

    public Section() {}
    public Section(Course course, Long sectionNumber){
        this.sectionNumber = sectionNumber;
        this.course = course;
    }
    public Long getCourseId () {
        return id;
    }
    public void setProfessor(Professor professor){
        this.professor = professor;
    }
    public Professor getProfessor(){
        return professor;
    }
    public Long getSectionNumber (Long sectionNumber) {
        return sectionNumber;
    }
    public void setSectionNumber (Long sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
    public Course getCourse(){
        return course;
    }
    public void setCourse(Course course){
        this.course = course;
    }

}
