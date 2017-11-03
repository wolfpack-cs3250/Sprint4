package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.ExtraStuff.LoginServices;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.ProfessorRepository;
import com.banner.bannerApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("login")
public class LoginUserController {
    @Autowired
    private LoginServices loginServices;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String userId,
                              @RequestParam String password, HttpSession session, Model model) {


        User user = loginServices.loginUser(userId, password);
        if (user == null) {
            model.addAttribute("loginError", "Error logging in. Please try again");
            return "login";
        }
        session.setAttribute("loggedInUser", user);
        return "redirect:/";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInUser");
        return "login";
    }
}
