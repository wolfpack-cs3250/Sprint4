package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SectionTest {
    private Course course;
    private Section section;

    @Before
    public void setUp(){
        course = new Course();
        section = new Section();
        course.setCourseName("A");
        course.setCourseId(1);

       section.setSectionNumber(1);
    }
        
    @Test
    public void getCourseId()throws Exception {
    assertEquals(1, course.getCourseId());
    }

    @Test
    public void setCourseId()throws Exception {
        course.setCourseId(2);
        assertEquals(2,course.getCourseId());
    }

    @Test
    public void getCourseName()throws Exception {
        assertEquals("A",course.getCourseName());
    }

    @Test
    public void setCourseName() throws Exception{
        course.setCourseName("Yeah");
        assertEquals("Yeah",course.getCourseName());
    }

    @Test
    public void getSectionNumber() throws Exception {
        int aLong = 1;
        assertEquals(1, section.getSectionNumber(aLong));
    }

    @Test
    public void setSectionNumber() throws Exception {
        int aLong = 1;
        section.setSectionNumber(3);
        assertEquals(3, section.getSectionNumber(aLong));
    }

}
