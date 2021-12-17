package com.example.backend.service.mongodb;

import com.example.backend.repository.mongodb.TokenRepository;
import com.example.backend.requestBody.AuthTokenData;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AuthorizedService {

    @Autowired
    private TokenRepository tokenRepository;

    @RabbitListener(queues = "AuthQueue")
    public boolean isAuthorized(AuthTokenData authTokenData) {
        return !tokenRepository.findByUserAndTokenToAuth(authTokenData.getUserId(), authTokenData.getToken()).isEmpty();
    }

}
