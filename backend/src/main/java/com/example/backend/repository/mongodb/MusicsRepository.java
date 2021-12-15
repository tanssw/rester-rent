package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Musics;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicsRepository extends MongoRepository<Musics, String> {

    @Query(value="{name:?0}")
    List<Musics> findByName(String name);
}
