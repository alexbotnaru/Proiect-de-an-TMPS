package com.tmps.project.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Country {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    protected Long id;
    @Column(nullable = false)
    protected String name;
    @Column(nullable = false)
    protected String currency;

    public Country(Long id, String name, String currency) {
        this.id = id;
        this.name = name;
        this.currency = currency;
    }
}
