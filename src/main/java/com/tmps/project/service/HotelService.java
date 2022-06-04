package com.tmps.project.service;

import com.tmps.project.model.Hotel;
import com.tmps.project.repository.HotelRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class HotelService implements Service<Hotel, Long> {

    private final HotelRepository hotelRepository;

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(Long id) {
        return hotelRepository.getById(id);
    }

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotel updateById(Long aLong, Hotel hotel) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void verifyEntityById(Long aLong) {

    }
}
