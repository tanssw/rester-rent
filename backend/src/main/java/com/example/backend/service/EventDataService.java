package com.example.backend.service;

import com.example.backend.pojo.ItEvent;
import com.example.backend.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDataService {

    @Autowired
    private EventRepository eventRepository;

    public EventDataService(EventRepository repository) {
        this.eventRepository = repository;
    }

    public List<ItEvent> getAllEvents() {
        return eventRepository.findAll();
    }
}
