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
    @Query(value = "UPDATE FOOD SET FNAME=?1, CAPACITY=?2, SIZE=?3, MENUS=?4, PRICE=?5 WHERE ID=?6", nativeQuery = true)
    void changeFoodById(String name, int capacity, String size, String menus, int price, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM FOOD WHERE ID=?1", nativeQuery = true)
    void deleteByFoodId(int id);
}
