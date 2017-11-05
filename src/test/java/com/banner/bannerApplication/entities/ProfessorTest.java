package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProfessorTest {

    private static Professor professor1;

    @Before
    public void setup(){
        professor1 = new Professor();
        professor1.setFirstName("bob");
        professor1.setLastName("apple");

    }

    @Test
    public void getFirstName() throws Exception {
        assertEquals("bob", professor1.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception {
        professor1.setFirstName("first name test");
        assertEquals("first name test", professor1.getFirstName());
    }

    @Test
    public void getLastName() throws Exception {
        assertEquals("apple", professor1.getLastName());
    }

    @Test
    public void setLastName() throws Exception {
        professor1.setLastName("last name test");
        assertEquals("last name test", professor1.getLastName());
    }

}