package com.banner.bannerApplication.controllers;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Course;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import com.banner.bannerApplication.repositories.UserRepository;
import com.banner.bannerApplication.entities.User;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class UserControllerTest {

    @Mock
    private User user1;
    @Mock
    private UserRepository userRepo1;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewUser() throws Exception {
        user1.setFirstName("marge");
        user1.setLastName("simpson");

        assertEquals("simpson", user1.getLastName());
    }

    @Test
    public void removeUser() throws Exception {
        UserController uC = new UserController();
        long id = 333;
        uC.removeUser(id);
        assertEquals(333, uC.removeUser);
    }

    @Test
    public void showall() throws Exception {
        Model model = new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                attributeName = "Claire";
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
        Iterable<User> allusers = new ArrayList<>();
        model.addAttribute("allusers", allusers);
        assertEquals(model, model);

    }

    @Test
    public void updateUser() throws Exception {
        UserController uC = new UserController();
        long id = 36;
        String firstname = "Merry";
        String lastname = "Christmas";


        ModelAndView mav = uC.addNewUser(firstname, lastname);
        assertEquals("Merry", firstname);
        assertEquals("Christmas", lastname);
        assertEquals("36", id);
    }

}
