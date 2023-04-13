package com.theapeng.Flight.Reservation.System.service;

import com.theapeng.Flight.Reservation.System.entity.Flight;
import com.theapeng.Flight.Reservation.System.entity.request.FlightRequestBody;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public interface FlightService {

    Optional<Flight> findById(Integer flightId);

    void createFlight(@RequestBody FlightRequestBody flightRequestBody);

    List<Flight> getAllFlights();

    int getAvailableSeatsNumberForFlight(Integer flightId);

    List<Integer> getAvailableSeatsForFlight(Integer flightId);

    void reserveSeatForFlight(Integer flightId, Integer seatId);

    void cancelSeatForFlight(Integer flightId, Integer seatId);
}
