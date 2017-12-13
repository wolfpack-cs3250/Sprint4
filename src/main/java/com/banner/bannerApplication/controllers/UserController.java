package com.banner.bannerApplication.controllers;

/*
*   Here will lie all of the CRUD operations for Sprint2
*   - Sal
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.Random;

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

    // Create student html page
    @RequestMapping("/create-student")
    String createStudent() {
        return "create";
    }

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewUser (@RequestParam String firstname,
                                            @RequestParam String lastname,@RequestParam String password) {
        User n = new User();
        Global g = new Global();
        n.setFirstName(firstname);
        n.setLastName(lastname);
        n.setPassword(password);
        // initializes default global values for student
        g.setSchoolName("Wolfpack University");
        g.setSeniorCredits(0);
        g.setJuniorCredits(0);
        g.setSophmoreCredits(0);
        g.setFreshmanCredits(0);
        g.setCreditsCompleted();
        //randomly generates username
        Random randy= new Random();
        int candy= randy.nextInt(100)+1;
        String username=(firstname.charAt(1)+lastname+candy);
        n.setUsername(username);
        // saves to db
        userRepository.save(n);
        globalRepository.save(g);
        return new ModelAndView("redirect:/user");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView removeUser(@PathVariable long id) {
        userRepository.delete(id);
        return new ModelAndView("redirect:/user");
    }

    /** Read All Users */
    @GetMapping(path="")
    public String showAll(Model model) {
        Iterable<User> allusers = userRepository.findAll();
        model.addAttribute("allusers", allusers);
        return "userpage";
    }

    /** View One User */
    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable long id, Model model) {
        User user = userRepository.findOne(id);
        Collection<Section> sections = sectionRepository.findByUserId((id));
//        Global global = globalRepository.findBySchoolName("Wolfpack University");

        model.addAttribute("student", user);
//        model.addAttribute("global", global);
        model.addAttribute("sections", sections);

        return "student-view";
    }

    /** UPDATE page */
    @GetMapping(path="/update/{id}")
    public String updateUser(@PathVariable long id,
                                           Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("student", user);
        return "update";
    }

    /** UPDATE User */
    @GetMapping(path="/update")
    public ModelAndView updateStudent(@RequestParam long id,
                                   @RequestParam String firstname,
                                   @RequestParam String lastname) {
        // Needs Error Checking
        User user = userRepository.findOne(id);

        user.setFirstName(firstname);
        user.setLastName(lastname);
        userRepository.save(user);
        return new ModelAndView("redirect:/user");
    }

    @GetMapping(path="/register/{id}")
    public String registerStudent(@PathVariable long id, Model model) {
        Iterable<Section> sections = sectionRepository.findAll();
        model.addAttribute("sections", sections);
        model.addAttribute("studentid", id);
        return "pick-student";
    }

    @GetMapping(path="/addcourse/{id}")
    public ModelAndView registerStudent(@PathVariable long id, @RequestParam long sectionId,
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
    private boolean checkConflictingSchedules(long studentId, long sectionId){
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

            return true;
        }
        // If the student is registered to no classes, return true.

        return true;
    }
}
