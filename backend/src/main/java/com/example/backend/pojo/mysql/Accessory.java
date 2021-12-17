package com.example.backend.pojo.mysql;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ACCESSORY")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String ID;
    private String ANAME;

    public Accessory() {
    }

    public Accessory(String ANAME) {
        this.ANAME = ANAME;
    }

    public Accessory(String ID, String ANAME) {
        this.ID = ID;
        this.ANAME = ANAME;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getANAME() {
        return ANAME;
    }

    public void setANAME(String ANAME) {
        this.ANAME = ANAME;
    }
}
