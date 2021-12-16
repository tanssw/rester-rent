package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TokenRepository extends MongoRepository<Token, String> {

    @Query(value = "{userId: '?0', token: '?1'}")
    Token findByUserAndToken(String userId, String token);

    @Query(value = "{userId: '?0', token: '?1'}")
    Optional<Token> findByUserAndTokenToAuth(String userId, String token);

}
