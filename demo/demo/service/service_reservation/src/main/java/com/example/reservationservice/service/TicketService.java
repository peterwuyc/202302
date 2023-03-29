package com.example.reservationservice.service;

import com.example.reservationservice.entity.Flight;
import com.example.reservationservice.entity.User;

import java.util.List;

public interface TicketService {
    /**
     * input the flightId and return the number of seats
     *
     */
    int findNumber(String flightId);

    boolean bookTicket(User user);

    void removeUser(String username);

    void updateSeatNumber(String username, String flightId, Integer newNumber);

    List<Flight> checkAllFlights(String flightName,int page,int limit);
}
