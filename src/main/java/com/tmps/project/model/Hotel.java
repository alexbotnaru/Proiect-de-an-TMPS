package com.tmps.project.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
@Data
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotel_id")
    private Long id;

    private String name;
    private String city;
    private Integer nrStars;

}
