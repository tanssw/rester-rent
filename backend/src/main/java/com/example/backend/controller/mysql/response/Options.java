package com.example.backend.controller.mysql.response;

public class Options {
    private String id;
    private int capacity;
    private int price;
    private String size;

    public Options(String id, int capacity, int price, String size) {
        this.id = id;
        this.capacity = capacity;
        this.price = price;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
