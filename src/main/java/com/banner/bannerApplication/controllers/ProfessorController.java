package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.entities.Section;
import com.banner.bannerApplication.repositories.ProfessorRepository;
import com.banner.bannerApplication.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.repositories.CourseRepository;

import java.util.Collection;

@Controller
@RequestMapping("professor")

public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseRepository courseRepository;

    // Create Professor html page
    @Autowired
   private SectionRepository sectionRepository;

    // Create Professer html page
    @RequestMapping("/create-professor")
    String createProfessor() {
        return "create-professor";
    }

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewProfessor (@RequestParam String firstName,
                                         @RequestParam String lastName) {
        Professor n = new Professor();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        professorRepository.save(n);
        return new ModelAndView("redirect:/professor");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView removeProfessor(@PathVariable Long id) {
        professorRepository.delete(id);
        return new ModelAndView("redirect:/professor");
    }

    // Read All
    @GetMapping(path="")
    public String showAll(Model model) {
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        return "professorPage";
    }

    // View One Professor
    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        Professor professor = professorRepository.findOne(id);
        Collection<Section> sections = sectionRepository.findByProfessorId((id));

        model.addAttribute("professor", professor);
        model.addAttribute("sections", sections);
        return "professor-view";
    }

    // UPDATE
    @GetMapping(path="/update/{id}")
    public String updateProfessor(@PathVariable Long id, Model model) {
        // Needs Error Checking!!
        Professor professor = professorRepository.findOne(id);
        model.addAttribute("professor", professor);
        return "update-professor";
    }

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateProfessorFinal(@RequestParam Long id,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName) {
        Professor professor = professorRepository.findOne(id);
        professor.setFirstName(firstName);
        professor.setLastName(lastName);
        professorRepository.save(professor);
        return new ModelAndView("redirect:/professor");
    }

    // Register - Professor
    @GetMapping(path="/register/{id}")
    public String registerProfessor(@PathVariable Long id, Model model) {
        Iterable<Course> allCourses = courseRepository.findAll();
        model.addAttribute("allCourses", allCourses);
        model.addAttribute("professorId", id);
        return "pick-professor";
    }


}
