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
    private CourseRepository courseRepository;

    // Create
    // Section Controllers
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView AddSection(@RequestParam long courseID, @RequestParam String ProfessorFirstname,
                                   @RequestParam String ProfessorLastname, @RequestParam int sectionnumber){
        Course course = courseRepository.findOne(courseID);
        Section n= new Section();
        n.setFirstName(ProfessorFirstname);
        n.setLastName(ProfessorLastname);
        n.setSectionNumber(sectionnumber);
        sectionRepository.save(n);
        return new ModelAndView("redirect:/section");

    }

    // Delete
    //needs to be fixed
    @GetMapping(path="/delete")
    public ModelAndView RemoveSection(@RequestParam int sectionNumber) {

        Section n = new Section();
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
    public ModelAndView updateSection(@RequestParam int sectionNumber,@RequestParam String Firstname,@RequestParam String Lastname) {

        // Needs Error Checking
        Section section = sectionRepository.findOne(sectionNumber);
        section.setSectionNumber(sectionNumber);
        section.setFirstName(Firstname);
        section.setLastName(Lastname);
        sectionRepository.save(section);
        return new ModelAndView("redirect:/section");


    }

}
