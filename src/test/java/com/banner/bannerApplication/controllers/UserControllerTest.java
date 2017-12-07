package com.banner.bannerApplication.controllers;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
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
        //user1.setFirstName("bob");
        //user1.setLastName("taylor");

        //assertEquals("taylor", user1.getLastName());
    }

    @Test
    public void removeUser() throws Exception {
    }

    @Test
    public void showall() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

}