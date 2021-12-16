package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@Document("tokens")
public class Token {
    @Id
    private String _id;
    private String userId;
    private String token;
    private Date createAt;

    public Token() {}

    public Token(String _id, String userId, String token, Date createAt) {
        this._id = _id;
        this.userId = userId;
        this.token = token;
        this.createAt = createAt;
    }
}
