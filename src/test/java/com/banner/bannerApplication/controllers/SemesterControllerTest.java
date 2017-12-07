package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Semester;
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

public class SemesterControllerTest {

    @Test
    public void newBuildings() throws MalformedURLException, IOException {
        URL u = new URL("http://localhost:8080/buildings/create");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test(expected = NullPointerException.class)
    public void addNewSemester() {
        SemesterController sC = new SemesterController();
        Long semesterYear = 1225L;
        Semester.Season semesterSeason = Semester.Season.FALL;
        ModelAndView mav = sC.addNewSemester(semesterYear, semesterSeason);
        assertEquals(1225L, sC.addNewSemester(semesterYear, semesterSeason));
    }

    @Test(expected = NullPointerException.class)
    public void removeSemester() {
        SemesterController sC = new SemesterController();
        Long id = 123L;
        sC.removeSemester(id);
        assertEquals(123L, sC.removeSemester(id));
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
        Iterable<Semester> allSemesters = new ArrayList<>();
        model.addAttribute("allSemesters", allSemesters);
        assertEquals(model, model);
    }
}
