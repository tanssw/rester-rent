package com.example.backend.pojo.Mysql;

import javax.persistence.*;

@Entity
@Table(name = "ACCESSORY")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String ANAME;
    private int QUANTITY;

    public Accessory() {
    }

    public Accessory(String ANAME, int QUANTITY) {
        this.ANAME = ANAME;
        this.QUANTITY = QUANTITY;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getANAME() {
        return ANAME;
    }

    public void setANAME(String ANAME) {
        this.ANAME = ANAME;
    }

    public Integer getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }
}
