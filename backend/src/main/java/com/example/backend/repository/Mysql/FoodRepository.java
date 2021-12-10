package com.example.backend.repository.Mysql;

import com.example.backend.pojo.Mysql.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface FoodRepository extends JpaRepository<Food, String> {

    @Query(value = "SELECT * FROM FOOD WHERE ID=?1", nativeQuery = true)
    Food findByFoodId(int id);

    @Query(value = "SELECT * FROM FOOD WHERE FNAME=?1", nativeQuery = true)
    Food findByFoodName(String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE FOOD SET FNAME=?1, CAPACITY=?2, SIZE=?3 WHERE ID=?4", nativeQuery = true)
    void changeFoodById(String name, int capacity, String size, int id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM FOOD WHERE ID=?1", nativeQuery = true)
    void deleteByFoodId(int id);
}
