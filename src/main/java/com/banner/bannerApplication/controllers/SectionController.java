package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.entities.Section;
import com.banner.bannerApplication.repositories.CourseRepository;
import com.banner.bannerApplication.repositories.ProfessorRepository;
import com.banner.bannerApplication.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("section")

public class SectionController {

    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    // Create
    // Section Controllers
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addSection(@RequestParam Long courseId, @RequestParam Long sectionNumber){

        Course course = courseRepository.findOne(courseId);
        Section n = new Section();
        n.setSectionNumber(sectionNumber);
        n.setCourse(course);
        sectionRepository.save(n);
        return new ModelAndView("redirect:/faculty/view/" + courseId);
    }

    @GetMapping(path="/add/{id}")
    public String createSection(@PathVariable Long id, Model model) {
       model.addAttribute("courseId", id);
       return "create-section";
    }

    @GetMapping(path="/add/professor/{id}")
    public String addProfessorToSectionView(@PathVariable Long id, Model model) {
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("sectionId", id);
        model.addAttribute("professors", professors);
        return "add-professor-to-section";
    }
    @GetMapping(path="/add/professor/")
    public ModelAndView addProfessorToSection(@RequestParam Long professorId, @RequestParam Long sectionId){
        Professor professor = professorRepository.findOne(professorId);
        Section section = sectionRepository.findOne(sectionId);
        section.setProfessor(professor);
        sectionRepository.save(section);
        return new ModelAndView("redirect:/faculty");
    }

    // Delete
    //needs to be fixed
    @GetMapping(path="/delete/{id]")
    public ModelAndView RemoveSection(@PathVariable Long id) {
        sectionRepository.delete(id);
        return new ModelAndView("redirect:/faculty");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Section> allsections = sectionRepository.findAll();
        model.addAttribute("allsections", allsections);
        return "sectionpage";
    }

    // UPDATE
/*
    @GetMapping(path="/update")
    public ModelAndView updateSection(@RequestParam Long sectionNumber,@RequestParam String Firstname,@RequestParam String Lastname) {

        // Needs Error Checking
        Section section = sectionRepository.findOne(sectionNumber);
        section.setSectionNumber(sectionNumber);
        section.setFirstName(Firstname);
        section.setLastName(Lastname);
        sectionRepository.save(section);
        return new ModelAndView("redirect:/section");


    }
    */

}
