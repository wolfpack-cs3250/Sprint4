package com.banner.bannerApplication.entities;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/** This is the test class for Section objects */

public class SectionTest {

    private Course course;
    private Section section;

    /** performs our initial set up of our Section object */
    @Before
    public void setUp(){
        Long sectionNum = new Long(1);
        course = new Course();
        section = new Section();
        course.setCourseName("CS3250");
        section.setSectionNumber(sectionNum);
    }

    /** Make sure we can access the Section objects course name */
    @Test
    public void getCourseName()throws Exception {
        assertEquals("CS3250",course.getCourseName());
    }

    /** Make sure we can set/change the courses name */
    @Test
    public void setCourseName() throws Exception{
        course.setCourseName("CS1050");
        assertEquals("CS1050",course.getCourseName());
    }

}
