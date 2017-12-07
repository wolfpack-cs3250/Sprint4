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

    @Autowired
    private SectionRepository sectionRepository;

    // Create Professer html page
    @RequestMapping("/create-professor")
    String createProfessor() {
        return "create-professor";
    }

    // Create
    @RequestMapping(method = RequestMethod.POST)

    public ModelAndView addNewProfessor(@RequestParam final String firstname,
                                        @RequestParam final String lastname,
                                        @RequestParam final String Username,
                                        @RequestParam final String password) {
        Professor n = new Professor();
        n.setFirstName(firstname);
        n.setLastName(lastname);
        n.setUsername(Username);
        n.setPassword(password);
        professorRepository.save(n);
        return new ModelAndView("redirect:/professor");
    }

    // Delete
    @GetMapping(path = "/delete/{id}")
    public ModelAndView removeProfessor(@PathVariable final Long id) {
        professorRepository.delete(id);
        return new ModelAndView("redirect:/professor");
    }

    // Read All
    @GetMapping(path = "")
    public String showall(final Model model) {
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        return "professorpage";
    }

    // View One Professor
    @GetMapping(path = "/view/{id}")
    public String showOne(@PathVariable final Long id, final Model model) {
        Professor professor = professorRepository.findOne(id);
        Collection<Section> sections =
                sectionRepository.findByProfessorId((id));
        model.addAttribute("professor", professor);
        model.addAttribute("sections", sections);
        return "professor-view";
    }

    // UPDATE
    @GetMapping(path = "/update/{id}")
    public String updateProfessor(@PathVariable final Long id,
                                  final Model model) {

        Professor professor = professorRepository.findOne(id);
        model.addAttribute("professor", professor);
        return "update-professor";
    }

    // UPDATE
    @GetMapping(path = "/update")
    public ModelAndView updateProfessorFinal(@RequestParam final Long id,
                                             @RequestParam final String firstname,
                                             @RequestParam final String lastname) {

        Professor professor = professorRepository.findOne(id);
        professor.setFirstName(firstname);
        professor.setLastName(lastname);
        professorRepository.save(professor);
        return new ModelAndView("redirect:/professor");
    }

    // Register - Professor
    @GetMapping(path = "/register/{id}")
    public String registerProfessor(@PathVariable final Long id,
                                    final Model model) {
        Iterable<Course> allcourses = courseRepository.findAll();
        model.addAttribute("allcourses", allcourses);
        model.addAttribute("professorid", id);
        return "pick-professor";
    }


}
