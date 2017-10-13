package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.entities.Section;
import com.banner.bannerApplication.repositories.CourseRepository;
import com.banner.bannerApplication.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collection;
import java.util.HashSet;

@Controller
@RequestMapping("faculty")
public class FacultyCourse {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SectionRepository sectionRepository;

    // Create - w GET REQUEST
    @GetMapping(path="/create")
    String newCourse (){
        return "create-course";
    }

    // Create - w POST REQUEST
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewCourse (@RequestParam String department, @RequestParam String courseName, @RequestParam String number, @RequestParam int credits,
                                      @RequestParam String description,@RequestParam String learningObjective, @RequestParam String prereqs, @RequestParam String coreqs) {
        Course n = new Course();
        n.setDepartment(department);
        n.setCourseName(courseName);
        n.setNumber(number);
        n.setCredits(credits);
        n.setDescription(description);
        n.setLearningObjective(learningObjective);
        n.setPrereqs(prereqs);
        n.setCoreq(coreqs);
        courseRepository.save(n);
        return new ModelAndView("redirect:/faculty");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView removeCourse(@PathVariable Long id) {
        courseRepository.delete(id);
        return new ModelAndView("redirect:/faculty");
    }

    // Read All
    @GetMapping(path="")
    public String showAll(Model model) {
        Iterable<Course> allCourses = courseRepository.findAll();
        model.addAttribute("allCourses", allCourses);
        return "faculty";
    }

    // View One Course
    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        Course course = courseRepository.findOne(id);
        Collection<Section> sections = sectionRepository.findByCourseNumber(course.getNumber());

        model.addAttribute("course", course);
        model.addAttribute("sections", sections);

        return "course-view";
    }

    // UPDATE page
    @GetMapping(path="/update/{id}")
    public String updateCourse(@PathVariable Long id,
                             Model model) {

        Course course = courseRepository.findOne(id);
        model.addAttribute("course", course);
        return "update-course";
    }

    // UPDATE course
    @GetMapping(path="/update")
    public ModelAndView updateCourse(@RequestParam String department, @RequestParam String coursename, @RequestParam String number, @RequestParam int credits,
                                     @RequestParam String description,@RequestParam String learningObjective, @RequestParam String prereqs, @RequestParam String coreqs, @RequestParam Long id) {

        Course course = courseRepository.findOne(id);
        course.setDepartment(department);
        course.setCourseName(coursename);
        course.setNumber(number);
        course.setCredits(credits);
        course.setDescription(description);
        course.setLearningObjective(learningObjective);
        course.setPrereqs(prereqs);
        course.setCoreq(coreqs);
        courseRepository.save(course);
        return new ModelAndView("redirect:/faculty");
    }
}
