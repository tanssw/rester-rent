package com.example.backend.service.mysql;

import com.example.backend.controller.mysql.body.FoodBody;
import com.example.backend.pojo.mysql.Food;
import com.example.backend.repository.mysql.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepository;

    //    CREATE
    public boolean addFood(FoodBody item) {
        try {
            Food newFood = new Food(item.getFname(), item.getCapacity(), item.getSize(), item.getMenus(), item.getPrice());
            foodRepository.save(newFood);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //    READ
    public List<Food> allFood() {return foodRepository.findAll();}


    //    UPDATE
    public boolean updateFoodDataById(String targetName, FoodBody item) {
        try {
            foodRepository.changeFoodById(item.getFname(), item.getMenus().toString(), targetName);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateFoodOptionById(int id, FoodBody item) {
        try {
            foodRepository.changeFoodOptionById(item.getCapacity(), item.getPrice(), item.getSize(), id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //    DELETE
    public boolean deleteByFoodId(int id) {
        try {
            foodRepository.deleteByFoodId(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
