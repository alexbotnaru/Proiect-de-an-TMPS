package com.tmps.project.controller;

import com.tmps.project.model.Trip;
import com.tmps.project.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }



    @GetMapping
    public String getTrips(Model model){
        model.addAttribute("trips", tripService.getAll());
        return "trips";
    }


}
