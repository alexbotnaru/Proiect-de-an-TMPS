package com.tmps.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trip_id")
    private Long id;
    private String name;
    private Double price;
    private Integer nrOfDays;
    private String description;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false )
    private Hotel hotel;
    private Integer availablePlaces;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id", nullable = false )
    private Country country;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;
//    @OneToMany(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    private List<Reservation> reservations;

    public Trip(String name, Double price, Integer nrOfDays, String description, Hotel hotel, Integer availablePlaces, Country country) {
        this.name = name;
        this.price = price;
        this.nrOfDays = nrOfDays;
        this.description = description;
        this.hotel = hotel;
        this.availablePlaces = availablePlaces;
        this.country = country;
    }
}
