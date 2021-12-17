package com.example.backend.pojo;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CompositeThemeAccessory implements Serializable {

    private String THEME_ID;
    private String ACCESSORY_ID;

    public CompositeThemeAccessory() {
    }

    public CompositeThemeAccessory(String THEME_ID, String ACCESSORY_ID) {
        this.THEME_ID = THEME_ID;
        this.ACCESSORY_ID = ACCESSORY_ID;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeThemeAccessory that = (CompositeThemeAccessory) o;
        return THEME_ID == that.THEME_ID && ACCESSORY_ID == that.ACCESSORY_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(THEME_ID, ACCESSORY_ID);
    }
}
