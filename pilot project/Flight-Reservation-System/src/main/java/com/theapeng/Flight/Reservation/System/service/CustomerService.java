package com.theapeng.Flight.Reservation.System.service;

import com.theapeng.Flight.Reservation.System.entity.Customer;
import com.theapeng.Flight.Reservation.System.entity.Order;
import com.theapeng.Flight.Reservation.System.entity.request.CustomerRequestBody;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

public interface CustomerService {
    List<Customer> getAllCustomers();

    Set<Order> getCurrentOrdersForCustomer(Integer customerID);

    void createCustomer(@RequestBody CustomerRequestBody customerRequestBody);

    // add reservation
    // new entity or just update database through the method?
    void addOrder(Integer flightId, Integer seatId, Integer customerId);

    void updateOrder(Integer orderId, Integer seatId);

    void deleteOrder(Integer orderId);
}
