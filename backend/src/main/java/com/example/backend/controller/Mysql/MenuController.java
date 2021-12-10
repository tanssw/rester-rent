package com.example.backend.controller.Mysql;

import com.example.backend.controller.Mysql.Body.MenuBody;
import com.example.backend.service.Mysql.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    public List allMenu() {return menuService.allMenu();}

    @GetMapping("/find/name/{name}")
    public ResponseEntity findByMenuName(@PathVariable("name") String name) {return new ResponseEntity(menuService.findByMenuName(name), HttpStatus.OK);}

    @GetMapping("/find/id/{id}")
    public ResponseEntity findByMenuId(@PathVariable("id") int id) {return new ResponseEntity(menuService.findByMenuId(id), HttpStatus.OK);}

    @PatchMapping("/add")
    public ResponseEntity<?> addMenu(@RequestBody MenuBody menuBody) {
        if (menuService.addMenu(menuBody)) {
            return new ResponseEntity<>("Add Menu successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateMenuDataById(@PathVariable("id") int id, @RequestBody MenuBody menuBody) {
        if (menuService.updateMenuDataById(id, menuBody)) {
            return new ResponseEntity<>("Update Menu successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteByMenuId(@PathVariable("id") int id) {
        if (menuService.deleteByMenuId(id)) {
            return new ResponseEntity<>("Delete Menu successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
