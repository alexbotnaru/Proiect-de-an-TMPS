package com.tmps.project.model;

import com.tmps.project.model.state.ReservationState;
import com.tmps.project.model.state.NewReservationState;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationId;
    @Transient
    private ReservationState reservationState = new NewReservationState();
    @ManyToOne
    private AppUser user;
    @ManyToOne
    private Trip trip;
    private String status;

    public Reservation(AppUser user, Trip trip) {
        this.user = user;
        this.trip = trip;
    }

    public Reservation() {

    }
}
