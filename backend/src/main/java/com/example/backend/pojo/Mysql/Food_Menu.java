package com.example.backend.pojo.Mysql;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(CompositeFood_Menu.class)
public class Food_Menu {
    @Id
    private String FOOD_ID;
    @Id
    private String MENU_ID;

    public String getFOOD_ID() {
        return FOOD_ID;
    }

    public void setFOOD_ID(String FOOD_ID) {
        this.FOOD_ID = FOOD_ID;
    }

    public String getMENU_ID() {
        return MENU_ID;
    }

    public void setMENU_ID(String MENU_ID) {
        this.MENU_ID = MENU_ID;
    }
}
