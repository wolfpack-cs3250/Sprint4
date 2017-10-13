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
    public ModelAndView addSection(@RequestParam Long courseId, @RequestParam Long sectionNumber,
                                   @RequestParam Long professorId){

        Course course = courseRepository.findOne(courseId);
        Professor professor = professorRepository.findOne(professorId);

        Section n = new Section();
        n.setSectionNumber(sectionNumber);
        n.setCourse(course);
        n.setProfessor(professor);
        sectionRepository.save(n);
        return new ModelAndView("redirect:/faculty/view/" + courseId);
    }

    @GetMapping(path="/add/{id}")
    public String createSection(@PathVariable Long id, Model model) {
        Course course = courseRepository.findOne(id);
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        model.addAttribute("course", course);
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

    // UPDATE page
    @GetMapping(path="/update/{id}")
    public String updateSection(@PathVariable Long id,
                               Model model) {

        Section section = sectionRepository.findOne(id);
        Iterable<Professor> professors = professorRepository.findAll();

        model.addAttribute("section", section);
        model.addAttribute("professors", professors);
        return "update-section";
    }

    // UPDATE section
    @GetMapping(path="/update")
    public ModelAndView updateCourse(@RequestParam Long sectionId, @RequestParam Long sectionNumber,
                                     @RequestParam Long professorId){

        Professor professor = professorRepository.findOne(professorId);
        Section n = sectionRepository.findOne(sectionId);
        n.setSectionNumber(sectionNumber);
        n.setProfessor(professor);
        sectionRepository.save(n);
        return new ModelAndView("redirect:/faculty/view/" + n.getCourse().getCourseId());
    }

}
