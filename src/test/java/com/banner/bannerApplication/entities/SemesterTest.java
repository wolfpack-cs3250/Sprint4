package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** This is the test class for Semester objects */

public class SemesterTest {

    private Semester semesObj;

    /** performs our initial setup of our Semester object */
    @Before
    public void setUp(){
        semesObj = new Semester();
    }

    /** make sure we can access the semester objects year */
    @Test
    public void getSemesterYear() throws Exception {
        semesObj.setSemesterYear(1999);
        assertEquals(1999,semesObj.getSemesterYear());
    }

    /** make sure we can access the semester objects season */
    @Test
    public void getSemesterSeason() throws Exception {
        semesObj.setSemesterSeason(Semester.Season.FALL);
        assertEquals("FALL",semesObj.getSemesterSeason());
    }

    /** make sure we can set the semester objects year */
    @Test
    public void setSemesterYear() throws Exception {
        semesObj.setSemesterYear(2017);
        assertEquals(2017,semesObj.getSemesterYear());
    }

    /** make sure we can set the semester objects season */
    @Test
    public void setSemesterSeason() throws Exception {
        semesObj.setSemesterSeason(Semester.Season.SPRING);
        assertEquals("SPRING",semesObj.getSemesterSeason());
    }

    /** make sure we can get the semester object as a string */
    @Test
    public void getSemesterString() throws Exception {
        semesObj.setSemesterSeason(Semester.Season.SUMMER);
        semesObj.setSemesterYear(1984);
        assertEquals("SUMMER 1984",semesObj.getSemesterString());
    }

}