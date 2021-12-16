package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.User;
import com.example.backend.requestBody.AuthData;
import com.example.backend.service.mongodb.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value="/auth", method = RequestMethod.POST)
    public ResponseEntity authenication(@RequestBody AuthData authData) {

        String accessToken = authData.getAccessToken();
        String email = authData.getEmail();
        String googleId = authData.getGoogleId();

        User user = new User(
                null,
                authData.getName(),
                email,
                googleId
        );

//        Check if user's Google account is valid.
        if (!authenticationService.isValidGoogleAccount(accessToken, googleId, email)
        || !authenticationService.isWhitelist(email)) {
            return new ResponseEntity("Authentication Failed", HttpStatus.FORBIDDEN);
        }

//        Get user data (If not found, then add it in)
        User result = authenticationService.getUser(googleId);
        if (result == null) {
            result = authenticationService.addUser(user);
        }

        System.out.println(result);

        return new ResponseEntity("This will be a token.", HttpStatus.OK);

    }

    @RequestMapping(value="/token", method = RequestMethod.POST)
    public void generateToken() {}

    @RequestMapping(value="/", method = RequestMethod.DELETE)
    public  void deleteToken() {}
}
