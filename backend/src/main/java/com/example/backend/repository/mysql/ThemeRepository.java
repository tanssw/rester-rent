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
    @Query(value = "UPDATE THEME SET TNAME=?1, PRICE=?2, IMAGE=?3, DETAILS=?4 WHERE ID=?5", nativeQuery = true)
    void changeThemeById(String name, int price, String image, String details, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM THEME WHERE ID=?1", nativeQuery = true)
    void deleteByThemeId(int id);
}
