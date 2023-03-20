package com.example.pilot.controller;

import com.example.pilot.entity.request.CardRequestBody;
import com.example.pilot.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CardController {

    @Autowired
    private CardService cardService;
    @PostMapping("/v1/card")
    public String createCard(@RequestBody CardRequestBody cardRequestBody){
        cardService.createCard(cardRequestBody);
        return "success!";
    }

    @PutMapping("/v1/card")
    public String updateCard(@RequestParam("studentId")Integer studentId,
                             @RequestParam("num")Integer num){
        cardService.add(studentId,num);
        return "success!";
    }
}
