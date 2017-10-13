package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Buildings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique=true)
    private String buildingName;

    @Column(unique = true)
    private String address;

    @Column(unique = true)
    private String acronym;

    @OneToMany
    private Rooms rooms;

    public Long getId(){
        return id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {

        this.buildingName = buildingName;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public Rooms getRooms() {
        return rooms;
    }
    public void setRooms(Rooms rooms){
        this.rooms = rooms;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

}