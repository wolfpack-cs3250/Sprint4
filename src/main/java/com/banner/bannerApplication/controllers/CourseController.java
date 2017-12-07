package com.banner.bannerApplication.controllers;

/*
*   CRUD operations for sprint 3
*
*/

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.CourseRepository;
import com.banner.bannerApplication.repositories.SectionRepository;
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
    private UserRepository userRepository;
    private SectionRepository sectionRepository;

    public boolean compDirtyToME(final long courseID, final long userId) {

        Course course = courseRepository.findOne(courseID);
        User user = userRepository.findOne(userId);
        course.getCoreq();
        String[] check = user.getDone();
        for (int i = 0; i < check.length; i++) {
            if (course.getPrereqs().contains(check[i])) {
                return true;
            }
        }
        return false;

    }
    // Create
    @RequestMapping(method = RequestMethod.POST)
    public void addNewCourse(@RequestParam final long userID,
                             @RequestParam final long coursename) {
        Course course = courseRepository.findOne(coursename);
        if (compDirtyToME(coursename, userID)) {

            chooseSection(userID, coursename);
        }
        else if (course.getPrereqs() == null) {
            chooseSection(userID, coursename);
        }
    }
    public ModelAndView chooseSection(final long userID,
                                      final long coursename) {
        User user = userRepository.findOne(userID);
        user.setInProgress(coursename);
        userRepository.save(user);
        return new ModelAndView("redirect:/student");
    }
    // Delete
    @GetMapping(path = "/delete")
    public ModelAndView removeCourse(@RequestParam final Long courseId,
                                     @RequestParam final long id) {
        User user = userRepository.findOne(id);
        user.removeInProgress(coursename);
        return new ModelAndView("redirect:/course");
    }

    // Read All
    @GetMapping(path = "")
    public String showall(final Model model) {
        Iterable<User> allUser = userRepository.findAll();
        model.addAttribute("UserAll", allUser);
        return "User";
    }


    // Read by id
    // @GetMapping(path="/{id}")


    // UPDATE
    @GetMapping(path = "/update")
    public ModelAndView updateCourse(@RequestParam final Long id,
                                     @RequestParam final String coursename) {

        Course course = courseRepository.findOne(id);
        course.setCourseName(coursename);
        courseRepository.save(course);
        return new ModelAndView("redirect:/course");
    }
}
