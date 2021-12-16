package com.example.backend.repository.mysql;

import com.example.backend.pojo.mysql.ThemeAccessoryJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeAccessoryJoinRepository extends JpaRepository<ThemeAccessoryJoin, String> {

    @Query(value = "SELECT THEME_ID, ACCESSORY_ID, TNAME, PRICE, IMAGE, DETAILS, ANAME, QUANTITY FROM THEME JOIN THEME_ACCESSORY ON THEME_ID = THEME_ID JOIN ACCESSORY ON ACCESSORY_ID = ACCESSORY_ID", nativeQuery = true)
    List<ThemeAccessoryJoin> findAllThemeAccessory();

    @Query(value= "SELECT THEME_ID, ACCESSORY_ID, TNAME, PRICE, IMAGE, DETAILS, ANAME, QUANTITY FROM THEME JOIN THEME_ACCESSORY ON THEME_ID = THEME_ID JOIN ACCESSORY ON ACCESSORY_ID = ACCESSORY_ID WHERE THEME_ID=?1 AND ACCESSORY_ID=?2", nativeQuery = true)
    ThemeAccessoryJoin findOneByBothId(int themeId, int accessoryId);
}
