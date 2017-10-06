package com.banner.bannerApplication.controllers;

import com.banner.bannerApplication.entities.Rooms;
import com.banner.bannerApplication.repositories.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping(path="/delete")
    public ModelAndView RemoveRooms(@RequestParam String roomNumber) {
        Rooms n = new Rooms();
        n.setId(roomNumber);
        roomsRepository.delete(roomNumber);
        return new ModelAndView("redirect:/rooms");
    }

    // Read All
    @GetMapping(path="")
    public String showall(Model model) {
        Iterable<Rooms> allRooms = roomsRepository.findAll();
        model.addAttribute("allRooms", allRooms);
        return "roomspage";
    }

    // UPDATE
    @GetMapping(path="/update")
    public ModelAndView updateRooms(@RequestParam String roomSize,
                                    @RequestParam String roomNumber) {
        Rooms rooms = roomsRepository.findOne(roomNumber);

        rooms.setRoomSize(roomSize);
        rooms.setRoomNumber(roomNumber);
        roomsRepository.save(rooms);
        return new ModelAndView("redirect:/rooms");


    }

}
