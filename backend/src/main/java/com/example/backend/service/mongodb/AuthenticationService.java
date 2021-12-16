package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.User;
import com.example.backend.repository.mongodb.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;

@Service
public class AuthenticationService {

    @Autowired
    private UsersRepository usersRepository;

    private static final String[] WHITELIST_DOMAIN = {"it.kmitl.ac.th"};

    public void addUser(User user) {

    }

    public boolean isUserExist(String googleId) {
        return true;
    }

    public boolean isValidGoogleAccount(String accessToken, String googleId, String emal) {

        Object accountData = WebClient.create()
                .post()
                .uri("https://www.googleapis.com/oauth2/v1/tokeninfo?access_token=" + accessToken)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

        System.out.println(accountData);

        return true;
    }

    public boolean isWhitelist(String email) {
        String domain = email.split("@")[1];
        boolean isValid = Arrays.asList(WHITELIST_DOMAIN).contains(domain);
        return isValid;
    }

}
