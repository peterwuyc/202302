package com.theapeng.Flight.Reservation.System.service;

import com.theapeng.Flight.Reservation.System.entity.Customer;
import com.theapeng.Flight.Reservation.System.entity.Flight;
import com.theapeng.Flight.Reservation.System.entity.Order;
import com.theapeng.Flight.Reservation.System.entity.request.CustomerRequestBody;
import com.theapeng.Flight.Reservation.System.repository.CustomerRepository;
import com.theapeng.Flight.Reservation.System.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightService flightService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Set<Order> getCurrentOrdersForCustomer(Integer customerID) {
        return customerRepository.findById(customerID).get().getOrderSet();
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

    @Override
    @Transactional
    public void addOrder(Integer flightId, Integer seatId, Integer customerId) {
        Optional<Customer> customerOptional = customerRepository.findById(customerId);
        Optional<Flight> flightOptional = flightService.findById(flightId);
        try {
            Customer customer = customerOptional.get();
            Flight flight = flightOptional.get();
            if (flightService.getAvailableSeatsForFlight(flightId).contains(seatId)) {
                // create new order
                Order newOrder = Order.builder()
                        .flight(flight)
                        .customer(customer)
                        .seatNumber(seatId)
                        .build();
                customer.getOrderSet().add(newOrder);

                // update order repository
                orderRepository.save(newOrder);

                // update flight repository
                flightService.reserveSeatForFlight(flightId, seatId);
                customerRepository.save(customer);
            } else
                throw new RuntimeException("Seat Not Available");
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("Customer %d create order for flight %d seat %d failed. Cause: %s. Error message: %s",
                            customerId, flightId, seatId, e.getCause(), e.getMessage()));
        }
    }

    @Override
    public void updateOrder(Integer orderId, Integer seatId) {
        try {
            Order order = orderRepository.findById(orderId).get();
            Customer customer = order.getCustomer();
            Flight flight = order.getFlight();
            Integer prevSeatNumber = order.getSeatNumber();

            flightService.cancelSeatForFlight(flight.getId(), prevSeatNumber);
            flightService.reserveSeatForFlight(flight.getId(), seatId);

            order.setSeatNumber(seatId);
            orderRepository.save(order);
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new RuntimeException(
                    String.format("Update order %d failed. Cause: %s. Error message: %s",
                            orderId, e.getCause(), e.getMessage()));
        }
    }

    @Override
    public void deleteOrder(Integer orderId) {
        try {
            Order order = orderRepository.findById(orderId).get();
            Customer customer = order.getCustomer();
            Flight flight = order.getFlight();

            flightService.cancelSeatForFlight(flight.getId(), order.getSeatNumber());
            customer.getOrderSet().remove(order);
            orderRepository.deleteById(orderId);
            customerRepository.save(customer);
        } catch(Exception e) {
            throw new RuntimeException(
                    String.format("Cancel order %d failed. Cause: %s. Error message: %s",
                            orderId, e.getCause(), e.getMessage()));
        }
    }
}
