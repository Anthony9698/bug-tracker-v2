package com.bugtrackerv2.server.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    @GetMapping
    ResponseEntity<?> getGreeting() {
        return new ResponseEntity<>("Live Reload Works woo oooooo", HttpStatus.OK);
    }
}
