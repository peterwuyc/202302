package com.theapeng.Flight.Reservation.System.controller;

import com.theapeng.Flight.Reservation.System.entity.Customer;
import com.theapeng.Flight.Reservation.System.entity.Flight;
import com.theapeng.Flight.Reservation.System.entity.Order;
import com.theapeng.Flight.Reservation.System.entity.request.CustomerRequestBody;
import com.theapeng.Flight.Reservation.System.entity.request.FlightRequestBody;
import com.theapeng.Flight.Reservation.System.entity.request.OrderRequestBody;
import com.theapeng.Flight.Reservation.System.service.CustomerService;
import com.theapeng.Flight.Reservation.System.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = null;

        try {
            customers = customerService.getAllCustomers();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        if (customers == null || customers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(customers);
    }


    @GetMapping("/customers/{customerID}/currentOrders")
    public ResponseEntity<Set<Order>> getCurrentOrdersForCustomer(@PathVariable Integer customerID) {
        Set<Order> currentOrders = null;

        try {
            currentOrders = customerService.getCurrentOrdersForCustomer(customerID);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        if (currentOrders == null || currentOrders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(currentOrders);
    }


    @PostMapping("/customers")
    public String createCustomer(@RequestBody CustomerRequestBody customerRequestBody) {
        customerService.createCustomer(customerRequestBody);
        return "Successfully added customer";
    }

    @PostMapping("/customers/{customerID}/newOrder")
    public String createNewOrder(@RequestBody OrderRequestBody orderRequestBody, @PathVariable Integer customerID) {
        customerService.addOrder(orderRequestBody.getFlightId(), orderRequestBody.getSeatNumber(), customerID);
        // todo: return order id
        return "Successfully created new order";
    }

    @PutMapping("/customers/{customerID}")
    public String updateOrder(@RequestParam("orderId") Integer orderId, @RequestParam("seatId") Integer newSeatId) {
        customerService.updateOrder(orderId, newSeatId);
        return String.format("Successfully updated order %d", orderId);
    }

    @DeleteMapping("customers/{customerID}/delete/{orderID}")
    public String deleteOrder(@PathVariable("customerID") Integer customerId, @PathVariable("orderID") Integer orderId) {
        customerService.deleteOrder(orderId);
        return String.format("Successfully delete order %d", orderId);
    }
}
