package com.banner.bannerApplication.entities;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Position")
public class Position {
private Long id;
private String name;
private Set<User> users;
private Set<Professor> professors;

@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId(){
    return id;
}

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "positions")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "positions")
    public Set<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(Set<Professor> professors) {
        this.professors = professors;
    }
}
