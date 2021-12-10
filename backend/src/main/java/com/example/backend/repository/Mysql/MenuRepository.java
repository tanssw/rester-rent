package com.example.backend.repository.Mysql;

import com.example.backend.pojo.Mysql.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface MenuRepository extends JpaRepository<Menu, String> {

    @Query(value = "SELECT * FROM MENU WHERE ID=?1", nativeQuery = true)
    Menu findByMenuId(int id);

    @Query(value = "SELECT * FROM MENU WHERE MNAME=?1", nativeQuery = true)
    Menu findByMenuName(String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE MENU SET MNAME=?1 WHERE ID=?2", nativeQuery = true)
    void changeMenuById(String name, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM MENU WHERE ID=?1", nativeQuery = true)
    void deleteByMenuId(int id);
}
