package com.example.backend.controller.mysql;

import com.example.backend.controller.mysql.body.FoodBody;
import com.example.backend.controller.mysql.response.FoodResponse;
import com.example.backend.controller.mysql.response.Options;
import com.example.backend.pojo.mysql.Food;
import com.example.backend.service.mysql.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/getFood")
    public ResponseEntity allFood() {
        List<Food> foods = foodService.allFood();

        List<FoodResponse> response = new ArrayList<>();

        List foodNames = new ArrayList();

        for (Food food : foods) {
            foodNames.add(food.getFNAME());
        }

        Set foodNamesSet = new HashSet(foodNames);

        for (Object name: foodNamesSet) {
            FoodResponse temp = new FoodResponse(name.toString());
            Options tempOption;
            for (Food food: foods) {
                if (name.toString().equals(food.getFNAME())) {
                    tempOption = new Options(food.getID(), food.getCAPACITY(), food.getPRICE(), food.getSIZE());
                    if (temp.isMenuEmpty()) {
                        temp.setMenus(food.getMENUS());
                    }
                    temp.addOptions(tempOption);
                }
            }
            response.add(temp);
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PatchMapping("/addFood")
    public ResponseEntity<?> addFood(@RequestBody FoodBody foodBody) {
        if (foodService.addFood(foodBody)) {
            return new ResponseEntity<>("Add food successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/updFood/{id}")
    public ResponseEntity<?> updateFoodDataById(@PathVariable("id") int id, @RequestBody FoodBody foodBody) {
        if (foodService.updateFoodDataById(id, foodBody)) {
            return new ResponseEntity<>("Add accessory successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delFood/{id}")
    public ResponseEntity<?> deleteByFoodId(@PathVariable("id") int id) {
        if (foodService.deleteByFoodId(id)) {
            return new ResponseEntity<>("Delete food successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
