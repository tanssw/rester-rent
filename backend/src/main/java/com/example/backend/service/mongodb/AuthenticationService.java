package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.Token;
import com.example.backend.pojo.mongodb.User;
import com.example.backend.repository.mongodb.TokenRepository;
import com.example.backend.repository.mongodb.UserRepository;
import com.example.backend.requestBody.GoogleAccountData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenRepository tokenRepository;

    private static final String[] WHITELIST_DOMAIN = {"it.kmitl.ac.th"};

    public User getUser(String googleId) {
        return userRepository.findByGoogleId(googleId);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public boolean isValidGoogleAccount(String accessToken, String googleId, String email) {

        GoogleAccountData accountData = WebClient.create()
                .post()
                .uri("https://www.googleapis.com/oauth2/v1/tokeninfo?access_token=" + accessToken)
                .retrieve()
                .bodyToMono(GoogleAccountData.class)
                .block();

        return accountData.getEmail().equals(email) && accountData.getUser_id().equals(googleId);
    }

    public boolean isWhitelist(String email) {
        String domain = email.split("@")[1];
        boolean isValid = Arrays.asList(WHITELIST_DOMAIN).contains(domain);
        return isValid;
    }

//    Generate token using UUIDv4
    public String generateToken(String userId) {

        UUID uuid = UUID.randomUUID();

        LocalDateTime current = LocalDateTime.now();

        Token token = new Token(null, userId, uuid.toString(), current);
        tokenRepository.save(token);

        return uuid.toString();
    }

    public boolean removeToken(String userId, String token) {
        Token document = tokenRepository.findByUserAndToken(userId, token);
        try {
            System.out.println(document);
            tokenRepository.delete(document);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
