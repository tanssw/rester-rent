package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Locations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationsRepository extends MongoRepository<Locations, String> {
}
