package com.example.backend.pojo.Mysql;


import javax.persistence.*;
import java.io.Serializable;

@Entity

public class ThemeAccessory implements Serializable {

    @EmbeddedId
    private CompositeThemeAccessory id;

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
