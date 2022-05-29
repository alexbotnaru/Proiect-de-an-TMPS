package com.tmps.project.service;

import com.tmps.project.repository.TripRepository;
import com.tmps.project.model.Country;
import com.tmps.project.model.Trip;
import com.tmps.project.model.builder.BasicTripBuilder;
import com.tmps.project.model.singleton.Moldova;
import com.tmps.project.model.singleton.Romania;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class TripService implements Service<Trip, Long> {

    private final TripRepository repository;

    @Override
    public List<Trip> getAll() {
        return repository.findAll();
    }

    @Override
    public Trip getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Trip create(Trip request) {
        Country country = null;
        switch (request.getCountry().getCity()) {
            case "Moldova":
                country = Moldova.getInstance();
                break;
            case "Romania":
                country = Romania.getInstance();
                break;
            default:
                country = null;
        }

        BasicTripBuilder tripBuilder = new BasicTripBuilder();
        Trip trip = tripBuilder.setPrice(request.getPrice())
                .setDescription(request.getDescription())
                .setHotel(request.getHotel())
                .setMaxPersons(request.getAvailablePlaces())
                .serNrOfDays(request.getNrOfDays())
                .setCountry(country)
                .setName(request.getName())
                .build();
        System.out.println(trip);

        return repository.save(trip);
    }

    @Override
    public Trip updateById(Long aLong, Trip trip) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void verifyEntityById(Long aLong) {

    }
}