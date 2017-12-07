package com.banner.bannerApplication.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static jdk.nashorn.internal.runtime.Debug.id;
import static org.junit.Assert.*;

/** Test class for Course objects */

public class CourseTest {

    private Section section;
    private Course course;

    /** Initial set up for our Course object */
    @Before
    public void setUp(){
        course= new Course();
        course.setCourseId((long) 1234);
        course.setPrereqs("A");
        course.setCoreq("B");
        course.setCredits(4);
        course.setNumber("245G");
        course.setLearningObjective("doe");
        course.setCourseName("DEER");
        course.setDepartment("femalDEER");
        course.setDescription("Ray");
        section = new Section();

    }

    /** make sure we can access the coreqs of the Course object */
    @Test
    public void getCoreq() throws Exception{
    assertEquals("B",course.getCoreq());
    }

    /** make sure we can set the coreq field of the Course object */
    @Test
    public void setCoreq() throws Exception {
    course.setCoreq("CS");
    assertEquals("CS", course.getCoreq());
    }

    /** make sure we can access the prereqs of the Course object */
    @Test
    public void getPrereqs()throws Exception {
    assertEquals("A", course.getPrereqs());
    }

    /** make sure we can set the prereq field of the Course object */
    @Test
    public void setPrereqs() throws Exception{
        course.setPrereqs("cs2");
        assertEquals("cs2",course.getPrereqs());
    }

    /** make sure we can access the Learning Objective field of the Course */
    @Test
    public void getLearningObjective() throws Exception{
        assertEquals("doe",course.getLearningObjective());
    }

    /** make sure we can set the Learning Objective field */
    @Test
    public void setLearningObjective() throws Exception{
    course.setLearningObjective("lose");
    assertEquals("lose",course.getLearningObjective());
    }

    /** make sure we can access the description field */
    @Test
    public void getDescription() throws Exception{
    assertEquals("Ray",course.getDescription());
    }

    /** make sure we can set the description field */
    @Test
    public void setDescription() throws Exception{
        course.setDescription("description");
        assertEquals("description",course.getDescription());
    }

    /** make sure we can access the Credits field */
    @Test
    public void getCredits() throws Exception{
        assertEquals(4,course.getCredits());
    }

    /** make sure we can set the Credits field */
    @Test
    public void setCredits() throws Exception{
        course.setCredits(22);
        assertEquals(22,course.getCredits());
    }

    /** make sure we can access the Numbers field */
    @Test
    public void getNumber() throws Exception{
        assertEquals("245G",course.getNumber());
    }

    /** make sure we can set the Numbers field */
    @Test
    public void setNumber() throws Exception{
        course.setNumber("234x");
        assertEquals("234x",course.getNumber());
    }

    /** make sure we can access the Department field */
    @Test
    public void getDepartment() throws Exception {
        assertEquals("femalDEER",course.getDepartment());
    }

    /** make sure we can set the Department field */
    @Test
    public void setDepartment() throws Exception{
        course.setDepartment("nope");
        assertEquals("nope",course.getDepartment());
    }

    /** make sure we can access the CourseName field */
    @Test
    public void getCourseName() throws Exception{
        assertEquals("DEER",course.getCourseName());
    }

    /** make sure we can set the CourseName field */
    @Test
    public void setCourseName() throws Exception{
        course.setCourseName("tested");
        assertEquals("tested",course.getCourseName());
    }

    @Test
    public void getCourseId()throws Exception{
        assertEquals(1234, course.getCourseId());
    }
}