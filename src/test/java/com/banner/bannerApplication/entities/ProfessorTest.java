package com.banner.bannerApplication.entities;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/** This is the test class for Professor objects */

public class ProfessorTest {

    private Professor professor;
    private Section section;

    /** Performs our initial set up of our Professor object */
    @Before
    public void setUP(){
        professor=new Professor();
        professor.setFirstName("anakin");
        professor.setLastName("Skywalker");
    }

    @Test
    public void testProfessor() throws Exception{
        Professor professor = new Professor("Bruce", "Wayne");
        assertEquals("Bruce", professor.getFirstName());
        assertEquals("Wayne", professor.getLastName());

    }
    /** try to get the professors first name */
    @Test
    public void getFirstName() throws Exception{
        assertEquals("anakin",professor.getFirstName());
    }

    /** try to set the professors first name */
    @Test
    public void setFirstName() throws Exception{
        professor.setFirstName("jake");
        assertEquals("jake",professor.getFirstName());
    }

    /** try to get the professors last name */
    @Test
    public void getLastName() throws Exception{
        assertEquals("Skywalker",professor.getLastName());
    }

    /** try to set the professors last name */
    @Test
    public void setLastName() throws Exception{
        professor.setLastName("anakinBleack");
        assertEquals("anakinBleack",professor.getLastName());
    }

}