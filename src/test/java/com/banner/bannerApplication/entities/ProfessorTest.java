package com.banner.bannerApplication.entities;

import com.sun.scenario.effect.impl.prism.PrFilterContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class ProfessorTest {
    private Professor professor;
    @Before
    public void setUP(){
        professor=new Professor();
        professor.setFirstName("anakin");
        professor.setLastName("Skywalker");
    }

    @Test
    public void getFirstName() throws Exception{
        assertEquals("anakin",professor.getFirstName());
    }

    @Test
    public void setFirstName() throws Exception{
        professor.setFirstName("jake");
        assertEquals("jake",professor.getFirstName());
    }

    @Test
    public void getLastName() throws Exception{
        assertEquals("Skywalker",professor.getLastName());
    }

    @Test
    public void setLastName() throws Exception{
        professor.setLastName("anakinBleack");
        assertEquals("anakinBleack",professor.getLastName());
    }

}