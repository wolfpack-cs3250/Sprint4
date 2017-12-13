package com.banner.bannerApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import java.util.*;

/** This is the class for Users
 *  Users can have many Sections
 *  If they are currently in classes,
 *  their name, etc.
 */

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            joinColumns = { @JoinColumn(name = "USER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "SECTION_ID")}
    )
    private Set<Section> section = new HashSet<Section>();

    /** Column in our database. */
    @Column(unique = false)
    private String firstName;

    /** Column in our database. */
    @Column(unique = false)
    private String lastName;

    //@Column(unique = false)
    //private long completedCredits = 666;

    /** Column in our database. */
    @Column(unique = false)
    private String[] done;

    /** We map a User to a section. */
    @OneToMany(mappedBy = "user")
    private Set<Section> sections = new HashSet<>();

    /** Column in our database. */
    @Column(name = "Registered", nullable = false)
    @ElementCollection(targetClass = long.class)
    private List<Long> inProgess;

    public void setInProgress(long classId) {
        inProgess.add(classId);
    }

    public void removeInProgress(long courseId) {
        inProgess.remove(courseId);
    }

    public Set<Section> getSections(){
        return sections;
    }

    public void setSection(Set<Section> section){
        this.section = section;
    }

    public String[] getDone() {
        return Arrays.copyOf(done, done.length);
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
