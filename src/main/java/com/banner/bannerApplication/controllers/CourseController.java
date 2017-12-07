package com.banner.bannerApplication.controllers;

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

/** This is the controller for Courses.
 *  This holds the CRUD operations for Courses.
 * */

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

    /** Create a Course */
    @RequestMapping(method = RequestMethod.POST)
    public void addNewCourse(@RequestParam final long userID,
                             @RequestParam final long courseName) {

        Course course = courseRepository.findOne(courseName);
        if (compDirtyToME(courseName, userID)) {

            chooseSection(userID, courseName);
        }
        else if (course.getPrereqs() == null) {
            chooseSection(userID, courseName);
        }
    }

    public ModelAndView chooseSection(final long userID,
                                      final long courseName) {

        User user = userRepository.findOne(userID);
        user.setInProgress(courseName);
        userRepository.save(user);
        return new ModelAndView("redirect:/student");
    }

    /** Delete a Course */
    @GetMapping(path = "/delete")
    public ModelAndView removeCourse(@RequestParam final Long courseId,
                                     @RequestParam final long id) {

        User user = userRepository.findOne(id);
        user.removeInProgress(courseId);
        return new ModelAndView("redirect:/course");
    }

    /** Read Course */
    @GetMapping(path = "")
    public String showAll(final Model model) {

        Iterable<User> allUser = userRepository.findAll();
        model.addAttribute("UserAll", allUser);
        return "User";
    }

    /** Update Course */
    @GetMapping(path = "/update")
    public ModelAndView updateCourse(@RequestParam final Long id,
                                     @RequestParam final String courseName) {

        Course course = courseRepository.findOne(id);
        course.setCourseName(courseName);
        courseRepository.save(course);
        return new ModelAndView("redirect:/course");
    }
}
