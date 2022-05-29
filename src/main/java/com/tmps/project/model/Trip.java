package com.tmps.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer nrOfDays;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    private Hotel hotel;
    private Integer availablePlaces;
    @OneToOne(cascade = CascadeType.ALL)
    private Country country;

    public Trip(Double price, Integer nrOfDays, Hotel hotel, Integer availablePlaces, String description, Country country) {
        this.price = price;
        this.nrOfDays = nrOfDays;
        this.hotel = hotel;
        this.availablePlaces = availablePlaces;
        this.description = description;
        this.country = country;
    }
}
