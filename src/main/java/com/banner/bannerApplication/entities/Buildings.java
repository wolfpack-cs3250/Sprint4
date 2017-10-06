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
    private String address;

    @Column(unique = true)
    private String acronym;

    public void setId(String id){

        this.id=id;
    }

    public String getbuildingName() {
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

    public String getAcronym() {
        return acronym;
    }

    public void setAcronym(String acronym) {
        this.acronym = acronym;
    }

}