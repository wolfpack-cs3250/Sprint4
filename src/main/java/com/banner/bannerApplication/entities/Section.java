//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Section extends Professor{
    //@id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private String courseId;
//    @Column(unique = true)
//    private String courseName;
    @Column(unique = true)
    private int sectionNumber;
    @Column(unique = true)

    // private Professor professor;
    // private List<Students>;
    // private Course course;



    public void getCourseId (String id) {
        this.courseId = courseId;
    }


//    public String getCourseName  (String courseName) {
//        return courseName;
//    }
//
//    public void setCourseName (String courseName) {
//        this.courseName = courseName;
//    }

    public int getSectionNumber (int sectionNumber) {
        return sectionNumber;
    }

    public void setSectionNumber (int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

}
