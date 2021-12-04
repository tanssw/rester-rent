package com.example.backend.controller;

import com.example.backend.pojo.ItEvent;
import com.example.backend.service.EventDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventDataController {

    @Autowired
    private EventDataService eventDataService;

    @GetMapping("/")
    public ResponseEntity<?> allEvents() {
        List<ItEvent> events = eventDataService.getAllEvents();

        return ResponseEntity.ok(events);
    }

    @GetMapping("/health")
    public String HealthCheck() {
        return "Healthy";
    }

}
