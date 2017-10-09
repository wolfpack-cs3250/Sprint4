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

    @RequestMapping("/select")
    String select() {
        return "select";
    }

    // Student Crud Links
    @RequestMapping("/delete")
    String delete() {
        return "delete";
    }

    @RequestMapping("/create")
    String create() {
        return "create";
    }

    @RequestMapping("/update")
    String update() {
        return "update";
    }

    @RequestMapping("/school-information")
    String schoolInformation() {return "school-information";}


    // Professor Crud Links
    @RequestMapping("/delete-professor")
    String deleteProfessor() {
        return "delete-professor";
    }

    @RequestMapping("/create-professor")
    String createProfessor() {
        return "create-professor";
    }

    @RequestMapping("/update-professor")
    String updateProfessor() {
        return "update-professor";
    }

    @RequestMapping("/professor-choices")
    String professorChoices() {
        return "professor-choices";
    }

    @RequestMapping("/student-choices")
    String studentChoices() {
        return "student-choices";
    }

    @RequestMapping("/edit-student")
    String editStudent() {
        return "edit-student";
    }

    @RequestMapping("/pick-student")
    String pickStudent() {
        return "pick-student";
    }

    @RequestMapping("/edit-professor")
    String editProfessor() {
        return "edit-professor";
    }

    @RequestMapping("/pick-professor")
    String pickProfessor() {
        return "pick-professor";
    }

    //Building Crud Link
    @RequestMapping("/create-building")
    String createBuilding() { return "create-building"; }

    @RequestMapping("/update-building")
    String updateBuilding() { return "update-building"; }

    @RequestMapping("/delete-building")
    String deleteBuilding() { return "delete-building"; }

}
