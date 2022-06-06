package com.tmps.project.proxy;

import com.tmps.project.model.Hotel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HotelsList {

    List<Hotel> getHotels();
}
