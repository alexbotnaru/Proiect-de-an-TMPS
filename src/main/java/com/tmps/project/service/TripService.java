package com.tmps.project.service;

import com.tmps.project.model.Hotel;
import com.tmps.project.model.Image;
import com.tmps.project.model.factory_method.Bulgaria;
import com.tmps.project.model.factory_method.CountryFactory;
import com.tmps.project.repository.CountryRepository;
import com.tmps.project.repository.ImageRepository;
import com.tmps.project.repository.TripRepository;
import com.tmps.project.model.Country;
import com.tmps.project.model.Trip;
import com.tmps.project.model.builder.BasicTripBuilder;
import com.tmps.project.model.factory_method.Moldova;
import com.tmps.project.model.factory_method.Romania;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.naming.InvalidNameException;
import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class TripService implements Service<Trip, Long> {

    private final CountryRepository countryRepository;

    private final HotelService hotelService;
    private final TripRepository repository;
    private final ImageRepository imageRepository;

    @Override
    public List<Trip> getAll() {
        return repository.findAll();
    }

    @Override
    @ModelAttribute("trip")
    public Trip getById(Long id) {
        return repository.getById(id);
    }

    @Override
    public Trip create(Trip request) {
        CountryFactory countryFactory = new CountryFactory();
        Country country = countryFactory.getCountry(request.getCountry().getName());

        Hotel hotel = hotelService.getByName(request.getHotel().getName());

        Image image = new Image(request.getImage().getImageUrl());
        Image returnedImage = imageRepository.save(image);

        BasicTripBuilder tripBuilder = new BasicTripBuilder();
        Trip trip = tripBuilder.setPrice(request.getPrice())
                .setName(request.getName())
                .setDescription(request.getDescription())
                .setHotel(hotel)
                .setMaxPersons(request.getAvailablePlaces())
                .serNrOfDays(request.getNrOfDays())
                .setCountry(country)
                .setImage(returnedImage)

                .setName(request.getName())
                .build();

        Country countryFromDb = countryRepository.findById(country.getId()).orElseThrow(() -> new RuntimeException("No such country in Database"));
        trip.setCountry(countryFromDb);
        System.out.println(trip);

        return repository.save(trip);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
