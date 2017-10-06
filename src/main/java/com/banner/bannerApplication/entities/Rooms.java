package com.banner.bannerApplication.entities;

import javax.persistence.*;

@Entity
public class Rooms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String roomSize;

    @Column(unique = true)
    private String roomNumber;

    public void setId(String id) {

        this.id = id;
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

}

