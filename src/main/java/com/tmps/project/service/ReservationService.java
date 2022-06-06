package com.tmps.project.service;

import com.tmps.project.facade.ReservationFacade;
import com.tmps.project.model.AppUser;
import com.tmps.project.model.Reservation;
import com.tmps.project.model.Trip;
import com.tmps.project.model.state.ReservationState;
import com.tmps.project.repository.AppUserRepository;
import com.tmps.project.repository.ReservationRepository;
import com.tmps.project.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservationService {

    private final ReservationFacade facade;

    public Reservation createReservation(Long tripId, String username){
        return facade.newReservation(tripId, username);
    }

    public void confirmReservation(Long id) {
        facade.confirmReservation(id);
    }

    public List<Reservation> getAll(String email) {

        return facade.getAllReservationsByUsername(email);
    }

    public void deleteById(Long id){
        facade.deleteReservationById(id);
    }
}
