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
    public void getCourseName()throws Exception {
        assertEquals("A",course.getCourseName());
    }

    @Test
    public void setCourseName() throws Exception{
        course.setCourseName("Yeah");
        assertEquals("Yeah",course.getCourseName());
    }

}
