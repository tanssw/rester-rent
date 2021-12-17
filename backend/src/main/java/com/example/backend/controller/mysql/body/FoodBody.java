package com.example.backend.controller.mysql.body;

public class FoodBody {
    private String fname;
    private int capacity;
    private String size;
    private String menus;
    private int price;

    public FoodBody() {
    }

    public FoodBody(String fname, String menus) {
        this.fname = fname;
        this.menus = menus;
    }

    public FoodBody(String fname, int capacity, String size, String menus, int price) {
        this.fname = fname;
        this.capacity = capacity;
        this.size = size;
        this.menus = menus;
        this.price = price;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
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

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
