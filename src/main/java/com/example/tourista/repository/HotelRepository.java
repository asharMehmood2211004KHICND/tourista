package com.example.tourista.repository;

import com.example.tourista.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel,Long> {

    @Query("SELECT h FROM Hotel h WHERE h.location = :location AND h.experience = :experience AND h.pool = :pool")
    List<Hotel> findByLocationAndExperienceAndPool(@Param("location") String location, @Param("experience") String experience, @Param("pool") String pool);
}
