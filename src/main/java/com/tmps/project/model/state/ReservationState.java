package com.tmps.project.model.state;

import com.tmps.project.model.Reservation;

public interface ReservationState {
    void next(Reservation reservation);
    void prev(Reservation reservation);
    String getStatus();
}
