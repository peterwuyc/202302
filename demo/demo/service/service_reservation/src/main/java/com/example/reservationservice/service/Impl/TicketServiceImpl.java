package com.example.reservationservice.service.Impl;


import com.example.reservationservice.entity.User;
import com.example.reservationservice.repository.FlightRepository;
import com.example.reservationservice.repository.UserRepository;
import com.example.reservationservice.service.TicketService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class TicketServiceImpl implements TicketService {
    @Resource
    private FlightRepository flightRepository;

    @Resource
    private UserRepository userRepository;
    @Override
    public int findNumber(String flightId) {
        return flightRepository.findNumberbyId(flightId);
    }

    @Override
    public void bookTicket(User user) {
        flightRepository.updateNumberOfSeats(user.getFlightId());
        userRepository.save(user);
    }

    @Override
    public void removeUser(String username) {
        User user = userRepository.getUserByUsername(username);
        flightRepository.addNumberOfSeats(user.getFlightId());
        userRepository.deleteUserByUsername(username);


    }

    @Override
    public void updateSeatNumber(String username, String flightId, Integer newNumber) {
        User user = userRepository.getUserByUsernameAndFlightId(username,flightId);
        user.setSeat_id(newNumber);
        userRepository.save(user);
    }
}
