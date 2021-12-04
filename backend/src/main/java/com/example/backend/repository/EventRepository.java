package com.example.backend.repository;

import com.example.backend.pojo.ItEvent;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends MongoRepository<ItEvent, String> {
}
