package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Section;
import com.banner.bannerApplication.repositories.CourseRepository;
import com.banner.bannerApplication.repositories.SectionRepository;
import com.banner.bannerApplication.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collection;

/** This is the controller for Faculty Courses.
 *  This holds the CRUD operations for Faculty Courses.
 * */

@Controller
@RequestMapping("faculty")
public class FacultyCourse {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    /** Create a Faculty Course w/ Get Request */
    @GetMapping(path = "/create")
    String newCourse() {
        return "create-course";
    }

    /** Create a Faculty Course w/ Post Request */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewCourse(@RequestParam final String department,
                                     @RequestParam final String courseName,
                                     @RequestParam final String number,
                                     @RequestParam final int credits,
                                     @RequestParam final String description,
                                     @RequestParam final String learningObjective,
                                     @RequestParam final String prereqs,
                                     @RequestParam final String coreqs) {
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

    /** Delete a Course */
    @GetMapping(path = "/delete/{id}")
    public ModelAndView removeCourse(@PathVariable final Long id) {
        courseRepository.delete(id);
        return new ModelAndView("redirect:/faculty");
    }

    /** Read All Courses */
    @GetMapping(path = "")
    public String showAll(final Model model) {
        // View all Courses
        Iterable<Course> allCourses = courseRepository.findAll();
        model.addAttribute("allCourses", allCourses);

        // View all Buildings
        Iterable<Buildings> allBuildings = buildingRepository.findAll();
        model.addAttribute("allBuildings", allBuildings);

        return "faculty";
    }

    /** View a Course */
    @GetMapping(path = "/view/{id}")
    public String showOne(@PathVariable final Long id, final Model model) {
        Course course = courseRepository.findOne(id);
        Collection<Section> sections =
                sectionRepository.findByCourseNumber(course.getNumber());
        model.addAttribute("course", course);
        model.addAttribute("sections", sections);

        return "course-view";
    }

    /** Update Faculty Page */
    @GetMapping(path = "/update/{id}")
    public String updateCourse(@PathVariable final Long id,
                               final Model model) {
        Course course = courseRepository.findOne(id);
        model.addAttribute("course", course);
        return "update-course";
    }

    /** Update Faculty Course */
    @GetMapping(path = "/update")
    public ModelAndView updateCourse(@RequestParam final String department,
                                     @RequestParam final String courseName,
                                     @RequestParam final String number,
                                     @RequestParam final int credits,
                                     @RequestParam final String description,
                                     @RequestParam final String learningObjective,
                                     @RequestParam final String prereqs,
                                     @RequestParam final String coreqs,
                                     @RequestParam final Long id) {

        Course course = courseRepository.findOne(id);
        course.setDepartment(department);
        course.setCourseName(courseName);
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
