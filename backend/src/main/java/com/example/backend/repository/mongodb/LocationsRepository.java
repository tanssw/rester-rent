package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Locations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationsRepository extends MongoRepository<Locations, String> {
}
