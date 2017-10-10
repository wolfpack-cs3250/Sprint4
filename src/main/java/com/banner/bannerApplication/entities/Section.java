//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Section extends Professor{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int sectionNumber;

    @ManyToOne
    private Course course;

    public Section() {}

    public Section(Course course, int sectionNumber){
        this.sectionNumber = sectionNumber;
        this.course = course;
    }

    public Long getCourseId () {
        return id;
    }
    public int getSectionNumber (int sectionNumber) {
        return sectionNumber;
    }
    public void setSectionNumber (int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
    public Course getCourse(){
        return course;
    }

}
