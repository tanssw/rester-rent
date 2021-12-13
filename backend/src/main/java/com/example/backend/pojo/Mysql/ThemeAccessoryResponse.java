package com.example.backend.pojo.Mysql;


import javax.persistence.*;

@Entity
@IdClass(CompositeThemeAccessory.class)
public class ThemeAccessoryResponse {
    @Id
    private int THEME_ID;
    @Id
    private int ACCESSORY_ID;
    private String TNAME;
    private int PRICE;
    private String IMAGE;
    private String DETAILS;
    private String ANAME;

    public ThemeAccessoryResponse(int THEME_ID, int ACCESSORY_ID, String TNAME, int PRICE, String IMAGE, String DETAILS, String ANAME) {
        this.THEME_ID = THEME_ID;
        this.ACCESSORY_ID = ACCESSORY_ID;
        this.TNAME = TNAME;
        this.PRICE = PRICE;
        this.IMAGE = IMAGE;
        this.DETAILS = DETAILS;
        this.ANAME = ANAME;
    }

    public int getTHEME_ID() {
        return THEME_ID;
    }

    public void setTHEME_ID(int THEME_ID) {
        this.THEME_ID = THEME_ID;
    }

    public int getACCESSORY_ID() {
        return ACCESSORY_ID;
    }

    public void setACCESSORY_ID(int ACCESSORY_ID) {
        this.ACCESSORY_ID = ACCESSORY_ID;
    }

    public String getTNAME() {
        return TNAME;
    }

    public void setTNAME(String TNAME) {
        this.TNAME = TNAME;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }

    public String getDETAILS() {
        return DETAILS;
    }

    public void setDETAILS(String DETAILS) {
        this.DETAILS = DETAILS;
    }

    public String getANAME() {
        return ANAME;
    }

    public void setANAME(String ANAME) {
        this.ANAME = ANAME;
    }
}
