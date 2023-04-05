package com.theapeng.Flight.Reservation.System.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
public class Flight {
    @Id
    private Integer id;

    private int availableSeatNumber;

    private boolean[] seats = new boolean[10];
    //private Set<Seat> seats = new HashSet<>();

    @ManyToMany
    Set<Order> orders = new HashSet<>();

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", availableSeatNumber=" + availableSeatNumber +
                '}';
    }
}
