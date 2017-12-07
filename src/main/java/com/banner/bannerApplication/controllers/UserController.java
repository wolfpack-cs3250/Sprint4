package com.banner.bannerApplication.controllers;

/*
*   Here will lie all of the CRUD operations for Sprint2
*   - Sal
*
*/

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< Updated upstream
import java.util.List;
import java.util.Random;

=======
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
>>>>>>> Stashed changes
import com.banner.bannerApplication.entities.Global;
import com.banner.bannerApplication.repositories.GlobalRepository;

import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.UserRepository;

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.repositories.CourseRepository;

import javax.persistence.GeneratedValue;
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
<<<<<<< Updated upstream
        //randomly generates username
=======
        //random generated username
>>>>>>> Stashed changes
        Random randy= new Random();
        int candy= randy.nextInt(100)+1;
        String username=(firstname.charAt(1)+lastname+candy);
        n.setUsername(username);
<<<<<<< Updated upstream
        System.out.println(username);
=======
>>>>>>> Stashed changes
        // saves to db
        userRepository.save(n);
        globalRepository.save(g);
        return new ModelAndView("redirect:/user");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView RemoveUser(@PathVariable Long id) {
        userRepository.delete(id);
        return new ModelAndView("redirect:/user");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<User> allusers = userRepository.findAll();
        model.addAttribute("allusers", allusers);
        return "userpage";
    }

    // View One User
    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable Long id, Model model) {
        User user = userRepository.findOne(id);
        Global global = globalRepository.findBySchoolName("Wolfpack University");

        model.addAttribute("student", user);
        model.addAttribute("global", global);

        return "student-view";
    }

    // UPDATE page
    @GetMapping(path="/update/{id}")
    public String updateUser(@PathVariable Long id,
                                           Model model) {
        User user = userRepository.findOne(id);
        model.addAttribute("student", user);
        return "update";
    }

    // UPDATE User
    @GetMapping(path="/update")
    public ModelAndView updateStudent(@RequestParam Long id,
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
    public String registerStudent(@PathVariable Long id, Model model) {
        Iterable<Section> sections = sectionRepository.findAll();
        model.addAttribute("sections", sections);
        model.addAttribute("studentid", id);
        return "pick-student";
    }

    @GetMapping(path="/addcourse/{id}")
    public ModelAndView registerStudent(@PathVariable Long id, @RequestParam Long sectionId) {
        User user = userRepository.findOne(id);
        Section section = sectionRepository.findOne(sectionId);
        user.setSection(section);
        userRepository.save(user);
        return new ModelAndView("redirect:/user");
    }

<<<<<<< Updated upstream
=======
    /** checkConflictingSchedules will return true is there are no conflicting schedules
     *  will return false if there is some conflict.
     */
    private boolean checkConflictingSchedules(Long studentId, Long sectionId){
        // Get all of the sections the user already belongs to
        Section section = sectionRepository.findOne(sectionId);
        Collection<Section> sections = sectionRepository.findByUserId((studentId));
        if (sections.isEmpty()){
            System.out.println("error1");
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
>>>>>>> Stashed changes
}
