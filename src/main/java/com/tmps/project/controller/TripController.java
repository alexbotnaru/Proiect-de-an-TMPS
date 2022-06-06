package com.tmps.project.controller;

import com.tmps.project.iterator.TripContainer;
import com.tmps.project.iterator.TripIterator;
import com.tmps.project.model.Reservation;
import com.tmps.project.model.Trip;
import com.tmps.project.proxy.ProxyHotelsList;
import com.tmps.project.service.ReservationService;
import com.tmps.project.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/trip")
public class TripController {

    private final TripService tripService;
    private final ReservationService reservationService;

    @Autowired
    public TripController(TripService tripService, ReservationService reservationService) {
        this.tripService = tripService;
        this.reservationService = reservationService;
    }

    @GetMapping
    public String getTrips(Model model) {

        List<Trip> trips = tripService.getAll();
        model.addAttribute("trips", trips);
        return "trips";
    }

    @GetMapping("/{id}")
    public ModelAndView getTripById(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("trip");
        modelAndView.addObject(tripService.getById(id));
        System.out.println(tripService.getById(id));
        return modelAndView;
    }

    @GetMapping("/country/{country}")
    public String getTripsByCountry(@PathVariable String country, Model model) {
        Trip[] tripsArray = tripService.getAll().toArray(new Trip[0]);
        List<Trip> filteredList = new LinkedList<>();

        TripContainer tripContainer = new TripContainer();
        TripIterator iterator = (TripIterator) tripContainer.getIterator(tripsArray);

        while (iterator.hasNext()) {
            Trip trip = iterator.next();
            if (trip.getCountry().getName().equalsIgnoreCase(country)) {
                filteredList.add(trip);
            }
        }
        model.addAttribute("trips", filteredList);

        return "trips";
    }

    @GetMapping("/reserve/{tripId}")
    public String reserveTrip(@PathVariable Long tripId, Authentication authentication, Model model) {
        Reservation reservation = reservationService.createReservation(tripId, authentication.getName());
        System.out.println(reservation.getUser().getEmail());
        System.out.println((reservation.getTrip().getName()));

        model.addAttribute("reservation", reservation);
        model.addAttribute("localDate", LocalDate.now());
        return "newReservation";
    }



}
