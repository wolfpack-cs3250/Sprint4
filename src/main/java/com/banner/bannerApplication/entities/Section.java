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

    private Long id;
    private int sectionNumber;

    // private String courseName;
    // private Long professorId;
    // private Long courseId;



    public Long getCourseId () {
        return id;
    }

    public int getSectionNumber (int sectionNumber) {
        return sectionNumber;
    }

    public void setSectionNumber (int sectionNumber) {


//    public String getCourseName  (String courseName) {
//        return courseName;
//    }
//
//    public void setCourseName (String courseName) {
//        this.courseName = courseName;
//    }
    }
}
