package com.banner.bannerApplication.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RoomsTest {

    private Rooms rooms;

    @Before
    public void setUp(){
        rooms = new Rooms();
        rooms.setRoomSize("123");
        rooms.setRoomNumber("123");
    }

    @Test
    public void getRoomSize() throws Exception {
        Assert.assertEquals("123", rooms.getRoomSize());
    }

    @Test
    public void setRoomSize() throws Exception {
        rooms.setRoomSize("123");
        assertEquals("123", rooms.getRoomSize());
    }

    @Test
    public void getRoomNumber() throws Exception {
        assertEquals("123", rooms.getRoomNumber());
    }

    @Test
    public void setRoomNumber() throws Exception {
        rooms.setRoomNumber("123");
        assertEquals("123", rooms.getRoomNumber());
    }

    @Test
    public void getBuilding() throws Exception {
        Buildings building = new Buildings();
        Buildings buildings2 = building;

        Rooms room = new Rooms();
        room.setBuildings(building);

        assertEquals(buildings2, room.getBuildings());
    }

}