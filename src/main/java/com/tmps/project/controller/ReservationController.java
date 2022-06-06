package com.tmps.project.controller;

import com.tmps.project.model.Reservation;
import com.tmps.project.service.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/reservation")
@AllArgsConstructor
public class ReservationController {

    ReservationService reservationService;

    @GetMapping("/confirm/{id}")
    public String confirmReservation(@PathVariable Long id){
        reservationService.confirmReservation(id);
        return "confirmation";
    }

    @GetMapping
    public String getAll(Model model, Authentication authentication){
        String username = authentication.getName();
        List<Reservation> reservationList = reservationService.getAll(username);

        model.addAttribute("reservations", reservationList);
        return "reservations";
    }


}
