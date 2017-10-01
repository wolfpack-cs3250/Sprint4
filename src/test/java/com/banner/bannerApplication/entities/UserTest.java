package com.banner.bannerApplication.entities;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.banner.bannerApplication.repositories.UserRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private static User user1;
    private static User user2;
    private static UserRepository userRepo1;
    private static UserRepository userRepo2;

    @Before
    public void setUp() throws Exception {
        user1 = mock(User.class);
        userRepo1 = mock(UserRepository.class);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMockCreation(){
        assertNotNull(user1);
        assertNotNull(userRepo1);
    }

    @Test
    public void setId() throws Exception {

    }

    @Test
    public void getFirstName() throws Exception {
    }

    @Test
    public void setFirstName() throws Exception {
    }

    @Test
    public void getLastName() throws Exception {
    }

    @Test
    public void setLastName() throws Exception {
    }

}