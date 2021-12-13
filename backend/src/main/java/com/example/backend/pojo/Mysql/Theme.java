package com.example.backend.pojo.Mysql;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String TNAME;
    private int PRICE;
    private String IMAGE;
    private String DETAILS;

//    @OneToMany(mappedBy = "Accessory")
//    Set<ThemeAccessory> themeAccessory;

    public Theme() {
    }

    public Theme(String ID, String TNAME, int PRICE, String IMAGE, String DETAILS) {
        this.ID = ID;
        this.TNAME = TNAME;
        this.PRICE = PRICE;
        this.IMAGE = IMAGE;
        this.DETAILS = DETAILS;
    }

    public Theme(String TNAME, int PRICE, String IMAGE, String DETAILS) {
        this.TNAME = TNAME;
        this.PRICE = PRICE;
        this.IMAGE = IMAGE;
        this.DETAILS = DETAILS;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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
}
