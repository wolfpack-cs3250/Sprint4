package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserControllerTest {

    private static User user1;
    @Before
    public void setup() {
        user1 = new User();
        user1.setLastName("bob");
        user1.setFirstName("apple");
    }

    @Test
    public void createStudent() throws Exception {
    }

    @Test
    public void addNewUser() throws Exception {
        assertEquals("bob", user1.getLastName());
        assertEquals("apple", user1.getFirstName());
    }

    @Test
    public void removeUser() throws Exception {
    }

    @Test
    public void showall() throws Exception {
    }

    @Test
    public void showOne() throws Exception {
    }

    @Test
    public void updateUser() throws Exception {
    }

    @Test
    public void updateStudent() throws Exception {
    }

    @Test
    public void registerStudent() throws Exception {
    }

    @Test
    public void registerStudent1() throws Exception {
    }

}