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

/** This is the controller for Professors.
 *  This holds the CRUD operations for Professors.
 * */

@Controller
@RequestMapping("professor")

public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SectionRepository sectionRepository;

    /** Create a Professor html */
    @RequestMapping("/create-professor")
    String createProfessor() {
        return "create-professor";
    }

    /** Create a Professor */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewProfessor(@RequestParam final String firstName,
                                        @RequestParam final String lastName) {
        Professor n = new Professor();
        n.setFirstName(firstName);
        n.setLastName(lastName);
        professorRepository.save(n);
        return new ModelAndView("redirect:/professor");
    }

    /** Delete a Professor */
    @GetMapping(path = "/delete/{id}")
    public ModelAndView removeProfessor(@PathVariable final Long id) {
        professorRepository.delete(id);
        return new ModelAndView("redirect:/professor");
    }

    /** Read All Professors */
    @GetMapping(path = "")
    public String showAll(final Model model) {
        Iterable<Professor> professors = professorRepository.findAll();
        model.addAttribute("professors", professors);
        return "professorPage";
    }

    /** View a Professor */
    @GetMapping(path = "/view/{id}")
    public String showOne(@PathVariable final Long id, final Model model) {
        Professor professor = professorRepository.findOne(id);
        Collection<Section> sections =
                sectionRepository.findByProfessorId((id));
        model.addAttribute("professor", professor);
        model.addAttribute("sections", sections);
        return "professor-view";
    }

    /** Update a Professor */
    @GetMapping(path = "/update/{id}")
    public String updateProfessor(@PathVariable final Long id,
                                  final Model model) {

        Professor professor = professorRepository.findOne(id);
        model.addAttribute("professor", professor);
        return "update-professor";
    }

    /** Update Professor Final */
    @GetMapping(path = "/update")
    public ModelAndView updateProfessorFinal(@RequestParam final Long id,
                                             @RequestParam final String firstName,
                                             @RequestParam final String lastName) {

        Professor professor = professorRepository.findOne(id);
        professor.setFirstName(firstName);
        professor.setLastName(lastName);
        professorRepository.save(professor);
        return new ModelAndView("redirect:/professor");
    }

    /** Register a Professor */
    @GetMapping(path = "/register/{id}")
    public String registerProfessor(@PathVariable final Long id,
                                    final Model model) {
        Iterable<Course> allCourses = courseRepository.findAll();
        model.addAttribute("allCourses", allCourses);
        model.addAttribute("professorId", id);
        return "pick-professor";
    }

}
