package com.tmps.project.model.state;

import com.tmps.project.model.Reservation;

public class NewReservationState implements ReservationState{
    private final String status = "New";
    @Override
    public void next(Reservation reservation) {
        reservation.setReservationState(new ConfirmedReservationState());
    }

    @Override
    public void prev(Reservation reservation) {
        System.out.println(status);
    }

    @Override
    public String getStatus() {
        return status;
    }
}
