package com.example.backend.pojo.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("locations")
public class Locations {
    @Id
    private String _id;
    private String name;
    private String image;
    private int capacity;
    private int price;
    private String size;
    private List<String> facilities;
    private String details_room;
    private String details_music;

    public Locations() {
    }

    public Locations(String _id) {
        this._id = _id;
    }

    public Locations(String name, String image, int capacity, int price, String size, List<String> facilities, String details_room, String details_music) {
        this.name = name;
        this.image = image;
        this.capacity = capacity;
        this.price = price;
        this.size = size;
        this.facilities = facilities;
        this.details_room = details_room;
        this.details_music = details_music;
    }

    public Locations(String _id, String name, String image, int capacity, int price, String size, List<String> facilities, String details_room, String details_music) {
        this._id = _id;
        this.name = name;
        this.image = image;
        this.capacity = capacity;
        this.price = price;
        this.size = size;
        this.facilities = facilities;
        this.details_room = details_room;
        this.details_music = details_music;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public List<String> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<String> facilities) {
        this.facilities = facilities;
    }

    public String getDetails_room() {
        return details_room;
    }

    public void setDetails_room(String details_room) {
        this.details_room = details_room;
    }

    public String getDetails_music() {
        return details_music;
    }

    public void setDetails_music(String details_music) {
        this.details_music = details_music;
    }
}
