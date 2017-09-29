package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class FacultyCourse {
    @Autowired
    private CourseRepository courseRepository;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewCourse (@RequestParam String department, @RequestParam String coursename, @RequestParam String number, @RequestParam int credits,
                                      @RequestParam String description,@RequestParam String learningObjective, @RequestParam String prereqs, @RequestParam String Coreqs) {
        Course n = new Course();
        n.setDepartment(department);
        n.setCourseName(coursename);
        n.setNumber(number);
        n.setCredits(credits);
        n.setDescription(description);
        n.setLearningObjective(learningObjective);
        n.setPrereqs(prereqs);
        n.setCoreq(Coreqs);
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
    //find by number
    @GetMapping(path="/update")
    public ModelAndView updateCourse(@RequestParam String department, @RequestParam String coursename, @RequestParam String number, @RequestParam int credits,
                                     @RequestParam String description,@RequestParam String learningObjective, @RequestParam String prereqs, @RequestParam String Coreqs) {
        // Needs Error Checking!!
        Course course = courseRepository.findOne(number);
        course.setDepartment(department);
        course.setCourseName(coursename);
        course.setNumber(number);
        course.setCredits(credits);
        course.setDescription(description);
        course.setLearningObjective(learningObjective);
        course.setPrereqs(prereqs);
        course.setCoreq(Coreqs);
        courseRepository.save(course);
        return new ModelAndView("redirect:/course");


    }

}
