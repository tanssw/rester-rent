package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Locations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LocationsRepository extends MongoRepository<Locations, String> {

    @Query(value="{name:?0}")
    List<Locations> findByName(String name);
}
