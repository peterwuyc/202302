package com.theapeng.Flight.Reservation.System.service;

import com.theapeng.Flight.Reservation.System.entity.Flight;
import com.theapeng.Flight.Reservation.System.entity.request.FlightRequestBody;
import com.theapeng.Flight.Reservation.System.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Optional<Flight> findById(Integer flightId){
        try{
            return flightRepository.findById(flightId);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Flight findByID %d failed", flightId));
        }
    }

    @Override
    public void createFlight(@RequestBody FlightRequestBody flightRequestBody) {
//        Flight flight = new Flight();
//        flight.setId(flightRequestBody.getId());
//        flight.setAvailableSeatNumber(10);
//        flight.setSeats(new boolean[10]);
//
        Flight flight = Flight.builder()
                .id(flightRequestBody.getId())
                .availableSeatNumber(10)
                .seats(new boolean[10])
                .build();
        flightRepository.save(flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public int getAvailableSeatsNumberForFlight(Integer flightId) {
        return flightRepository.findById(flightId).get().getAvailableSeatNumber();
    }

    @Override
    public List<Integer> getAvailableSeatsForFlight(Integer flightId) {
        try{
            boolean[] seats = flightRepository.findById(flightId).get().getSeats();
            // scan through seats, find empty seats
            return IntStream.range(0, 10)
                    .filter(i -> !seats[i])
                    .boxed()
                    .collect(Collectors.toList());

        } catch (final Exception e){
            throw e;
        }
    }

    @Override
    public void reserveSeatForFlight(Integer flightId, Integer seatId){
        try{
            Flight flight = flightRepository.findById(flightId).get();
            assert(!flight.getSeats()[seatId]);
            flight.getSeats()[seatId] = true;
            flightRepository.save(flight);
        }catch (Exception e){
            throw new RuntimeException("Seat Not Available");
        }
    }

    @Override
    public void cancelSeatForFlight(Integer flightId, Integer seatId) {
        try{
            Flight flight = flightRepository.findById(flightId).get();
            assert(flight.getSeats()[seatId]);
            flight.getSeats()[seatId] = false;
            flightRepository.save(flight);
        }catch (Exception e) {
            throw new RuntimeException("Cannot cancel order for seat that is not reserved.");
        }
    }
}
