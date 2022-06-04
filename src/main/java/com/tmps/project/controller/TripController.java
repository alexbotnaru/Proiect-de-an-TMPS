package com.tmps.project.controller;

import com.tmps.project.iterator.TripIterator;
import com.tmps.project.model.Trip;
import com.tmps.project.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
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

    @GetMapping("/{id}")
    public ModelAndView getTripById(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("trip");
        modelAndView.addObject(tripService.getById(id));
        System.out.println(tripService.getById(id));
        return modelAndView;
    }

    @GetMapping("/country/{country}")
    public String getTripsByCountry(@PathVariable String country, Model model){
        Trip[] tripsArray = tripService.getAll().toArray(new Trip[0]);
        List<Trip> filteredList = new LinkedList<>();

        TripIterator iterator = new TripIterator(tripsArray);

        while (iterator.hasNext()){
            Trip trip = iterator.next();
            if (trip.getCountry().getName().equalsIgnoreCase(country)){
                filteredList.add(trip);
            }
        }
        model.addAttribute("trips", filteredList);

        return "trips";
    }


}
