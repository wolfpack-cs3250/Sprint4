package com.banner.bannerApplication.controllers;

/*
*   CRUD operations for sprint 3
*
*/

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.CourseRepository;
import com.banner.bannerApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewCourse (@RequestParam String coursename) {
        Course n = new Course();
        n.setCourseName(coursename);
        courseRepository.save(n);
        return new ModelAndView("redirect:/course");
    }

    // Delete
    @GetMapping(path="/delete")
    public ModelAndView RemoveCourse(@RequestParam String id) {
        Course n = new Course();
        n.setId(id);
        courseRepository.delete(id);
        return new ModelAndView("redirect:/course");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Course> allcourses = courseRepository.findAll();
        model.addAttribute("allcourses", allcourses);
        return "coursepage";
    }


    // Read by id
//    @GetMapping(path="/{id}")

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateCourse(@RequestParam String id,
                                           @RequestParam String coursename) {
        // Needs Error Checking!!
        Course course = courseRepository.findOne(id);

        course.setCourseName(coursename);
        courseRepository.save(course);
        return new ModelAndView("redirect:/course");


    }

}
