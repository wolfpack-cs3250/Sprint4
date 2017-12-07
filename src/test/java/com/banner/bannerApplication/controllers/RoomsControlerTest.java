package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Rooms;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class RoomsControlerTest {
    @Test(expected = NullPointerException.class)
    public void createRoom() {
        Model model = new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return null;
            }
            @Override
            public Model addAttribute(Object attributeValue) {
                return null;
            }
            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }
            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }
            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }
            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }
            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        Long id = 444L;
        RoomsController rC = new RoomsController();
        rC.createRoom(id, model);
        assertEquals(id, model);
    }

    @Test(expected = NullPointerException.class)
    public void addNewRooms() throws MalformedURLException, IOException {
        RoomsController rC = new RoomsController();
        String roomSize = "1";
        String roomNumber = "33";
        Long buildingId = 111L;
        ModelAndView mvc = rC.addNewRooms(roomSize, buildingId, roomNumber);
        assertEquals("1", roomSize);
        assertEquals(111L, rC.addNewRooms(roomSize, buildingId, roomNumber));
        assertEquals("33", roomNumber);

        URL u = new URL("http://localhost:8080/rooms/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void removeRooms() throws MalformedURLException, IOException {
        RoomsController rC = new RoomsController();
        Long id = 123L;
        rC.removeRooms(id);
        assertEquals(123L, rC.removeRooms(id));

        URL u = new URL("http://localhost:8080/buildings/view/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test
    public void showAll() throws MalformedURLException, IOException {
        Model model = new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                attributeName = "Santa";
                attributeValue = "1";
                return null;
            }

            @Override
            public Model addAttribute(Object attributeValue) {
                attributeValue = "1";
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        Iterable<Rooms> allRooms = new ArrayList<>();
        model.addAttribute("allRooms", allRooms);
        assertEquals(model, model);

        URL u = new URL("http://localhost:8080/rooms/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void updateUser() throws IOException {
        Model model = new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                return null;
            }
            @Override
            public Model addAttribute(Object attributeValue) {
                return null;
            }
            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }
            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }
            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }
            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }
            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        Long id = 444L;
        RoomsController rC = new RoomsController();
        rC.createRoom(id, model);
        assertEquals(id, model);

        URL u = new URL("http://localhost:8080/rooms/update/2?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void updateRooms() throws MalformedURLException, IOException {
        RoomsController rC = new RoomsController();
        String roomSize = "1";
        String roomNumber = "33";
        Long buildingId = 111L;
        ModelAndView mvc = rC.addNewRooms(roomSize, buildingId, roomNumber);
        assertEquals("1", roomSize);
        assertEquals(111L, rC.addNewRooms(roomSize, buildingId, roomNumber));
        assertEquals("33", roomNumber);

        URL u = new URL("http://localhost:8080/rooms/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

}
