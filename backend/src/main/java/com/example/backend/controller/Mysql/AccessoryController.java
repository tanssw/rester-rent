package com.example.backend.controller.Mysql;

import com.example.backend.controller.Mysql.body.AccessoryBody;
import com.example.backend.pojo.Mysql.Accessory;
import com.example.backend.service.Mysql.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accessory")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

//    Get all accessory in db
    @GetMapping("/")
    public ResponseEntity<?> allAccessory() {
        return new ResponseEntity<>(accessoryService.allAccessory(), HttpStatus.OK);
    }

//    Find accessory by name return List
    @GetMapping("/find/name/{name}")
    public ResponseEntity findAccessoryByName(@PathVariable("name") String name) {
        if (accessoryService.findByAccessoryName(name).isEmpty()){
            return new ResponseEntity<>("Not found accessory with this name: " + name, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accessoryService.findByAccessoryName(name), HttpStatus.OK);
    }

//    Find accessory by id return Accessory (single)
    @GetMapping("/find/id/{id}")
    public ResponseEntity findAccessoryByName(@PathVariable("id") int id) {
        if (accessoryService.findByAccessoryId(id).isEmpty()){
            return new ResponseEntity<>("Not found accessory with this id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(accessoryService.findByAccessoryId(id), HttpStatus.OK);
    }

//    Add new accessory
    @PatchMapping("/add")
    public ResponseEntity addAccessory(@RequestBody AccessoryBody accessoryBody) {
        if (accessoryService.addAccessory(accessoryBody)) {
            return new ResponseEntity<>("Add accessory successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Change accessory name by id
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateAccessoryById(@PathVariable("id") int id, @RequestBody AccessoryBody accessoryBody) {
        if (accessoryService.updateAccessory(id, accessoryBody)) {
            return new ResponseEntity<>("Update accessory data successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    Delete accessory by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccessory(@PathVariable("id") int id) {
        if (accessoryService.deleteByAccessoryId(id)) {
            return new ResponseEntity<>("Delete accessory successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
