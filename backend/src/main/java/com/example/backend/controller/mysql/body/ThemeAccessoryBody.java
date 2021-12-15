package com.example.backend.controller.mysql.body;

public class ThemeAccessoryBody {
    private int themeId;
    private int accessoryId;
    private int quantity;

    public ThemeAccessoryBody() {
    }

    public ThemeAccessoryBody(int themeId, int accessoryId, int quantity) {
        this.themeId = themeId;
        this.accessoryId = accessoryId;
        this.quantity = quantity;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getAccessoryId() {
        return accessoryId;
    }

    public void setAccessoryId(int accessoryId) {
        this.accessoryId = accessoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
