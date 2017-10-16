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

import java.util.Collection;

@Controller
@RequestMapping("buildings")

public class BuildingsController {

    @Autowired
    private BuildingRepository buildingRepository;

    @RequestMapping("/create")
    String newBuildings() {
        return "create-buildings";
        }

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
        return new ModelAndView("redirect:/faculty");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView RemoveUser(@PathVariable Long id) {
        buildingRepository.delete(id);
        return new ModelAndView("redirect:/faculty");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Buildings> allbuildings = buildingRepository.findAll();
        model.addAttribute("allbuildings", allbuildings);
        return "buildings";
    }

    @GetMapping(path="/view/{id}")
    public String showOne(@PathVariable Long id, Model model) {
         Buildings buildings = buildingRepository.findOne(id);
         model.addAttribute("buildings", buildings);
         return "buildings-view";
    }

    // UPDATE
    @GetMapping(path="/update/{id}")
    public String updateUser(@PathVariable Long id,
                             Model model) {
        Buildings buildings = buildingRepository.findOne(id);
        model.addAttribute("buildings", buildings);
        return "update-buildings";
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
        return new ModelAndView("redirect:/faculty");
    }

}
