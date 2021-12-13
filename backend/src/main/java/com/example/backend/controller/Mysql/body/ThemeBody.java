package com.example.backend.controller.Mysql.body;

public class ThemeBody {
    private String name;
    private int price;
    private String image;
    private String details;

    public ThemeBody(String name, int price, String image, String details) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
