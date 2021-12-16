package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Query(value="{googleId: '?0'}")
    public User findByGoogleId(String googleId);

}
