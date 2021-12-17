package com.example.backend.pojo.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String FNAME;
    private int CAPACITY;
    private String SIZE;
    private String MENUS;
    private int PRICE;

    public Food() {
    }

    public Food(String FNAME, int CAPACITY, String SIZE, String MENUS, int PRICE) {
        this.FNAME = FNAME;
        this.CAPACITY = CAPACITY;
        this.SIZE = SIZE;
        this.MENUS = MENUS;
        this.PRICE = PRICE;
    }

    public Food(String ID, String FNAME, int CAPACITY, String SIZE, String MENUS, int PRICE) {
        this.ID = ID;
        this.FNAME = FNAME;
        this.CAPACITY = CAPACITY;
        this.SIZE = SIZE;
        this.MENUS = MENUS;
        this.PRICE = PRICE;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFNAME() {
        return FNAME;
    }

    public void setFNAME(String FNAME) {
        this.FNAME = FNAME;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public void setCAPACITY(int CAPACITY) {
        this.CAPACITY = CAPACITY;
    }

    public String getSIZE() {
        return SIZE;
    }

    public void setSIZE(String SIZE) {
        this.SIZE = SIZE;
    }

    public String getMENUS() {
        return MENUS;
    }

    public void setMENUS(String MENUS) {
        this.MENUS = MENUS;
    }

    public int getPRICE() {
        return PRICE;
    }

    public void setPRICE(int PRICE) {
        this.PRICE = PRICE;
    }
}
