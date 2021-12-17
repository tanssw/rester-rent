package com.example.backend.repository.mysql;

import com.example.backend.pojo.mysql.ThemeAccessory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ThemeAccessoryRepository extends JpaRepository<ThemeAccessory, String> {

    @Transactional
    @Modifying
    @Query(value = "SELECT * FROM THEME_ACCESSORY WHERE THEME_ID=?1 AND ACCESSORY_ID=?2", nativeQuery = true)
    List<ThemeAccessory> findTAById(String themeId, String accessoryId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM THEME_ACCESSORY WHERE THEME_ID=?1", nativeQuery = true)
    void deleteTAByThemeId(String themeId);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM THEME_ACCESSORY WHERE THEME_ID=?1 AND ACCESSORY_ID=?2", nativeQuery = true)
    void deleteTA(String themeId, String accessoryId);




}
