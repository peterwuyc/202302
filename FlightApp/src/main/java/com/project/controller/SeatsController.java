package com.project.controller;

import com.project.model.Seats;
import com.project.model.SeatsDTO;
import com.project.service.SeatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seats")
public class SeatsController {

    @Autowired
    private SeatsService seatService;

    @GetMapping("/{id}")
    public ResponseEntity<Seats> getSeatById(@PathVariable("id") Integer seatId) {
        Seats seat = seatService.getSeatById(seatId);
        return ResponseEntity.ok(seat);
    }

    @PostMapping("/addnewseats")
    public ResponseEntity<Seats> createSeat(@RequestBody SeatsDTO seatDTO) {
        Seats seat = seatService.createSeat(seatDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(seat);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Seats> updateSeat(@PathVariable("id") Integer seatId, @RequestBody SeatsDTO seatDTO) {
//        Seats seat = seatService.updateSeat(seatId, seatDTO);
//        return ResponseEntity.ok(seat);
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteSeat(@PathVariable("id") Integer seatId) {
//        seatService.deleteSeat(seatId);
//        return ResponseEntity.noContent().build();
//    }

    // Other methods as needed
}
