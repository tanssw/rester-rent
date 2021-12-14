package com.example.backend.pojo;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ACCESSORY")
public class Accessory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String ANAME;

//    @OneToMany(mappedBy = "Theme")
//    Set<ThemeAccessory> themeAccessory;

    public Accessory() {
    }

    public Accessory(String ANAME) {
        this.ANAME = ANAME;
    }

    public Accessory(int ID, String ANAME) {
        this.ID = ID;
        this.ANAME = ANAME;
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
}
