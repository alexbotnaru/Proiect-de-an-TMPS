package com.tmps.project.facade;

import com.tmps.project.model.AppUser;
import com.tmps.project.model.Reservation;
import com.tmps.project.model.Trip;
import com.tmps.project.model.state.ReservationState;
import com.tmps.project.repository.AppUserRepository;
import com.tmps.project.repository.ReservationRepository;
import com.tmps.project.repository.TripRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ReservationFacade {

    private final ReservationRepository reservationRepository;
    private final AppUserRepository userRepository;
    private final TripRepository tripRepository;

    public Reservation newReservation(Long tripId, String username){
        Trip trip = tripRepository.findById(tripId).get();
        AppUser user = userRepository.findByEmail(username).get();
        Reservation reservation = new Reservation(user, trip);
        trip.setAvailablePlaces(trip.getAvailablePlaces() - 1);
        tripRepository.save(trip);
        return reservationRepository.save(reservation);
    }

    public void confirmReservation(Long id){
        Reservation reservation = reservationRepository.getById(id);
        ReservationState reservationState = reservation.getReservationState();
        reservationState.next(reservation);
        reservation.setStatus(reservation.getReservationState().getStatus());
        reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservationsByUsername(String username){
        return reservationRepository.findAllByUserEmail(username);
    }

    public void deleteReservationById(Long id){
        Reservation reservation = reservationRepository.findById(id).get();
        reservationRepository.delete(reservation);
    }
}
