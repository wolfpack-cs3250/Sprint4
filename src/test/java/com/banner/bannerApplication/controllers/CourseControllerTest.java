package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.repositories.CourseRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;

import static org.junit.Assert.*;
    public class CourseControllerTest {
        @Rule
        public ExpectedException thrown= ExpectedException.none();
        @Mock
        private CourseRepository courseRepository;

        @Test
        public void compDirtyToME() throws Exception {
        }

        @Test
        public void addNewCourse() throws Exception {
            CourseController courseController= new CourseController();
        }

        @Test
        public void chooseSection() throws Exception {
            CourseController courseController= new CourseController();
        }

        @Test
        public void removeCourse() throws Exception {
            CourseController courseController= new CourseController();

        }

        @Test
        public void showall() throws Exception {
            CourseController courseController= new CourseController();
        }

        @Test
        public void updateCourse() throws Exception {
            CourseController courseController= new CourseController();
        }

        @Test
        public void CourseNullShouldThrowException() throws Exception{
            this.thrown.expect(IllegalArgumentException.class);
            this.thrown.expectMessage("This Cannot be Empty");
            new Course(null,"a","b",4,"c","d","e","f");
            new Course("a",null,"b",4,"c","d","e","f");
            new Course("a","a",null,4,"c","d","e","f");
            new Course("a","a","b",100,"c","d","e","f");
            new Course("a","a","b",4,null,"d","e","f");
            new Course("a","a","b",4,"c",null,"e","f");
        }
    }
