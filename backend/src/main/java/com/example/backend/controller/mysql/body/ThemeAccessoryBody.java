package com.example.backend.controller.mysql.body;

public class ThemeAccessoryBody {
    private String themeId;
    private String accessoryId;
    private int quantity;

    public ThemeAccessoryBody() {
    }

    public ThemeAccessoryBody(String themeId, String accessoryId, int quantity) {
        this.themeId = themeId;
        this.accessoryId = accessoryId;
        this.quantity = quantity;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(String accessoryId) {
        this.accessoryId = accessoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
