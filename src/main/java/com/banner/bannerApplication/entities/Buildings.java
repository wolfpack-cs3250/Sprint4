package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Buildings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(unique=true)
    private String buildingName;

    @Column(unique = true)
    private String roomNumber;

    @Column(unique = true)
    private String roomSize;

    public void setId(String id){

        this.id=id;
    }

    public String getbuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {

        this.buildingName = buildingName;
    }

    public String getRoomNumber() {

        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {

        this.roomNumber = roomNumber;
    }

    public String getRoomSize() {
        return roomSize;
    }

    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }

}