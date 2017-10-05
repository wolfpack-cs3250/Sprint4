//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.banner.bannerApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String courseName;
    private String sectionNumber;
    private Long professorId;
    private Long courseId;

    // private List<Students>;

    public Section() {

    }


    public Long getCourseId () {
        return id;
    }

    public String getCourseName (String courseName) {
        return courseName;
    }

    public void setCourseName (String courseName) {
        this.courseName = courseName;
    }

    public String getSectionNumber (String sectionNumber) {
        return sectionNumber;
    }

    public void setSectionNumber (String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

}
