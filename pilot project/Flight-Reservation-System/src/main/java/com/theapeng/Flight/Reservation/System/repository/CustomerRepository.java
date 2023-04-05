package com.theapeng.Flight.Reservation.System.repository;

import com.theapeng.Flight.Reservation.System.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
