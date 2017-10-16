package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Rooms {

    @ManyToOne
    private Buildings buildings;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = false)
    private String roomSize;

    @Column(unique = true)
    private String roomNumber;

    public Long getId(){
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
    public void setSection(Buildings buildings){
        this.buildings = buildings;
    }
}

