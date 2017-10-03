package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Section;
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
@RequestMapping("faculty")
public class FacultyCourse {
    @Autowired
    private CourseRepository courseRepository;

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

    // Create - w GET REQUEST
    @GetMapping(path="/create")
    String newCourse (){
        return "create-course";
    }

    // Delete
    @GetMapping(path="/delete")
    public ModelAndView RemoveCourse(@RequestParam Long id) {
        Course n = new Course();
        courseRepository.delete(id);
        return new ModelAndView("redirect:/course");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Course> allcourses = courseRepository.findAll();
        model.addAttribute("allcourses", allcourses);
        return "faculty";
    }

    // Read by id
//    @GetMapping(path="/{id}")

    // UPDATE
    //find by number
    @GetMapping(path="/update")
    public ModelAndView updateCourse(@RequestParam String department, @RequestParam String coursename, @RequestParam String number, @RequestParam int credits,
                                     @RequestParam String description,@RequestParam String learningObjective, @RequestParam String prereqs, @RequestParam String Coreqs, @RequestParam long id) {
        // Needs Error Checking!!
        Course course = courseRepository.findOne(id);
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
