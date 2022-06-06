package com.tmps.project.controller;

import com.tmps.project.iterator.TripIterator;
import com.tmps.project.model.Hotel;
import com.tmps.project.model.Trip;
import com.tmps.project.proxy.ProxyHotelsList;
import com.tmps.project.service.HotelService;
import com.tmps.project.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    private final HotelService hotelService;
    private final ProxyHotelsList proxyHotelsList;

    @Autowired
    public HotelController(HotelService hotelService, ProxyHotelsList proxyHotelsList) {
        this.hotelService = hotelService;
        this.proxyHotelsList = proxyHotelsList;
    }

    @GetMapping
    public String getHotels(Model model){

        List<Hotel> hotels = proxyHotelsList.getHotels();
        model.addAttribute("hotels", hotels);

        return "hotels";
    }

    @GetMapping("/{id}")
    public ModelAndView getHotelById(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("hotel");
        modelAndView.addObject(hotelService.getById(id));
        System.out.println(hotelService.getById(id));
        return modelAndView;
    }

}
