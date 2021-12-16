package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Document("tokens")
public class Token {
    @Id
    private String _id;
    private String userId;
    private String token;
    @Indexed(name = "createdAt", expireAfterSeconds = 60)
    private LocalDateTime createdAt;

    public Token() {}

    public Token(String _id, String userId, String token, LocalDateTime createdAt) {
        this._id = _id;
        this.userId = userId;
        this.token = token;
        this.createdAt = createdAt;
    }
}
