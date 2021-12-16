package com.example.backend.requestBody;

import java.io.Serializable;

public class AuthTokenData implements Serializable {
    private String token;
    private String userId;

    public AuthTokenData(String token, String userId) {
        this.token = token;
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
