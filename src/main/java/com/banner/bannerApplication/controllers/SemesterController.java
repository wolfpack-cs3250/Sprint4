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

/** This is the controller for Semesters.
 *  This holds the CRUD operations for Semesters.
 * */

@Controller
@RequestMapping("semester")

public class SemesterController {

    @Autowired
    private SemesterRepository semesterRepository;
    @Autowired
    private SectionRepository sectionRepository;

    @RequestMapping("/create")
    String newSemester() {
        return "create-semester";
    }

    /** Create a Semester */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewSemester (@RequestParam long semesterYear,
                                        @RequestParam Semester.Season semesterSeason) {

        Semester s = new Semester();
        s.setSemesterSeason(semesterSeason);
        s.setSemesterYear(semesterYear);
        semesterRepository.save(s);
        return new ModelAndView("redirect:/semester");
    }

    /** Delete a Semester */
    @GetMapping(path="/delete/{id}")
    public ModelAndView removeSemester(@PathVariable Long id) {

        semesterRepository.delete(id);
        return new ModelAndView("redirect:/semester");
    }

    /** Read all Semesters */
    @GetMapping(path="")
    public String showAll(Model model) {
        Iterable<Semester> allSemester = semesterRepository.findAll();
        model.addAttribute("allSemester", allSemester);
        return "semester";
    }

}
