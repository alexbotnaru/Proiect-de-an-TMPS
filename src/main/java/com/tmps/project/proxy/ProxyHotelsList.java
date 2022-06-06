package com.tmps.project.proxy;

import com.tmps.project.model.Hotel;
import com.tmps.project.model.Trip;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@AllArgsConstructor
public class ProxyHotelsList implements HotelsList {

    private RealHotelsList realHotelsList;

    @Override
    public List<Hotel> getHotels() {
        if (realHotelsList.getHotels() == null){
            realHotelsList.retrieveHotels();
        }
        log.info("Hotels List retrieved from Proxy Cache");
        return realHotelsList.getHotels();
    }
}
