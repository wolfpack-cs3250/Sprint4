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
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("buildings")

public class BuildingsController {

    @Autowired
    private BuildingRepository buildingRepository;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewBuilding (@RequestParam String buildingName,
                                        @RequestParam String roomSize,
                                        @RequestParam String roomNumber) {
        Buildings n = new Buildings();
        n.setBuildingName(buildingName);
        n.setRoomSize(roomSize);
        n.setRoomNumber(roomNumber);
        buildingRepository.save(n);
        return new ModelAndView("redirect:/buildings");
    }
    // why do the building n and the .set when you jsut do a .delete with the building name given into the parameter.
    // Delete
    @GetMapping(path="/delete")
    public ModelAndView RemoveBuildings(@RequestParam String buildingName) {
//        Buildings n = new Buildings();
//        n.setId(buildingName);
        buildingRepository.delete(buildingName);
        return new ModelAndView("redirect:/buildings");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Buildings> allusers = buildingRepository.findAll();
        model.addAttribute("allusers", allusers);
        return "buildingspage";
    }

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateBuildings(@RequestParam String buildingName,
                                        @RequestParam String roomSize,
                                        @RequestParam String roomNumber) {
        Buildings buildings = buildingRepository.findOne(buildingName);

        buildings.setBuildingName(buildingName);;
        buildings.setRoomNumber(roomNumber);
        buildings.setRoomSize(roomSize);
        buildingRepository.save(buildings);
        return new ModelAndView("redirect:/buildings");


    }

}
