package com.example.backend.pojo.Mysql;


import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ThemeAccessoryJoin implements Serializable {

    @EmbeddedId
    private CompositeThemeAccessory id;
    private String TNAME;
    private int PRICE;
    private String IMAGE;
    private String DETAILS;
    private String ANAME;
    private int QUANTITY;

    public ThemeAccessoryJoin() {
    }

    public ThemeAccessoryJoin(CompositeThemeAccessory id, String TNAME, int PRICE, String IMAGE, String DETAILS, String ANAME, int QUANTITY) {
        this.id = id;
        this.TNAME = TNAME;
        this.PRICE = PRICE;
        this.IMAGE = IMAGE;
        this.DETAILS = DETAILS;
        this.ANAME = ANAME;
        this.QUANTITY = QUANTITY;
    }

    public ThemeAccessoryJoin(String TNAME, int PRICE, String IMAGE, String DETAILS, String ANAME, int QUANTITY) {
        this.TNAME = TNAME;
        this.PRICE = PRICE;
        this.IMAGE = IMAGE;
        this.DETAILS = DETAILS;
        this.ANAME = ANAME;
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
