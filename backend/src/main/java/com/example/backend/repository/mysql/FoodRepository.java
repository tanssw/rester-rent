package com.example.backend.repository.mysql;

import com.example.backend.pojo.mysql.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface FoodRepository extends JpaRepository<Food, String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE FOOD SET FNAME=?1, MENUS=?2 WHERE FNAME=?3", nativeQuery = true)
    void changeFoodById(String name, String menus, String target);

    @Transactional
    @Modifying
    @Query(value = "UPDATE FOOD SET CAPACITY=?1, PRICE=?2, SIZE=?3 WHERE ID=?4", nativeQuery = true)
    void changeFoodOptionById(int capacity, int price, String size, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM FOOD WHERE ID=?1", nativeQuery = true)
    void deleteByFoodId(int id);
}
