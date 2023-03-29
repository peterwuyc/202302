package com.example.reservationservice.service;

import com.example.reservationservice.entity.User;

public interface TicketService {
    /**
     * input the flightId and return the number of seats
     *
     */
    int findNumber(String flightId);

    void bookTicket(User user);

    void removeUser(String username);

    void updateSeatNumber(String username, String flightId, Integer newNumber);
}
