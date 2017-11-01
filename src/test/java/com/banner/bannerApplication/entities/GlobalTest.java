package com.banner.bannerApplication.entities;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class GlobalTest {

    private static Global global1;

    @Before
    public void setUp(){
        global1 = new Global();
        global1.setSchoolName("Wolfpack University");
        global1.setFreshmanCredits(32);
        global1.setSophmoreCredits(64);
        global1.setJuniorCredits(96);
        global1.setSeniorCredits(128);
    }

    @Test
    public void setSchoolName() throws Exception {
        global1.setSchoolName("TEST SCHOOL NAME");
        assertEquals("TEST SCHOOL NAME", global1.getSchoolName());
    }

    @Test
    public void setFreshmanCredits() throws Exception {
        global1.setFreshmanCredits(33);
        assertEquals(33,global1.getFreshmanCredits());
    }

    @Test
    public void setSophomoreCredits() throws Exception {
        global1.setSophmoreCredits(65);
        assertEquals(65,global1.getSophmoreCredits());
    }

    @Test
    public void setJuniorCredits() throws Exception {
        global1.setJuniorCredits(97);
        assertEquals(97,global1.getJuniorCredits());
    }

    @Test
    public void setSeniorCredits() throws Exception {
        global1.setSeniorCredits(129);
        assertEquals(129,global1.getSeniorCredits());
    }

    @Test
    public void getSchoolName() throws Exception {
        assertEquals("Wolfpack University", global1.getSchoolName());
    }

    @Test
    public void getFreshmanCredits() throws Exception {
        assertEquals(32,global1.getFreshmanCredits());
    }

    @Test
    public void getSophomoreCredits() throws Exception {
        assertEquals(64,global1.getSophmoreCredits());
    }

    @Test
    public void getJuniorCredits() throws Exception {
        assertEquals(96,global1.getJuniorCredits());
    }

    @Test
    public void getSeniorCredits() throws Exception {
        assertEquals(128,global1.getSeniorCredits());
    }

}