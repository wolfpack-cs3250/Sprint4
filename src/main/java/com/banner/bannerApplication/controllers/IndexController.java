package com.banner.bannerApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** This is the controller for the Homepage.
 * */

@Controller
public class IndexController {
    @RequestMapping("/")
    String index() {
        return "index";
    }

    @RequestMapping("/select")
    String select() {
        return "select";
    }

    @RequestMapping("/school-information")
    String schoolInformation() {
        return "school-information";
    }

    @RequestMapping("/buildings")
    String buildings() {
        return "buildings";
    }
}
