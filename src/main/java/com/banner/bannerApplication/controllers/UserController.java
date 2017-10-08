package com.banner.bannerApplication.controllers;

/*
*   Here will lie all of the CRUD operations for Sprint2
*   - Sal
*
*/

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.UserRepository;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.repositories.CourseRepository;

import javax.persistence.GeneratedValue;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewUser (@RequestParam String firstname,
                                            @RequestParam String lastname) {
        User n = new User();
        n.setFirstName(firstname);
        n.setLastName(lastname);
        n.setCourse(null);
        userRepository.save(n);
        return new ModelAndView("redirect:/user");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView RemoveUser(@PathVariable Long id) {
        userRepository.delete(id);
        return new ModelAndView("redirect:/user");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<User> allusers = userRepository.findAll();
        model.addAttribute("allusers", allusers);
        return "userpage";
    }

    // View One User
    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        User user = userRepository.findOne(id);

        try {
            Course course = courseRepository.findOne(user.getCourse().getCourseId());
            String courseName = course.getCourseName();
            model.addAttribute("course", courseName);
            model.addAttribute("student", user);
        } catch (NullPointerException e) {

            String noCourse = "none";
            model.addAttribute("course", noCourse);
            model.addAttribute("student", user);
        }

        return "student-view";
    }

    // UPDATE page
    @GetMapping(path="/update/{id}")
    public String updateUser(@PathVariable Long id,
                                           Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("student", user);
        return "update";
    }

    // UPDATE User
    @GetMapping(path="/update")
    public ModelAndView updateStudent(@RequestParam Long id,
                                   @RequestParam String firstname,
                                   @RequestParam String lastname) {
        // Needs Error Checking
        User user = userRepository.findOne(id);

        user.setFirstName(firstname);
        user.setLastName(lastname);
        userRepository.save(user);
        return new ModelAndView("redirect:/user");
    }
    @GetMapping(path="/register/{id}")
    public String registerStudent(@PathVariable Long id, Model model) {
        Iterable<Course> allcourses = courseRepository.findAll();
        model.addAttribute("allcourses", allcourses);
        model.addAttribute("studentid", id);
        return "pick-student";
    }

    @GetMapping(path="/addcourse/{id}")
    public ModelAndView registerStudent(@PathVariable Long id, @RequestParam Long course) {
        User user = userRepository.findOne(id);
        Course studentSelectedCourse = courseRepository.findOne(course);
        user.setCourse(studentSelectedCourse);
        userRepository.save(user);
        return new ModelAndView("redirect:/user");
    }

}
