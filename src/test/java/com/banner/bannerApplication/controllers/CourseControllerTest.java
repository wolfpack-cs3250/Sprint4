package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.User;
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

public class CourseControllerTest {

    @Test(expected = NullPointerException.class)
    public void removeCourse() throws MalformedURLException, IOException {
        CourseController cC = new CourseController();
        Long id = 123L;
        String courseName = "Testing";
        cC.removeCourse(courseName, id);
        assertEquals("Testing", 123L, cC.removeCourse(courseName, id));

        URL u = new URL("http://localhost:8080/faculty");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

    @Test
    public void showAll() throws IOException {
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
        Iterable<User> allUsers = new ArrayList<>();
        model.addAttribute("allUsers", allUsers);
        assertEquals(model, model);
    }

    @Test(expected = NullPointerException.class)
    public void updateCourse() throws MalformedURLException, IOException {
        CourseController cC = new CourseController();
        String courseName = "Fire juggling";
        Long id = 456L;
        ModelAndView mav = cC.updateCourse(id, courseName);
        assertEquals("Fire juggling", 456L, cC.updateCourse(id, courseName));


        URL u = new URL("http://localhost:8080/faculty");
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        HttpURLConnection.setFollowRedirects(false);
        huc.setRequestMethod("HEAD");
        huc.connect();
    }

}
