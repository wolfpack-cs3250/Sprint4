package com.banner.bannerApplication.controllers;

/*
*   CRUD operations for sprint 3
*
*/

import com.banner.bannerApplication.entities.Course;
import com.banner.bannerApplication.entities.User;
import com.banner.bannerApplication.repositories.CourseRepository;
import com.banner.bannerApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    private UserRepository userRepository;

    public boolean compDirtyToME(long courseID,long UserId){

        Course course= courseRepository.findOne(courseID);
        User user= userRepository.findOne(UserId);
            course.getCoreq();
            String[] check= user.getDone();
            for(int i=0; i< check.length; i++){
                if(course.getPrereqs().contains(check[i])){
                    return true;
                }
            }
            return false;

    }
    // Create
    @RequestMapping(method = RequestMethod.POST)
    public void addNewCourse (@RequestParam long UserID,@RequestParam long courseName) {
    Course course= courseRepository.findOne(courseName);
        if(compDirtyToME(courseName,UserID)) {

            chooseSection(UserID,courseName);
        }
        else if (course.getPrereqs()== null) {
            chooseSection(UserID,courseName);
        }
    }
    public ModelAndView chooseSection(long UserID,long courseName){
        User user = userRepository.findOne(UserID);
        user.setInProgress(courseName);

        userRepository.save(user);
        return new ModelAndView("redirect:/student");
    }
    // Delete
    @GetMapping(path="/delete")
    public ModelAndView removeCourse(@RequestParam String courseName,@RequestParam long id) {
        User user= userRepository.findOne(id);
        user.removeInProgress(courseName);
        return new ModelAndView("redirect:/course");
    }

    // Read All
    @GetMapping(path="")
    public String showAll(Model model) {
        Iterable<User> allUser = userRepository.findAll();
        model.addAttribute("UserAll", allUser);
        return "User";
    }


    // Read by id
    // @GetMapping(path="/{id}")


    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateCourse(@RequestParam Long id,
                                     @RequestParam String courseName) {

        // Needs Error Checking!!
        Course course = courseRepository.findOne(id);

        course.setCourseName(courseName);
        courseRepository.save(course);
        return new ModelAndView("redirect:/course");

    }
}
