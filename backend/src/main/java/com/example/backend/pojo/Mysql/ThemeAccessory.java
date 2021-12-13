package com.example.backend.pojo.Mysql;


import javax.persistence.*;

@Entity
public class ThemeAccessory {

    @EmbeddedId
    private CompositeThemeAccessory id;

//    @ManyToOne
//    @MapsId("THEME_ID")
//    @JoinColumn(name = "theme_id")
//    Theme theme;
//
//    @ManyToOne
//    @MapsId("ACCESSORY_ID")
//    @JoinColumn(name = "ID")
//    Accessory accessory;

    private int QUANTITY;

    public ThemeAccessory() {
    }

    public ThemeAccessory(CompositeThemeAccessory id, int QUANTITY) {
        this.id = id;
        this.QUANTITY = QUANTITY;
    }

    public CompositeThemeAccessory getId() {
        return id;
    }

    public void setId(CompositeThemeAccessory id) {
        this.id = id;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }
}
