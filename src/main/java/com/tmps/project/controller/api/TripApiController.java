package com.tmps.project.controller.api;

import com.tmps.project.model.Trip;
import com.tmps.project.service.TripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/trip")
public class TripApiController {

    private final TripService tripService;

    @PostMapping
    public ResponseEntity<Trip> createTrip(@RequestBody Trip trip){
        return new ResponseEntity<>(tripService.create(trip), HttpStatus.CREATED);

    }
        @GetMapping(path = "/{id}")
    public ResponseEntity<Trip> getTripById(@PathVariable Long id){
        return new ResponseEntity<>(tripService.getById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Trip>> getTrips(){
        return new ResponseEntity<>(tripService.getAll(), HttpStatus.OK);
    }
}
