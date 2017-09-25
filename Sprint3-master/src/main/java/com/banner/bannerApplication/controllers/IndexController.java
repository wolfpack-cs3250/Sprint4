package com.banner.bannerApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// Homepage controller

@Controller
public class IndexController {
    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/create")
    String create() {
        return "create";
    }
    @RequestMapping("/delete")
    String delete() {
        return "delete";
    }

    @RequestMapping("/edit")
    String edit() {
        return "edit";
    }

    @RequestMapping("/update")
    String update() {
        return "update";
    }

}
