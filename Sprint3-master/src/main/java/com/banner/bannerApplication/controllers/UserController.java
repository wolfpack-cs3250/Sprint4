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

import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.UserRepository;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewUser (@RequestParam String firstname,
                                            @RequestParam String lastname) {
        User n = new User();
        n.setFirstName(firstname);
        n.setLastName(lastname);
        userRepository.save(n);
        return new ModelAndView("redirect:/user");
    }

    // Delete
    @GetMapping(path="/delete")
    public ModelAndView RemoveUser(@RequestParam String id) {
        User n = new User();
        n.setId(id);
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


    // Read by id
//    @GetMapping(path="/{id}")

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateUser(@RequestParam String id,
                                           @RequestParam String firstname,
                                           @RequestParam String lastname) {
        // Needs Error Checking!!
        User user = userRepository.findOne(id);

        user.setFirstName(firstname);
        user.setLastName(lastname);
        userRepository.save(user);
        return new ModelAndView("redirect:/user");


    }

}
