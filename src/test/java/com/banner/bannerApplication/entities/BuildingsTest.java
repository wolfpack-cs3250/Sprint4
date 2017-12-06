package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** Test class for the Buildings object */

public class BuildingsTest {

    private Buildings buildings;

    /** Initial setup of our Building object */
    @Before
    public void setUP(){
        buildings= new Buildings();
        buildings.setAcronym("Belle");
        buildings.setAddress("Fairtytale");
        buildings.setBuildingName("princess");
    }

    /** make sure we can access the Building objects name */
    @Test
    public void getBuildingName() throws Exception {
    assertEquals("princess",buildings.getBuildingName());
    }

    /** make sure we can set the Building objects name */
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

    /** make sure we can get the address of the Building object */
    @Test
    public void getAddress() throws Exception {
    assertEquals("Fairtytale",buildings.getAddress());
    }

    /** make sure we can set the address of the Building object */
    @Test
    public void setAddress() throws Exception {
    buildings.setAddress("Bleach");
    assertEquals("Bleach",buildings.getAddress());
    }

    /** make sure that we can access the Building objects acronym */
    @Test
    public void getAcronym() throws Exception {
    assertEquals("Belle",buildings.getAcronym());
    }

    /** make sure we can set the Building objects acronym */
    @Test
    public void setAcronym() throws Exception {
    buildings.setAcronym("touch");
    assertEquals("touch",buildings.getAcronym());
    }

}