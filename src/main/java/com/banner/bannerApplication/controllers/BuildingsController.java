package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.entities.Rooms;
import com.banner.bannerApplication.repositories.BuildingRepository;
import com.banner.bannerApplication.repositories.RoomsRepository;
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

/** This is the controller for Buildings.
 *  This holds the CRUD operations for Buildings.
 * */

@Controller
@RequestMapping("buildings")

public class BuildingsController {

    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private RoomsRepository roomsRepository;

    @RequestMapping("/create")
    String newBuildings() {
        return "create-buildings";
    }

    /** Create a Building*/
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewBuilding(@RequestParam final String buildingName,
                                       @RequestParam final String address,
                                       @RequestParam final String acronym) {

        Buildings n = new Buildings();
        n.setBuildingName(buildingName);
        n.setAddress(address);
        n.setAcronym(acronym);
        buildingRepository.save(n);
        return new ModelAndView("redirect:/faculty");
    }

    /** Delete a Building */
    @GetMapping(path = "/delete/{id}")
    public ModelAndView removeBuilding(@PathVariable final Long id) {

        buildingRepository.delete(id);
        return new ModelAndView("redirect:/faculty");
    }

    /** Read All Buildings */
    @GetMapping(path = "")
    public String showAll(final Model model) {

        Iterable<Buildings> allBuildings = buildingRepository.findAll();
        model.addAttribute("allBuildings", allBuildings);
        return "buildings";
    }

    @GetMapping(path = "/view/{id}")
    public String showOne(@PathVariable final Long id, final Model model) {

        Buildings buildings = buildingRepository.findOne(id);
        Collection<Rooms> rooms = roomsRepository.findByBuildingsId(id);
        model.addAttribute("buildings", buildings);
        model.addAttribute("rooms", rooms);
        return "buildings-view";
    }

    /** Update Building */
    @GetMapping(path = "/update/{id}")
    public String updateUser(@PathVariable final Long id,
                             final Model model) {

        Buildings buildings = buildingRepository.findOne(id);
        model.addAttribute("buildings", buildings);
        return "update-buildings";
    }

    /** Update Building */
    @GetMapping(path = "/update")
    public ModelAndView updateBuilding(@RequestParam final Long id,
                                      @RequestParam final String acronym,
                                      @RequestParam final String buildingName,
                                      @RequestParam final String address) {

        Buildings buildings = buildingRepository.findOne(id);
        buildings.setBuildingName(buildingName);
        buildings.setAddress(address);
        buildings.setAcronym(acronym);
        buildingRepository.save(buildings);
        return new ModelAndView("redirect:/faculty");
    }

}
