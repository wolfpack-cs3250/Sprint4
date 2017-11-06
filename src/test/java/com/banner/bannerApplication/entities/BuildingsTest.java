package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BuildingsTest {
    private Buildings buildings;
    @Before
    public void setUP(){
        buildings= new Buildings();
        buildings.setAcronym("Belle");
        buildings.setAddress("Fairtytale");
        buildings.setBuildingName("princess");
        //buildings.setRooms();
    }
    @Test
    public void getBuildingName() throws Exception {
    assertEquals("princess",buildings.getBuildingName());
    }

    @Test
    public void setBuildingName() throws Exception {
    buildings.setBuildingName("THUNDERDOME");
    assertEquals("THUNDERDOME",buildings.getBuildingName());
    }
//    @Test
//    public void getRooms() throws Exception {
//    assertEquals();
//    }
//
//    @Test
//    public void setRooms() throws Exception {
//    }

    @Test
    public void getAddress() throws Exception {
    assertEquals("Fairtytale",buildings.getAddress());
    }

    @Test
    public void setAddress() throws Exception {
    buildings.setAddress("Bleach");
    assertEquals("Bleach",buildings.getAddress());
    }

    @Test
    public void getAcronym() throws Exception {
    assertEquals("Belle",buildings.getAcronym());
    }

    @Test
    public void setAcronym() throws Exception {
    buildings.setAcronym("touch");
    assertEquals("touch",buildings.getAcronym());
    }

}