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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("professor")

public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

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
    @GetMapping(path="/delete")
    public ModelAndView RemoveProfessor(@RequestParam String id) {
        Professor n = new Professor();
        n.setId(id);
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

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateProfessor(@RequestParam String id,
                                        @RequestParam String firstname,
                                        @RequestParam String lastname) {
        // Needs Error Checking!!
        Professor professor = professorRepository.findOne(id);

        professor.setFirstName(firstname);
        professor.setLastName(lastname);
        professorRepository.save(professor);
        return new ModelAndView("redirect:/professor");


    }

}
