package com.example.backend.controller.mongodb;

import com.example.backend.requestBody.AuthData;
import com.example.backend.service.mongodb.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value="/auth", method = RequestMethod.POST)
    public void authenication(@RequestBody AuthData authData) {
        System.out.println(authData.toString());
    }

    @RequestMapping(value="/token", method = RequestMethod.POST)
    public void generateToken() {}

    @RequestMapping(value="/", method = RequestMethod.DELETE)
    public  void deleteToken() {}
}
