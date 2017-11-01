package com.banner.bannerApplication.entities;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.banner.bannerApplication.repositories.UserRepository;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private static User user1;

    @Before
    public void setUp() throws Exception {
        //user1 = mock(User.class);
        user1 = new User();
        //assertNotNull(user1);
        //user1.setFirstName("bob");
        //user1.setLastName("taylor");
    }

    @Test
    public void setId() throws Exception {

    }

    @Test
    public void setFirstName() throws Exception {
        //user1.setFirstName("bob");
        //assertEquals("bob", user1.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        user1.setLastName("taylor");
        assertEquals("taylor", user1.getLastName());
    }

    @Test
    public void getFirstName() throws Exception {
        //user1.setFirstName("bob");
        //assertEquals("bob", user1.getLastName());
    }

    @Test
    public void getLastName() throws Exception {
        user1.setLastName("taylor");
        assertEquals("taylor", user1.getLastName());
    }

}