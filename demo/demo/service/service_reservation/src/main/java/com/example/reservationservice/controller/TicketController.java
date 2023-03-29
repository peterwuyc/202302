package com.example.reservationservice.controller;

import com.example.commonutils.R;
import com.example.reservationservice.entity.User;
import com.example.reservationservice.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation/reservation-ticket")
public class TicketController {
//1. check how many seats still available
    @Autowired
    private TicketService ticketService;


    @GetMapping("checkTickets/{flightId}")
    public R checkTickets(@PathVariable String flightId){
        int number = ticketService.findNumber(flightId);
        return R.ok().data("number", number);
    }

//    2. User can book seat with seat number
    @PostMapping("bookTicket")
    public R bookTicket(User user){
        ticketService.bookTicket(user);
        return R.ok();
    }

//    3. User can update seat number
    @PostMapping("updateBySeatNumber/{username}/{flightId}/{newNumber}")
    public R updateBySeatNumber(@PathVariable String username, @PathVariable String flightId, @PathVariable Integer newNumber){
        ticketService.updateSeatNumber(username,flightId,newNumber);
        return R.ok();
    }

//    4. User can do cancellation
    @DeleteMapping("{username}")
    public R deleteUser(@PathVariable String username){
        ticketService.removeUser(username);
        return R.ok();
    }
}
