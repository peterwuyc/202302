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
public class Customer {
    @Id
    private Integer id;
    private String username;
    private String email;
    private String phoneNumber;

    // reservation? order?
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    Set<Order> OrderSet = new HashSet<>();

}
