package com.theapeng.Flight.Reservation.System.service;

import com.theapeng.Flight.Reservation.System.entity.Customer;
import com.theapeng.Flight.Reservation.System.entity.request.CustomerRequestBody;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();

    void createCustomer(@RequestBody CustomerRequestBody customerRequestBody);

    // add reservation
    // new entity or just update database through the method?
    void addOrder(Integer flightId, Integer seatId, Integer customerId);
}
