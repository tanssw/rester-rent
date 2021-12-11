package com.example.backend.controller.Mysql.Body;

import org.bson.json.JsonObject;

public class FoodBody {
    private String name;
    private int capacity;
    private String size;
    private JsonObject menus;
    private int price;

    public FoodBody() {
    }

    public FoodBody(String name, int capacity, String size, JsonObject menus, int price) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.menus = menus;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public JsonObject getMenus() {
        return menus;
    }

    public void setMenus(JsonObject menus) {
        this.menus = menus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
