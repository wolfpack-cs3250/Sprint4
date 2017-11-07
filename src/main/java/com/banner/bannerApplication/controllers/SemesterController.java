package com.banner.bannerApplication.controllers;


import com.banner.bannerApplication.entities.Semester;
import com.banner.bannerApplication.repositories.SemesterRepository;
import com.banner.bannerApplication.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("semesters")

public class SemesterController {

    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @RequestMapping("/create")
    String newBuildings() {
        return "create-semesters";
    }

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewSemester (@RequestParam long semesterYear,
                                        @RequestParam Semester.Season semesterSeason
                                        ) {
        Semester s = new Semester();
        s.setSemesterSeason(semesterSeason);
        s.setSemesterYear(semesterYear);
        semesterRepository.save(s);
        return new ModelAndView("redirect:/semester");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView RemoveSemester(@PathVariable Long id) {
        semesterRepository.delete(id);
        return new ModelAndView("redirect:/semester");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Semester> allsemesters = semesterRepository.findAll();
        model.addAttribute("allsemesters", allsemesters);
        return "semester";
    }

}
