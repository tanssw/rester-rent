package com.example.backend.controller.mysql.response;

import java.util.ArrayList;
import java.util.List;

public class ThemeAccessoryResponse {
    private String id;
    private String name;
    private String image;
    private String detils;
    private int price;
    private List<AccessoryItems> accessories = new ArrayList<>();

    public ThemeAccessoryResponse() {
    }

    public ThemeAccessoryResponse(String id) {
        this.id = id;
    }

    public ThemeAccessoryResponse(String id, String name, String image, String detils, int price, List<AccessoryItems> accessories) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.detils = detils;
        this.price = price;
        this.accessories = accessories;
    }

    public void addAccessory(AccessoryItems accessoryItems) {
        this.accessories.add(accessoryItems);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDetils() {
        return detils;
    }

    public void setDetils(String detils) {
        this.detils = detils;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<AccessoryItems> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<AccessoryItems> accessories) {
        this.accessories = accessories;
    }
}
