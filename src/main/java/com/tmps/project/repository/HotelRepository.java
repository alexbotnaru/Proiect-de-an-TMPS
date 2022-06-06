package com.tmps.project.repository;

import com.tmps.project.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    Optional<Hotel> findHotelByName(String name);
}
