package com.theapeng.Flight.Reservation.System.repository;

import com.theapeng.Flight.Reservation.System.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
