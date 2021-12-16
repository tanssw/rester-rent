package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document("users")
public class User {
    @Id
    private String _id;
    private String name;
    private String email;
    private String googleId;

    public User() {}

    public User(String _id, String name, String email, String googleId) {
        this._id = _id;
        this.name = name;
        this.email = email;
        this.googleId = googleId;
    }
}
