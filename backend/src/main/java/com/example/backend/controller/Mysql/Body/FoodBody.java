package com.example.backend.controller.Mysql.Body;

public class FoodBody {
    private String name;
    private int capacity;
    private String size;

    public FoodBody() {
    }

    public FoodBody(String name, int capacity, String size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
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
}
