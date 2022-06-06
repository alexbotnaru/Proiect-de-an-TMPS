package com.tmps.project.model.state;

import com.tmps.project.model.Reservation;

public class PaidReservationState implements ReservationState {
    private final String status = "Paid";

    @Override
    public void next(Reservation reservation) {
        System.out.println("The trip is paid");
    }

    @Override
    public void prev(Reservation reservation) {
        reservation.setReservationState(new ConfirmedReservationState());
    }

    @Override
    public String getStatus() {
        return status;
    }
}
