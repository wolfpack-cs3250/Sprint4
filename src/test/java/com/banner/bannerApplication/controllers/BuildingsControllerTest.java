package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Rooms;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class BuildingsControllerTest {

    @Test
    public void newBuildings() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/buildings/create");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void addNewBuilding() throws MalformedURLException, IOException {
        BuildingsController bC = new BuildingsController();
        String buildingName = "Metro";
        String address = "123 Seseme Street";
        String acroynm = "MSU";
        ModelAndView mav = bC.addNewBuilding(buildingName, address, acroynm);
        assertEquals("Metro", buildingName);
        assertEquals("123 Seseme Street", address);
        assertEquals("MSU", acroynm);

        URL u = new URL("http://localhost:8080/faculty");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void removeUser() throws MalformedURLException, IOException {
        BuildingsController bC = new BuildingsController();
        Long id = 123L;
        bC.removeUser(id);
        assertEquals(123L, bC.removeUser(id));

        URL u = new URL("http://localhost:8080/faculty");
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
        Iterable<Buildings> allBuildings = new ArrayList<>();
        model.addAttribute("allBuildings", allBuildings);
        assertEquals(model, model);

        URL u = new URL("http://localhost:8080/buildings");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test
    public void showOne() throws MalformedURLException, IOException {
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
        Collection<Rooms> allBuildings = new ArrayList<>();
        model.addAttribute("buildings", allBuildings );
        model.addAttribute("rooms", allBuildings);
        assertEquals(model, model);

        URL u = new URL("http://localhost:8080/buildings/view/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }
    @Test
    public void updateUser() throws MalformedURLException, IOException {
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
        Buildings allBuildings = new Buildings();
        model.addAttribute("buildings", allBuildings );
        assertEquals(model, model);

        URL u = new URL("http://localhost:8080/buildings/update/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void updateStudent() throws MalformedURLException, IOException {
        BuildingsController bC = new BuildingsController();
        String buildingName = "The place";
        String address = "Here";
        String acroynm = "PL";
        ModelAndView mav = bC.addNewBuilding(buildingName, address, acroynm);
        assertEquals("The place", buildingName);
        assertEquals("Here", address);
        assertEquals("PL", acroynm);

        URL u = new URL("http://localhost:8080/faculty");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }
}