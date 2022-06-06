package com.tmps.project.model.state;

import com.tmps.project.model.Reservation;

public class ConfirmedReservationState implements ReservationState{

    private final String status = "Confirmed";

    @Override
    public void next(Reservation reservation) {
        reservation.setReservationState(new PaidReservationState());
    }

    @Override
    public void prev(Reservation reservation) {
        reservation.setReservationState(new NewReservationState());
    }

    @Override
    public String getStatus() {
        return status;
    }
}
