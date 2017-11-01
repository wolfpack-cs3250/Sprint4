package com.banner.bannerApplication.entities;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RoomsTest {

    Rooms rooms;
    Buildings buildings;
    Section sections;

    @Before
    public void setUp() throws Exception {
        rooms = new Rooms();
    }

    @Test
    public void getIdTest() throws Exception {
        Rooms rooms1 = new Rooms();
        assertEquals(rooms1.getId(), "");
    }

    @Test
    public void getRoomSizeTest() throws Exception {
        assertEquals(10, rooms.getRoomSize());
    }

    @Test
    public void setRoomSizeTest() throws Exception {
        rooms.setRoomSize("7");
        assertEquals(rooms.getRoomSize(), "7");
    }

    @Test
    public void getRoomNumberTest() throws Exception {
        assertEquals("20", rooms.getRoomNumber());
    }

    @Test
    public void setRoomNumber() throws Exception {
        rooms.setRoomNumber("18");
        assertEquals(rooms.getRoomNumber(), "18");
    }

    @Test
    public void getBuildings() throws Exception {
        assertEquals("Math Building", buildings.getBuildingName());
    }

    @Test
    public void setBuildings() throws Exception {
        buildings.setBuildingName("Science Building");
        assertEquals(buildings.getBuildingName(), "Science Building");
    }

    @Test
    public void getSection() throws Exception {
        assertEquals("CS3250", sections.getSectionNumber());
    }

    @Test
    public void setSection() throws Exception {
        sections.setSectionNumber("CS3600");
        assertEquals(sections.getSectionNumber(), "CS3600");
    }

}