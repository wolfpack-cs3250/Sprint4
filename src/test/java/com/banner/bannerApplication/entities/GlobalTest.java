package com.banner.bannerApplication.entities;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

/** Test class for the Global object */

public class GlobalTest {

    private static Global global1;

    /** Initial set up of our Global object */
    @Before
    public void setUp(){
        global1 = new Global();
        global1.setId("1");
        global1.setSchoolName("Wolfpack University");
        global1.setFreshmanCredits(32);
        global1.setSophmoreCredits(64);
        global1.setJuniorCredits(96);
        global1.setSeniorCredits(128);
        global1.setCreditsCompleted();
    }

    /** make sure we can set the SchoolName field */
    @Test
    public void setSchoolName() throws Exception {
        global1.setSchoolName("TEST SCHOOL NAME");
        assertEquals("TEST SCHOOL NAME", global1.getSchoolName());
    }

    /** make sure we can set the FreshmanCredits field */
    @Test
    public void setFreshmanCredits() throws Exception {
        global1.setFreshmanCredits(33);
        assertEquals(33,global1.getFreshmanCredits());
    }

    /** make sure we can set the Sophmore credits field */
    @Test
    public void setSophmoreCredits() throws Exception {
        global1.setSophmoreCredits(65);
        assertEquals(65,global1.getSophmoreCredits());
    }

    /** make sure we can set the Junior credits field */
    @Test
    public void setJuniorCredits() throws Exception {
        global1.setJuniorCredits(97);
        assertEquals(97,global1.getJuniorCredits());
    }

    /** make sure we can set the Senior credits field */
    @Test
    public void setSeniorCredits() throws Exception {
        global1.setSeniorCredits(129);
        assertEquals(129,global1.getSeniorCredits());
    }

    /** make sure we can access the SchoolName field */
    @Test
    public void getSchoolName() throws Exception {
        assertEquals("Wolfpack University", global1.getSchoolName());
    }

    /** make sure we can set the FreshmanCredits field */
    @Test
    public void getFreshmanCredits() throws Exception {
        assertEquals(32,global1.getFreshmanCredits());
    }

    /** make sure we can set the SophmoreCredits field */
    @Test
    public void getSophmoreCredits() throws Exception {
        assertEquals(64,global1.getSophmoreCredits());
    }

    /** make sure we can set the JuniorCredits field */
    @Test
    public void getJuniorCredits() throws Exception {
        assertEquals(96,global1.getJuniorCredits());
    }

    /** make sure we can set the SeniorCredits field */
    @Test
    public void getSeniorCredits() throws Exception {
        assertEquals(128,global1.getSeniorCredits());
    }

    @Test
    public void setId() throws Exception{
        Global global = new Global();
        global.setId("1");
        assertEquals("1", global.getId());
    }

    @Test
    public void getId() throws Exception{
        assertEquals("1", global1.getId());
    }

    @Test
    public void setCreditsComplete() throws Exception{
        Global global = new Global();
        global.setCreditsCompleted();
        assertEquals(0,global.getCompletedCredits());
    }
    @Test
    public void getCreditsComplete() throws Exception{
        assertEquals(320,global1.getCompletedCredits());
    }
}