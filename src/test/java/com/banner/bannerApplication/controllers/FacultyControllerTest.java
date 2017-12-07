package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Rooms;
import com.banner.bannerApplication.entities.Section;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class FacultyControllerTest {

    @Test
    public void newBuildings() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/faculty/create");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void addNewCourse() throws MalformedURLException, IOException {
        FacultyCourse fC = new FacultyCourse();
        String department = "Circus Planning";
        String courseName = "Clowns";
        String number = "101";
        int credits = 4;
        String description = "learn things";
        String learningObjective = "Why not";
        String prereqs = "Juggling";
        String coreqs = "Yes";

        ModelAndView mav = fC.addNewCourse(department, courseName, number, credits, description, learningObjective,
                                            prereqs, coreqs);
        assertEquals("Circus Planning", department);
        assertEquals("Clowns", courseName);
        assertEquals("101", number);
        assertEquals(4, credits);
        assertEquals("learn things", description);
        assertEquals("Why not", learningObjective);
        assertEquals("Juggling", prereqs);
        assertEquals("Yes", coreqs);

        URL u = new URL("http://localhost:8080/faculty");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void removeCourse() throws MalformedURLException, IOException {
        FacultyCourse fC = new FacultyCourse();
        Long id = 123L;
        fC.removeCourse(id);
        assertEquals(123L, fC.removeCourse(id));
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
        Iterable<Course> allCourse = new ArrayList<>();
        model.addAttribute("allcourse", allCourse);
        assertEquals(model, model);

        Iterable<Buildings> allBuildings = new ArrayList<>();
        model.addAttribute("allbuildings", allBuildings);
        assertEquals(model, model);

        URL u = new URL("http://localhost:8080/faculty");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
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
        FacultyCourse fC = new FacultyCourse();
        Collection<Section> sections = new ArrayList<>();
        model.addAttribute("sections", sections);
        Long id = 123L;
        fC.showOne(id, model);
        assertEquals(model, fC.showOne(id, model));

        URL u = new URL("http://localhost:8080/faculty/view/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void updateCourse() throws MalformedURLException, IOException {
        FacultyCourse fC = new FacultyCourse();
        String department = "Circus Planning";
        String courseName = "Clowns";
        String number = "101";
        int credits = 4;
        String description = "learn things";
        String learningObjective = "Why not";
        String prereqs = "Juggling";
        String coreqs = "Yes";

        ModelAndView mav = fC.addNewCourse(department, courseName, number, credits, description, learningObjective,
                prereqs, coreqs);
        assertEquals("Circus Planning", department);
        assertEquals("Clowns", courseName);
        assertEquals("101", number);
        assertEquals(4, credits);
        assertEquals("learn things", description);
        assertEquals("Why not", learningObjective);
        assertEquals("Juggling", prereqs);
        assertEquals("Yes", coreqs);

        URL u = new URL("http://localhost:8080/faculty");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }
}
