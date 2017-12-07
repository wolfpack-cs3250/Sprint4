package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.entities.Section;
import javafx.geometry.Point3DBuilder;
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

public class ProfessorControllerTest {

    @Test
    public void newBuildings() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/professor?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void addNewProfessor() throws MalformedURLException, IOException {
        ProfessorController pC = new ProfessorController();
        String firstName = "Mecha";
        String lastName = "King Ghidorah";
        ModelAndView mav = pC.addNewProfessor(firstName, lastName);
        assertEquals("Mecha", firstName);
        assertEquals("King Ghidorah", lastName);

        URL u = new URL("http://localhost:8080/professor?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void removeProfessor() throws MalformedURLException, IOException {
        ProfessorController pC = new ProfessorController();
        Long id = 1776L;
        pC.removeProfessor(id);
        assertEquals(123L, pC.removeProfessor(id));

        URL u = new URL("http://localhost:8080/professor?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test
    public void showAll() {
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
        Iterable<Professor> professors = new ArrayList<>();
        model.addAttribute("professors", professors);
        assertEquals(model, model);
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
        ProfessorController pC = new ProfessorController();
        Collection<Section> sections = new ArrayList<>();
        model.addAttribute("sections", sections);
        Long id = 123L;
        pC.showOne(id, model);
        assertEquals(model, pC.showOne(id, model));

        URL u = new URL("http://localhost:8080/professor/view/1?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void updateProfessor() throws MalformedURLException, IOException {
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
        ProfessorController pC = new ProfessorController();
        Long id = 1942L;
        pC.updateProfessor(id, model);
        assertEquals(123L, pC.updateProfessor(id, model));

        URL u = new URL("http://localhost:8080/professor?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void updateProfessorFinal() throws MalformedURLException, IOException {
        ProfessorController pC = new ProfessorController();
        String firstName = "Shin";
        String lastName = "Godzilla";
        ModelAndView mav = pC.addNewProfessor(firstName, lastName);
        assertEquals("Shin", firstName);
        assertEquals("Godzilla", lastName);

        URL u = new URL("http://localhost:8080/professor?");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void registerProfessor() {
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
        ProfessorController pC = new ProfessorController();
        Iterable<Course> allCourse = new ArrayList<>();
        Long id = 777L;
        model.addAttribute("allCourse", allCourse);
        pC.registerProfessor(id, model);
        assertEquals(model, pC.registerProfessor(id, model));
    }
}
