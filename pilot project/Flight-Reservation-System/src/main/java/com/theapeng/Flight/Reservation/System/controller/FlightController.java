package com.theapeng.Flight.Reservation.System.controller;

import com.theapeng.Flight.Reservation.System.entity.Flight;
import com.theapeng.Flight.Reservation.System.entity.request.FlightRequestBody;
import com.theapeng.Flight.Reservation.System.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;


    @GetMapping("/flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/flights/{flightID}/availableSeats")
    public int getAvailableSeatsForFlight(@PathVariable Integer flightID){
        return flightService.getAvailableSeatsNumberForFlight(flightID);
    }

    @PostMapping("/flights")
    public String createFlight(@RequestBody FlightRequestBody flightRequestBody) {
        flightService.createFlight(flightRequestBody);
        return "Successfully added flight";
    }
}
