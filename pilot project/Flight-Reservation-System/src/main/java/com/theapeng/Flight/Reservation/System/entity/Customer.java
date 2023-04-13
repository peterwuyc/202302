package com.theapeng.Flight.Reservation.System.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private Integer id;
    private String username;
    private String email;
    private String phoneNumber;

    // reservation? order?
//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<Order> orderSet = new HashSet<>();

}
