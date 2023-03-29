package com.example.reservationservice.service.Impl;


import com.example.reservationservice.entity.Flight;
import com.example.reservationservice.entity.User;
import com.example.reservationservice.repository.FlightRepository;
import com.example.reservationservice.repository.UserRepository;
import com.example.reservationservice.service.TicketService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public boolean bookTicket(User user) {
        String flightId = user.getFlightId();
        Flight flight = flightRepository.getFlightByFlightId(flightId);
        if(flight.getNumber_of_seats()<1){
          return false;
        }else{
            flightRepository.updateNumberOfSeats(flightId);
            userRepository.save(user);
            return true;
        }

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

    @Override
    public List<Flight> checkAllFlights(String flightName,int page,int limit) {
        Pageable pageable = PageRequest.of(page,limit);
        return flightRepository.checkAllFlights(flightName,pageable);
    }
}
