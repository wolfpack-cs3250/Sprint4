package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("buildings")

public class BuildingsController {

    @Autowired
    private BuildingRepository buildingRepository;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewBuilding (@RequestParam String buildingName,
                                        @RequestParam String address,
                                        @RequestParam String acronym) {
        Buildings n = new Buildings();
        n.setBuildingName(buildingName);
        n.setAddress(address);
        n.setAcronym(acronym);
        buildingRepository.save(n);
        return new ModelAndView("redirect:/buildings");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView removeUser(@PathVariable Long id) {
        buildingRepository.delete(id);
        return new ModelAndView("redirect:/buildings");
    }

    // Read All
    @GetMapping(path="")
    public String showAll(Model model) {
        Iterable<Buildings> allBuildings = buildingRepository.findAll();
        model.addAttribute("allBuildings", allBuildings);
        return "buildingsPage";
    }

    // UPDATE
    @GetMapping(path="/update/{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        Buildings building = buildingRepository.findOne(id);
        model.addAttribute("building", building);
        return "update-building";
    }

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateStudent(@RequestParam Long id, @RequestParam String acronym,
                                      @RequestParam String buildingName,
                                      @RequestParam String address) {
        Buildings buildings = buildingRepository.findOne(id);
        buildings.setBuildingName(buildingName);
        buildings.setAddress(address);
        buildings.setAcronym(acronym);
        buildingRepository.save(buildings);
        return new ModelAndView("redirect:/buildings");
    }

}
