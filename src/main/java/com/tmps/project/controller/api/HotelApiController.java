package com.tmps.project.controller.api;

import com.tmps.project.model.Hotel;
import com.tmps.project.service.HotelService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@RequiredArgsConstructor
public class HotelApiController {

    private final HotelService hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return new ResponseEntity<>(hotelService.create(hotel), HttpStatus.CREATED);

    }
    @GetMapping(path = "/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id){
        return new ResponseEntity<>(hotelService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels(){
        return new ResponseEntity<>(hotelService.getAll(), HttpStatus.OK);
    }
}

