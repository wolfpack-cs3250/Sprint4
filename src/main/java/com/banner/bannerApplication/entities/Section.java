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

    private String courseId;

    private String courseName;
    private String sectionNumber;

    public Section() {

    }


    public void getCourseId (String id) {
        this.courseId = courseId;
    }


    public String getCourseName  (String courseName) {
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
