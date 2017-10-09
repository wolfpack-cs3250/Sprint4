package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.repositories.ProfessorRepository;
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

@Controller
@RequestMapping("professor")

public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseRepository courseRepository;


    // Create Professer html page
    @RequestMapping("/create-professor")
    String createProfessor() {
        return "create-professor";
    }

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewProfessor (@RequestParam String firstname,
                                         @RequestParam String lastname) {
        Professor n = new Professor();
        n.setFirstName(firstname);
        n.setLastName(lastname);
        professorRepository.save(n);
        return new ModelAndView("redirect:/professor");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView RemoveProfessor(@PathVariable Long id) {
        professorRepository.delete(id);
        return new ModelAndView("redirect:/professor");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Professor> allusers = professorRepository.findAll();
        model.addAttribute("allusers", allusers);
        return "professorpage";
    }

    // View One Professor
    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        Professor professor = professorRepository.findOne(id);

        model.addAttribute("professor", professor);
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
                                      @RequestParam String firstname,
                                      @RequestParam String lastname) {
        Professor professor = professorRepository.findOne(id);
        professor.setFirstName(firstname);
        professor.setLastName(lastname);
        professorRepository.save(professor);
        return new ModelAndView("redirect:/professor");
    }

    // Register - Professor
    @GetMapping(path="/register/{id}")
    public String registerProfessor(@PathVariable Long id, Model model) {
        Iterable<Course> allcourses = courseRepository.findAll();
        model.addAttribute("allcourses", allcourses);
        model.addAttribute("professorid", id);
        return "pick-professor";
    }


}
