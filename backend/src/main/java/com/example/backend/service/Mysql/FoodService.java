package com.example.backend.service.Mysql;

import com.example.backend.controller.Mysql.Body.FoodBody;
import com.example.backend.pojo.Mysql.Food;
import com.example.backend.repository.Mysql.FoodRepository;
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
            Food newFood = new Food(item.getName(), item.getCapacity(), item.getSize(), item.getMenus(), item.getPrice());
            foodRepository.save(newFood);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //    READ
    public List allFood() {return foodRepository.findAll();}

    public Food findByFoodName(String name) {return foodRepository.findByFoodName(name);}

    public Food findByFoodId(int id) {return foodRepository.findByFoodId(id);}


    //    UPDATE
    public boolean updateFoodDataById(int id, FoodBody item) {
        try {
            foodRepository.changeFoodById(item.getName(), item.getCapacity(), item.getSize(), item.getMenus().toString(), item.getPrice(), id);
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
