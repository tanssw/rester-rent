package com.example.backend.controller.mysql.response;

import java.util.ArrayList;
import java.util.List;

public class FoodResponse {
    private String fName;
    private String menus;
    private List<Options> options = new ArrayList<>();

    public FoodResponse() {
    }

    public FoodResponse(String fName) {
        this.fName = fName;
    }

    public FoodResponse(String fName, String menus) {
        this.fName = fName;
        this.menus = menus;
    }

    public FoodResponse(String fName, String menus, List<Options> options) {
        this.fName = fName;
        this.menus = menus;
        this.options = options;
    }

    public boolean isMenuEmpty() {
        return this.menus == null;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getMenus() {
        return menus;
    }

    public void setMenus(String menus) {
        this.menus = menus;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public void addOptions(Options option) {
        this.options.add(option);
    }
}
