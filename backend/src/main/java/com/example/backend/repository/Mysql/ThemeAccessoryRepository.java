package com.example.backend.repository.Mysql;

import com.example.backend.pojo.Mysql.ThemeAccessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ThemeAccessoryRepository extends JpaRepository<ThemeAccessory, String> {

    @Query(value = "SELECT THEME.ID, ACCESSORY.ID, THEME.TNAME, THEME.PRICE, THEME.IMAGE, THEME.DETAILS, ACCESSORY.ANAME FROM THEME JOIN THEME_ACCESSORY ON THEME_ID = THEME_ACCESSORY.THEME_ID JOIN ACCESSORY ON ACCESSORY_ID = THEME_ACCESSORY.ACCESSORY_ID", nativeQuery = true)
    List findAllThemeAccessory();
}
