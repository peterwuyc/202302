package com.example.reservationservice.entity;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "flight")
@Data
public class Flight{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private Integer number_of_seats;
    @Column
    private String flightId;


}
