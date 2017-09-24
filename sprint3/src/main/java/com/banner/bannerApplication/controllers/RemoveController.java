package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("delete1")
public class RemoveController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping(path="")
    public String RemoveUser(@RequestParam String id) {
        User n = new User();
        n.setId(id);
        userRepository.delete(id);
        return "index";
    }
}
