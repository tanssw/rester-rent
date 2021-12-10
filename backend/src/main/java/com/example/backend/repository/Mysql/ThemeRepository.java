package com.example.backend.repository.Mysql;

import com.example.backend.pojo.Mysql.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface ThemeRepository extends JpaRepository<Theme, String> {

    @Query(value = "SELECT * FROM THEME WHERE ID=?1", nativeQuery = true)
    Theme findByThemeId(int id);

    @Query(value = "SELECT * FROM THEME WHERE TNAME=?1", nativeQuery = true)
    Theme findByThemeName(String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE THEME SET TNAME=?1, IMAGE=?2, DETAILS=?3 WHERE ID=?4", nativeQuery = true)
    void changeThemeById(String name, String image, String details, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM THEME WHERE ID=?1", nativeQuery = true)
    void deleteByThemeId(int id);
}
