package com.project.repository;

import com.project.model.Flights;
import com.project.model.Seats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatsDao extends JpaRepository<Seats, Integer> {

      List<Seats> findByFlights(Flights flights);

      List<Seats> findByFlightsAndIsBooked(Flights flights, boolean isBooked);



}
