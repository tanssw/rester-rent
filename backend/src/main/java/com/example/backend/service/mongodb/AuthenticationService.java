package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.User;
import com.example.backend.repository.mongodb.UserRepository;
import com.example.backend.requestBody.GoogleAccountData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    private static final String[] WHITELIST_DOMAIN = {"it.kmitl.ac.th"};

    public void addUser(User user) {

    }

    public boolean isUserExist(String googleId) {
        try {
            User user = userRepository.findByGoogleId(googleId);
            return user != null;
        } catch (Exception e) {
            return false;
        }
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

}
