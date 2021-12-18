package com.example.backend.repository.mysql;

import com.example.backend.pojo.mysql.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, String> {

    @Transactional
    @Modifying
    @Query(value="SELECT * FROM THEME LEFT JOIN THEME_ACCESSORY ON THEME.ID = THEME_ACCESSORY.THEME_ID WHERE THEME_ACCESSORY.THEME_ID IS NULL", nativeQuery = true)
    List<Theme> findThemeThatNotExistInThemeAccessory();

    @Transactional
    @Modifying
    @Query(value = "UPDATE THEME SET TNAME=?1, PRICE=?2, IMAGE=?3, DETAILS=?4 WHERE ID=?5", nativeQuery = true)
    void changeThemeById(String name, int price, String image, String details, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM THEME WHERE ID=?1", nativeQuery = true)
    void deleteByThemeId(int id);
}
