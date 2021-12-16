package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.User;
import com.example.backend.repository.mongodb.TokenRepository;
import com.example.backend.repository.mongodb.UserRepository;
import com.example.backend.requestBody.GoogleAccountData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        System.out.println(uuid);
        return uuid.toString();
    }



}
