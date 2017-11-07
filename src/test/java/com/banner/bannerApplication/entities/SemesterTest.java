package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SemesterTest {

    private Semester semesObj;

    @Before
    public void setUp(){
        semesObj = new Semester();
    }

    @Test
    public void getSemesterYear() throws Exception {
        semesObj.setSemesterYear(1999);
        assertEquals(1999,semesObj.getSemesterYear());
    }

    @Test
    public void getSemesterSeason() throws Exception {
        semesObj.setSemesterSeason(Semester.Season.FALL);
        assertEquals("FALL",semesObj.getSemesterSeason());
    }

    @Test
    public void setSemesterYear() throws Exception {
        semesObj.setSemesterYear(2017);
        assertEquals(2017,semesObj.getSemesterYear());
    }

    @Test
    public void setSemesterSeason() throws Exception {
        semesObj.setSemesterSeason(Semester.Season.SPRING);
        assertEquals("SPRING",semesObj.getSemesterSeason());
    }

    @Test
    public void getSemesterString() throws Exception {
        semesObj.setSemesterSeason(Semester.Season.SUMMER);
        semesObj.setSemesterYear(1984);
        assertEquals("SUMMER 1984",semesObj.getSemesterString());
    }

}