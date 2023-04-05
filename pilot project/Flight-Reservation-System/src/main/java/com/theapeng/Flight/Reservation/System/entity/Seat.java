package com.theapeng.Flight.Reservation.System.entity;

import jakarta.persistence.*;


public class Seat {

    private Integer seatNumber;

//    @ManyToOne
//    @JoinColumn(name = "flight_id")
//    private Flight flight;
    private Integer flightId;
    private boolean isAvailable;

    public Seat(Integer seatNumber) {
        this.seatNumber = seatNumber;
        this.isAvailable = true;
    }
}
