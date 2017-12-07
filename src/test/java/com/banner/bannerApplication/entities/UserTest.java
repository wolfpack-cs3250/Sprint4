package com.banner.bannerApplication.entities;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.banner.bannerApplication.repositories.UserRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** This is the test class for User objects */

public class UserTest {

    private User user;

    /** Initial setup of our User object */
    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setFirstName("Bob");
        user.setLastName("Saget");
    }

    /** make sure we can access the first name of a User object */
    @Test
    public void getFirstName() throws Exception {
        assertEquals("Bob", user.getFirstName());
    }

    /** make sure we can access the last name of a User object */
    @Test
    public void getLastName() throws Exception {
        assertEquals("Saget", user.getLastName());
    }

    /** make sure we can set the first name of a User object */
    @Test
    public void setFirstName() throws Exception {
        user.setFirstName("Dirty");
        assertEquals("Dirty", user.getFirstName());
    }

    /** make sure we can set the last name of a User object */
    @Test
    public void setLastName() throws Exception {
        user.setLastName("Harry");
        assertEquals("Harry", user.getLastName());
    }

    @Test
    public void getId() throws Exception {
    }

}