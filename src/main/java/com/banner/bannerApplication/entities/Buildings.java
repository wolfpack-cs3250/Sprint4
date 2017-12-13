package com.banner.bannerApplication.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/** This is the class for Buildings.
 *  A building contains many rooms.
 *  It also contains other basic info,
 *  such as address, and name.
 * */

@Entity
public class Buildings {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique=false)
    private String buildingName;

    @Column(unique = false)
    private String address;

    @Column(unique = false)
    private String acronym;

    @OneToMany(mappedBy = "buildings")
    private Set<Rooms> rooms = new HashSet<>();


    public long getId(){
        return id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {

        this.buildingName = buildingName;
    }
    public Set<Rooms> getRooms() {
        return rooms;
    }
    public void setRooms(Set<Rooms> rooms){
    this.rooms = rooms;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {

        this.address = address;
    }

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

}
