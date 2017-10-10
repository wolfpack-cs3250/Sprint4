package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.Section;
import com.banner.bannerApplication.repositories.CourseRepository;
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
    @Autowired
    private CourseRepository courseRepository;

    // Create
    // Section Controllers
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView AddSection(@RequestParam Long courseId, @RequestParam int sectionNumber){

        Course course = courseRepository.findOne(courseId);
        Section section = sectionRepository.save(new Section(course, sectionNumber));
        sectionRepository.save(section);
        return new ModelAndView("redirect:/faculty/view/" + courseId);
    }

    @GetMapping(path="/add/{id}")
    public String createSection(@PathVariable Long id, Model model) {
       model.addAttribute("courseId", id);
       return "create-section";
    }

    // Delete
    //needs to be fixed
    @GetMapping(path="/delete/{id]")
    public ModelAndView RemoveSection(@PathVariable Long id) {
        sectionRepository.delete(id);
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
/*
    @GetMapping(path="/update")
    public ModelAndView updateSection(@RequestParam int sectionNumber,@RequestParam String Firstname,@RequestParam String Lastname) {

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
