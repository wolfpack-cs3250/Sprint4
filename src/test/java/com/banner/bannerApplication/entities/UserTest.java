package com.banner.bannerApplication.entities;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.banner.bannerApplication.repositories.UserRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {


    private static User user1;
    @Before
    public void setup(){
        user1 = new User();
        user1.setFirstName("bob");
        user1.setLastName("apple");

    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("bob", user1.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("apple", user1.getLastName());
    }

    @Test
    public void setFirstName() throws Exception {

        user1.setFirstName("first name test");
        assertEquals("first name test", user1.getFirstName());
    }

    @Test
    public void setLastName() throws Exception {
        user1.setLastName("last name test");
        assertEquals("last name test", user1.getLastName());
    }

    @Test
    public void setInProgress() throws Exception {
    }

    @Test
    public void removeInprogress() throws Exception {
    }

    @Test
    public void getDone() throws Exception {
    }

    @Test
    public void getStudentId() throws Exception {
    }

    @Test
    public void getSection() throws Exception {
    }

    @Test
    public void setSection() throws Exception {
    }


}