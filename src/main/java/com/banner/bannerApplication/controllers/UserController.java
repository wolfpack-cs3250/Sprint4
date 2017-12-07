package com.banner.bannerApplication.controllers;

/** This is the controller for Semesters.
 *  This holds the CRUD operations for Semesters.
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import com.banner.bannerApplication.entities.Global;
import com.banner.bannerApplication.repositories.GlobalRepository;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.UserRepository;
import com.banner.bannerApplication.repositories.CourseRepository;
import com.banner.bannerApplication.entities.Section;
import com.banner.bannerApplication.repositories.SectionRepository;


@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private SectionRepository sectionRepository;
    @Autowired
    private GlobalRepository globalRepository;

    /** Create Student html */
    @RequestMapping("/create-student")
    String createStudent() {
        return "create";
    }

    /** Create a User */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewUser (@RequestParam String firstName,
                                    @RequestParam String lastName) {

        User n = new User();
        Global g = new Global();
        n.setFirstName(firstName);
        n.setLastName(lastName);

        // initializes default global values for student
        g.setSchoolName("Wolfpack University");
        g.setSeniorCredits(0);
        g.setJuniorCredits(0);
        g.setSophmoreCredits(0);
        g.setFreshmanCredits(0);
        g.setCreditsCompleted();

        // saves to db
        userRepository.save(n);
        globalRepository.save(g);
        return new ModelAndView("redirect:/user");
    }

    /** Delete a User */
    @GetMapping(path="/delete/{id}")
    public ModelAndView removeUser(@PathVariable Long id) {

        userRepository.delete(id);
        return new ModelAndView("redirect:/user");
    }

    /** Read All Users */
    @GetMapping(path="")
    public String showAll(Model model) {

        Iterable<User> allUsers = userRepository.findAll();
        model.addAttribute("allUsers", allUsers);
        return "userPage";
    }

    /** View One User */
    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        User user = userRepository.findOne(id);
        Collection<Section> sections = sectionRepository.findByUserId((id));
//        Global global = globalRepository.findBySchoolName("Wolfpack University");

        model.addAttribute("student", user);
//        model.addAttribute("global", global);
        model.addAttribute("sections", sections);

        return "student-view";
    }

    /** Update page */
    @GetMapping(path="/update/{id}")
    public String updateUser(@PathVariable Long id,
                                           Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("student", user);
        return "update";
    }

    /** Update User */
    @GetMapping(path="/update")
    public ModelAndView updateStudent(@RequestParam Long id,
                                      @RequestParam String firstName,
                                      @RequestParam String lastName) {

        // Needs Error Checking
        User user = userRepository.findOne(id);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
        return new ModelAndView("redirect:/user");
    }

    @GetMapping(path="/register/{id}")
    public String registerStudent(@PathVariable Long id, Model model) {

        Iterable<Section> sections = sectionRepository.findAll();
        model.addAttribute("sections", sections);
        model.addAttribute("studentId", id);
        return "pick-student";
    }

    @GetMapping(path="/addCourse/{id}")
    public ModelAndView registerStudent(@PathVariable Long id,
                                        @RequestParam Long sectionId,
                                        Model model) {

        Set<User> s = new HashSet<>();
        s.add(userRepository.findOne(id));

        Section section = sectionRepository.findOne(sectionId);

        if (checkConflictingSchedules(id, sectionId)) {
            section.setUser(s);
            
            sectionRepository.save(section);
            return new ModelAndView("redirect:/user");
        }
        else{
            return new ModelAndView("redirect:/user/error");
        }
    }

    @GetMapping(path="/error")
    public String someError(){
       return "error-page";
    }

    /** checkConflictingSchedules will return true is there are no conflicting schedules
     *  will return false if there is some conflict.
     */
    private boolean checkConflictingSchedules(Long studentId, Long sectionId){

        // Get all of the sections the user already belongs to
        Section section = sectionRepository.findOne(sectionId);
        Collection<Section> sections = sectionRepository.findByUserId((studentId));
        if (sections.isEmpty()){
            return true;
        }

        for(Section s: sections) {
            // test time to make sure it doesn't conflict with start.
            //if (s.getClassDate().equals(section.getClassDate())) {
                if ((s.getStartTime().isAfter(section.getStartTime()) && s.getStartTime().isBefore(section.getEndTime()))
                        ||
                        // test time to make sure it doesn't conflict with end.
                        (s.getEndTime().isAfter(section.getStartTime()) && s.getEndTime().isBefore(section.getEndTime()))) {
                    return false;
                }

            //}
            //return true;
        }
        // If the student is registered to no classes, return true.

        return true;
    }
}
