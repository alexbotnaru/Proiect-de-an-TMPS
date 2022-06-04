package com.tmps.project.model.builder;

import com.tmps.project.model.Country;
import com.tmps.project.model.Hotel;
import com.tmps.project.model.Trip;

public class BasicTripBuilder implements TripBuilder {
    private Double price;
    private String name;
    private Integer nrOfDays;
    private Hotel hotel;
    private Integer maxPersons;
    private String description;
    private Country country;

    @Override
    public TripBuilder setPrice(Double price) {
        this.price = price;
        return this;
    }

    @Override
    public TripBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public TripBuilder serNrOfDays(Integer nrOfDays) {
        this.nrOfDays = nrOfDays;
        return this;
    }

    @Override
    public TripBuilder setHotel(Hotel hotel) {
        this.hotel = hotel;
        return this;
    }

    @Override
    public TripBuilder setMaxPersons(Integer maxPersons) {
        this.maxPersons = maxPersons;
        return this;
    }

    @Override
    public TripBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public TripBuilder setCountry(Country country) {
        this.country = country;
        return this;
    }

    public Trip build(){
        return new Trip(name, price, nrOfDays,description, hotel, maxPersons, country);
    }

}
