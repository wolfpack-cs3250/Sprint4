package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.UserRepository;
import org.junit.Test;
import static org.junit.Assert.*;

public class SectionControllerTest {

    @Mock
    private Section section1;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addNewSection()throws Exception {
        SectionController sC = new SectionController();
        long courseId = 1;
        long sectionNumber = 1;
        long professorId = 1;
        long roomId = 3;
        String startDate = "08/30/2017";
        String endDate = "12/01/2017";
        String startTime = "8 AM";
        String endTime = "10 AM";
        String classDate = "TuTh";

        ModelAndView mav = sC.addSection(courseId, sectionNumber, professorId, roomId, startDate, endDate,
                startTime, endTime, classDate);
        assertEquals(1, courseId);
        assertEquals(1, sectionNumber);
        assertEquals(1, professorId);
        assertEquals(3, roomId);
        assertEquals("08/30/2017", startDate);
        assertEquals("12/01/2017", endDate);
        assertEquals("8 AM", startTime);
        assertEquals("10 AM", endTime);
        assertEquals("TuTh", classDate);
    }

    @Test
    public void removeSection() throws Exception{
        SectionController sC = new SectionController();
        long id = 1;
        sC.removeSection(id);
        assertEquals(1, sC.removeSection(id));
    }

    @Test
    public void showall()throws Exception {
        Model model = new Model() {
            @Override
            public Model addAttribute(String attributeName, Object attributeValue) {
                attributeName = "Mike";
                attributeValue = "1";
                return null;
            }

            @Override
            public Model addAttribute(Object attributeValue) {
                attributeValue = "1";
                return null;
            }

            @Override
            public Model addAllAttributes(Collection<?> attributeValues) {
                return null;
            }

            @Override
            public Model addAllAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public Model mergeAttributes(Map<String, ?> attributes) {
                return null;
            }

            @Override
            public boolean containsAttribute(String attributeName) {
                return false;
            }

            @Override
            public Map<String, Object> asMap() {
                return null;
            }
        };
        Iterable<Section> allsections = new ArrayList<>();
        model.addAttribute("allsections", allsections);
        assertEquals(model, model);

    }

    @Test
    public void updateSection()throws Exception {
        SectionController sC = new SectionController();
        long courseId = 1;
        long sectionNumber = 1;
        long professorId = 1;
        long roomId = 3;
        String startDate = "08/30/2017";
        String endDate = "12/01/2017";
        String startTime = "8 AM";
        String endTime = "10 AM";
        String classDate = "TuTh";

        ModelAndView mav = sC.addSection(courseId, sectionNumber, professorId, roomId, startDate, endDate,
                startTime, endTime, classDate);
        assertEquals(1, courseId);
        assertEquals(1, sectionNumber);
        assertEquals(1, professorId);
        assertEquals(3, roomId);
        assertEquals("08/30/2017", startDate);
        assertEquals("12/01/2017", endDate);
        assertEquals("8 AM", startTime);
        assertEquals("10 AM", endTime);
        assertEquals("TuTh", classDate);
    }

}
