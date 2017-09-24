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

    private String id;

    private String firstName;
    private String lastName;
    private String sectionNumber;


    public Section() {

    }

    public void getId (String id) {
        this.id=id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    Section n = new Section;

    public void setSectionNumber(String sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

}
