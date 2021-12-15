package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Document("musics")
public class Musics {

    @Id
    private String _id;
    private String name;
    private String image;
    private List date;
    private int price;
    private String type;
    private String details;

    public Musics() {
    }

    public Musics(String _id) {
        this._id = _id;
    }

    public Musics(String name, String image, List date, int price, String type, String details) {
        this.name = name;
        this.image = image;
        this.date = date;
        this.price = price;
        this.type = type;
        this.details = details;
    }

    public Musics(String _id, String name, String image, String details) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.details = details;
    }

    public Musics(String _id, String name, String image, List date, int price, String type, String details) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.date = date;
        this.price = price;
        this.type = type;
        this.details = details;
    }
}
