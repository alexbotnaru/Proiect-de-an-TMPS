package com.tmps.project.proxy;

import com.tmps.project.model.Hotel;
import com.tmps.project.model.Trip;
import com.tmps.project.service.HotelService;
import com.tmps.project.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RealHotelsList implements HotelsList {

    private List<Hotel> hotels;
    private final HotelService hotelService;

    @Autowired
    public RealHotelsList(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public List<Hotel> getHotels() {
        return hotels;
    }

    public void retrieveHotels(){
        this.hotels = hotelService.getAll();
    }

}
