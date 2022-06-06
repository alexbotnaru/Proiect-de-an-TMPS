package com.tmps.project.model.builder;

import com.tmps.project.model.Country;
import com.tmps.project.model.Hotel;
import com.tmps.project.model.Image;
import com.tmps.project.model.Trip;

public interface TripBuilder {

    TripBuilder setPrice(Double price);
    TripBuilder setName(String name);
    TripBuilder serNrOfDays(Integer nrOfDays);
    TripBuilder setHotel(Hotel hotel);
    TripBuilder setMaxPersons(Integer maxPersons);
    TripBuilder setDescription(String description);
    TripBuilder setCountry(Country country);
    TripBuilder setImage(Image image);

    Trip build();
}
