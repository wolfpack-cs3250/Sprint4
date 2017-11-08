package com.banner.bannerApplication.entities;

import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Section;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "student_id", unique = true)
    private Long id;

    @ManyToOne
    private Section section;

    @Column(unique = false)
    private String firstName;

    @Column(unique = false)
    private String lastName;

    @NotNull
    private String password;
    private String Username;
    private String passwordConfirm;
    private Set<Position> positions;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }



    //@Column(unique = false)
    //private long completedCredits = 666;

    @Column(unique = true)
    private String[] done;

    @Column(name="Registered", nullable = false)
    @ElementCollection(targetClass = long.class)
    private List<Long> inProgess;

    public void setInProgress(long classId) {
        inProgess.add(classId);
    }

    public void removeInprgoress(String classname) {
        inProgess.remove(classname);
    }

    public String[] getDone() {
        return Arrays.copyOf(done, done.length);
    }

    public Long getStudentId() {
        return id;
    }

    public Section getSection() {
        return section;
    }
    public void setSection(Section section){
        this.section = section;
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
    public void setPassword(String password){this.password=password;}
    public String getPassword(){return password;}

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name="user_position", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "position_id"))
    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }
}
