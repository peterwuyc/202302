package com.theapeng.Flight.Reservation.System.service;

import com.theapeng.Flight.Reservation.System.entity.Customer;
import com.theapeng.Flight.Reservation.System.entity.Flight;
import com.theapeng.Flight.Reservation.System.entity.Order;
import com.theapeng.Flight.Reservation.System.entity.request.CustomerRequestBody;
import com.theapeng.Flight.Reservation.System.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightService flightService;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void createCustomer(@RequestBody CustomerRequestBody customerRequestBody) {
        Customer customer = Customer.builder()
                .id(customerRequestBody.getId())
                .username(customerRequestBody.getUsername())
                .email(customerRequestBody.getEmail())
                .phoneNumber(customerRequestBody.getPhoneNumber())
                .build();
        customerRepository.save(customer);
    }

    // add reservation
    // new entity or just update database through the method?
    @Override
    public void addOrder(Integer flightId, Integer seatId, Integer customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Flight> flightOptional = flightService.findById(flightId);
        if(customerOptional.isPresent() && flightOptional.isPresent()){
            Customer customer = customerOptional.get();
            Flight flight = flightOptional.get();
            Set<Order> orders = customer.getOrderSet();
            if(flightService.getAvailableSeatsForFlight(flightId).contains(seatId)){
                // create new order
                // update three tables?
                orders.add(Order.builder()
                        .flight(flight)
                        .customer(customer)
                        .seatNumber(seatId)
                        .build());
                // todo: update flight repository

            } else throw new RuntimeException("Seat Not Available");

            customer.setOrderSet(orders);
            customerRepository.save(customer);

        }else throw new RuntimeException("no such flight");
    }
}
