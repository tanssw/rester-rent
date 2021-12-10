package com.example.backend.pojo.Mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeTheme_Accessory.class)
public class Theme_Accessory {
    @Id
    private String THEME_ID;
    @Id
    private String ACCESSORY_ID;
    private int QUANTITY;

    public String getTHEME_ID() {
        return THEME_ID;
    }

    public void setTHEME_ID(String THEME_ID) {
        this.THEME_ID = THEME_ID;
    }

    public String getACCESSORY_ID() {
        return ACCESSORY_ID;
    }

    public void setACCESSORY_ID(String ACCESSORY_ID) {
        this.ACCESSORY_ID = ACCESSORY_ID;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }
}
