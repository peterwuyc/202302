package com.example.reservationservice.repository;

import com.example.reservationservice.entity.Flight;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

public interface FlightRepository extends JpaRepository<Flight,Integer> {
    @Query(name = "findNumberById", nativeQuery = true, value =
    "select number_of_seats from flight where flight_Id =:flightId")
    int findNumberbyId(@Param("flightId") String flightId);

    @Modifying
    @Transactional
    @Query(name = "updateNumberOfSeats",nativeQuery = true,value =
    "update flight SET number_of_seats=number_of_seats-1 where flight_Id=:flightId")
    void updateNumberOfSeats(@Param("flightId") String flightId);

    @Modifying
    @Transactional
    @Query(name = "addNumberOfSeats",nativeQuery = true,value =
            "update flight SET number_of_seats=number_of_seats+1 where flight_Id=:flightId")
    void addNumberOfSeats(@Param("flightId") String flightId);

    Flight getFlightByFlightId(String flightId);

    @Query(value = "select * from flight where flight_name=:flightName",nativeQuery = true)
    List<Flight> checkAllFlights(@Param("flightName") String flightName, Pageable pageable);
}
