package com.theapeng.Flight.Reservation.System.repository;

import com.theapeng.Flight.Reservation.System.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
}
