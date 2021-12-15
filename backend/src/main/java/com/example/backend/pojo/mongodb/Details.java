package com.example.backend.pojo.mongodb;

public class Details {
    private String theme;
    private String food;
    private String music;
    private String location;

    public Details(String theme, String food, String music, String location) {
        this.theme = theme;
        this.food = food;
        this.music = music;
        this.location = location;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
