package com.banner.bannerApplication.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/** This is the class fo Professors.
 *  A professor can have many sections.
 *  Also has a first and last name.
 */

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique=true)
    private long id;

    @OneToMany(mappedBy = "professor")
    private Set<Section> sections = new HashSet<>();

    @Column(unique = false)
    private String firstName;

    @Column(unique = false)
    private String lastName;
<<<<<<< Updated upstream
    private Set<Position> positions;

    public Set<Position> getPositions() {
        return positions;
    }

    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    private String Username;
=======
    @NotNull
    private String password;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

>>>>>>> Stashed changes

    public Professor(){
    }
<<<<<<< Updated upstream
    public Professor(String firstName,String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
    }

    @NotNull
    private String password;
=======
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
>>>>>>> Stashed changes

    private String Username;
    public Set<Section> getSections(){
        return sections;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
