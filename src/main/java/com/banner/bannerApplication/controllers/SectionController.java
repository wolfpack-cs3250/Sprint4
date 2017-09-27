package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Section;
import com.banner.bannerApplication.repositories.SectionRepository;
import org.springframework.beans.factory.annotation.Autowire;
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

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewSection (@RequestParam String sectionNumber) {
        Section n = new Section();
        n.setSectionNumber(sectionNumber);
        sectionRepository.save(n);
        return new ModelAndView("redirect:/section");
    }

    // Delete
    @GetMapping(path="/delete")
    public ModelAndView RemoveSection(@RequestParam String sectionNumber) {
        Section n = new Section();
        n.setSectionNumber(sectionNumber);
        sectionRepository.delete(sectionNumber);
        return new ModelAndView("redirect:/section");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Section> allsections = sectionRepository.findAll();
        model.addAttribute("allsections", allsections);
        return "sectionpage";
    }

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateSection(@RequestParam String sectionNumber) {

        // Needs Error Checking
        Section section = sectionRepository.findOne(sectionNumber);

        section.setSectionNumber(sectionNumber);
        sectionRepository.save(section);
        return new ModelAndView("redirect:/section");


    }

}
