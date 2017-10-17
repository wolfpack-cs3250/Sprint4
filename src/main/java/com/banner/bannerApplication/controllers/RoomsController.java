package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Rooms;
import com.banner.bannerApplication.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("rooms")

public class RoomsController {

    @Autowired
    private RoomsRepository roomsRepository;

    // Create
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addNewRooms (@RequestParam String roomSize,
                                     @RequestParam String roomNumber) {
        Rooms n = new Rooms();
        n.setRoomSize(roomSize);
        n.setRoomNumber(roomNumber);
        roomsRepository.save(n);
        return new ModelAndView("redirect:/rooms");
    }

    // Delete
    @GetMapping(path="/delete/{id}")
    public ModelAndView removeRooms(@PathVariable Long roomId) {
        roomsRepository.delete(roomId);
        return new ModelAndView("redirect:/rooms");
    }

    // Read All
    @GetMapping(path="")
    public String showAll(Model model) {
        Iterable<Rooms> allRooms = roomsRepository.findAll();
        model.addAttribute("allRooms", allRooms);
        return "roomsPage";
    }

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateRooms(@RequestParam String roomNumber,
                                    @RequestParam String roomSize,
                                    @RequestParam Long roomId) {

        Rooms rooms = roomsRepository.findOne(roomId);
        rooms.setRoomSize(roomSize);
        rooms.setRoomNumber(roomNumber);
        roomsRepository.save(rooms);
        return new ModelAndView("redirect:/rooms");


    }

}
