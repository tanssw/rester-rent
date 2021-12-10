package com.example.backend.controller.Mysql;

import com.example.backend.controller.Mysql.Body.FoodBody;
import com.example.backend.service.Mysql.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    public List allFood() {return foodService.allFood();}

    @GetMapping("/find/name/{name}")
    public ResponseEntity findFoodByName(@PathVariable("name") String name) {return new ResponseEntity(foodService.findByFoodName(name), HttpStatus.OK);}

    @GetMapping("/find/id/{id}")
    public ResponseEntity findFoodByName(@PathVariable("id") int id) {return new ResponseEntity(foodService.findByFoodId(id), HttpStatus.OK);}

    @PatchMapping("/add")
    public ResponseEntity<?> addFood(@RequestBody FoodBody foodBody) {
        if (foodService.addFood(foodBody)) {
            return new ResponseEntity<>("Add food successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateFoodDataById(@PathVariable("id") int id, @RequestBody FoodBody foodBody) {
        if (foodService.updateFoodDataById(id, foodBody)) {
            return new ResponseEntity<>("Add accessory successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByFoodId(@PathVariable("id") int id) {
        if (foodService.deleteByFoodId(id)) {
            return new ResponseEntity<>("Delete food successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
