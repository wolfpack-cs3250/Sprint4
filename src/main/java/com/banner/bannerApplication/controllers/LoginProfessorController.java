package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.ExtraStuff.LoginServices;
import com.banner.bannerApplication.entities.Professor;
import com.banner.bannerApplication.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginProfessorController {
    @Autowired
    private LoginServices loginServices;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userId,
                              @RequestParam String password, HttpSession session, Model model) {


        Professor professor = loginServices.loginProfessor(userId, password);
        if (professor == null) {
            model.addAttribute("loginError", "Error logging in. Please try again");
            return "login";
        }
        session.setAttribute("loggedInUser", professor);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }
}
