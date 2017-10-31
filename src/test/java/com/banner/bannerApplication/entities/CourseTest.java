package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class CourseTest {
    private Course course;
    @Before
    public void setUp(){
        course= new Course();
        course.setPrereqs("A");
        course.setCoreq("B");
        course.setCredits(4);
        course.setNumber("245G");
        course.setLearningObjective("doe");
        course.setCourseName("DEER");
        course.setDepartment("femalDEER");
        course.setDescription("Ray");

    }
    @Test
    public void getCoreq() throws Exception{
    assertEquals("B",course.getCoreq());
    }

    @Test
    public void setCoreq() throws Exception {
    course.setCoreq("CS");
    assertEquals("CS", course.getCoreq());
    }

    @Test
    public void getPrereqs()throws Exception {
    assertEquals("A", course.getPrereqs());
    }

    @Test
    public void setPrereqs() throws Exception{
        course.setPrereqs("cs2");
        assertEquals("cs2",course.getPrereqs());
    }

    @Test
    public void getLearningObjective() throws Exception{
        assertEquals("doe",course.getLearningObjective());
    }

    @Test
    public void setLearningObjective() throws Exception{
    course.setLearningObjective("lose");
    assertEquals("lose",course.getLearningObjective());
    }

    @Test
    public void getDescription() throws Exception{
    assertEquals("Ray",course.getDescription());
    }

    @Test
    public void setDescription() throws Exception{
        course.setDescription("description");
        assertEquals("description",course.getDescription());
    }

    @Test
    public void getCredits() throws Exception{
        assertEquals(4,course.getCredits());
    }

    @Test
    public void setCredits() throws Exception{
        course.setCredits(22);
        assertEquals(22,course.getCredits());
    }

    @Test
    public void getNumber() throws Exception{
        assertEquals("245G",course.getNumber());
    }

    @Test
    public void setNumber() throws Exception{
        course.setNumber("234x");
        assertEquals("234x",course.getNumber());
    }

    @Test
    public void getDepartment() throws Exception {
        assertEquals("femalDEER",course.getDepartment());
    }

    @Test
    public void setDepartment() throws Exception{
        course.setDepartment("nope");
        assertEquals("nope",course.getDepartment());
    }

    @Test
    public void getCourseName() throws Exception{
        assertEquals("DEER",course.getCourseName());
    }

    @Test
    public void setCourseName() throws Exception{
        course.setCourseName("tested");
        assertEquals("tested",course.getCourseName());
    }

}