package com.banner.bannerApplication.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String roomSize;

    @Column(unique = true)
    private String roomNumber;

    @ManyToOne
    private Buildings buildings;

    @OneToMany(mappedBy = "room")
    private Set<Section> sections = new HashSet<>();


    public long getId(){
        return id;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {

        this.roomSize = roomSize;
    }

    public String getRoomNumber() {

        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {

        this.roomNumber = roomNumber;
    }
    public Buildings getBuildings() {
        return buildings;
    }
    public void setBuildings(Buildings building){
        this.buildings = building;
    }

    public Set<Section> getSections(){
        return sections;
    }
    public void setSections(Set<Section> sections){
        this.sections = sections;
    }

}

