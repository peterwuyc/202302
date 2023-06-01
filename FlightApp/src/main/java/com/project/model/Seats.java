package com.project.model;

import lombok.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Getter
@Setter
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatID;

    @Column(name = "seat_num")
    private String seatNum;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Flights flights;

    private boolean isBooked;
}
