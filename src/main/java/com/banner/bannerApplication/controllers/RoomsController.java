package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Rooms;
import com.banner.bannerApplication.repositories.BuildingRepository;
import com.banner.bannerApplication.entities.Buildings;
import com.banner.bannerApplication.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("rooms")

public class RoomsController {

    @Autowired
    private RoomsRepository roomsRepository;
    @Autowired
    private BuildingRepository buildingRepository;

    // Create - Get
    @GetMapping(path = "/{id}")
    public String createRoom(@PathVariable final Long id, final Model model) {
        Buildings building = buildingRepository.findOne(id);
        model.addAttribute("building", building);
        return "create-room";
    }

    // Create - Post
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewRooms(@RequestParam final String roomSize,
                                    @RequestParam final Long buildingId,
                                    @RequestParam final String roomNumber) {
        Buildings building = buildingRepository.findOne(buildingId);
        Rooms n = new Rooms();
        n.setRoomSize(roomSize);
        n.setRoomNumber(roomNumber);
        n.setBuildings(building);
        roomsRepository.save(n);
        return new ModelAndView("redirect:/buildings/view/" + buildingId);
    }

    // Delete
    @GetMapping(path = "/delete/{id}")
    public ModelAndView removeRooms(@PathVariable final Long id) {
        Rooms room = roomsRepository.findOne(id);
        Long buildingId = room.getBuildings().getId();
        roomsRepository.delete(id);
        return new ModelAndView("redirect:/buildings/view/" + buildingId);
    }

    // Read All
    @GetMapping(path = "")
    public String showall(final Model model) {
        Iterable<Rooms> allRooms = roomsRepository.findAll();
        model.addAttribute("allRooms", allRooms);
        return "roomspage";
    }

    // UPDATE Page
    @GetMapping(path = "/update/{id}")
    public String updateUser(@PathVariable final Long id,
                             final Model model) {

        Rooms rooms = roomsRepository.findOne(id);
        model.addAttribute("rooms", rooms);
        return "update-room";
    }

    // UPDATE
    @GetMapping(path = "/update")
    public ModelAndView updateRooms(@RequestParam final Long id,
                                    @RequestParam final String roomSize,
                                    @RequestParam final String roomNumber) {
        Rooms rooms = roomsRepository.findOne(id);
        rooms.setRoomSize(roomSize);
        rooms.setRoomNumber(roomNumber);
        Long buildingId = rooms.getBuildings().getId();
        roomsRepository.save(rooms);
        return new ModelAndView("redirect:/buildings/view/" + buildingId);
    }

}
