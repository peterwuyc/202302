package com.project.service;

import com.project.model.Flights;
import com.project.model.Seats;
import com.project.model.SeatsDTO;
import com.project.repository.FlightsDao;
import com.project.repository.SeatsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatsService {

    @Autowired
    private SeatsDao seatsDao;

    @Autowired
    private SeatsDao seatRepository;

    // Other methods

    public List<Seats> getAvailableSeatsForFlight(Flights flights) {
        // Implement the logic to retrieve available seats for a flight
        List<Seats> availableSeats = seatRepository.findByFlightsAndIsBooked(flights, false);
        return availableSeats;
    }

    public Seats getSeatById(Integer seatId) {
        return seatsDao.findById(seatId)
                .orElseThrow(() -> new RuntimeException("Seat not found"));
    }


    @Autowired
    private FlightsDao flightRepository;

    public Seats createSeat(SeatsDTO seatDTO) {
        Flights flight = flightRepository.findById(seatDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Flight not found"));

        Seats seat = new Seats();
        seat.setSeatNum(seatDTO.getSeatNum());
        seat.setBooked(seatDTO.isBooked());
        seat.setFlights(flight);

        return seatsDao.save(seat);
    }


    // Other methods
}