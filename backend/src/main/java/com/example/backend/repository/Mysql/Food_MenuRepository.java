package com.example.backend.repository.Mysql;

import com.example.backend.pojo.Mysql.Food_Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Food_MenuRepository extends JpaRepository<Food_Menu, String> {
}
