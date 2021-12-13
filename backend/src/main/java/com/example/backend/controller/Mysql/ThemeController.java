package com.example.backend.controller.Mysql;

import com.example.backend.controller.Mysql.body.ThemeBody;
import com.example.backend.pojo.Mysql.Theme;
import com.example.backend.service.Mysql.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/")
    public ResponseEntity allTheme() {return new ResponseEntity(themeService.allTheme(), HttpStatus.OK);}

    @GetMapping("/find/name/{name}")
    public ResponseEntity findByThemeName(@PathVariable("name") String name) {
        if (themeService.findByThemeName(name).isEmpty()) {
            return new ResponseEntity<>("Not found theme with this name: " + name, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themeService.findByThemeName(name), HttpStatus.OK);
    }

    @GetMapping("/find/id/{id}")
    public ResponseEntity findByThemeId(@PathVariable("id") int id) {
        if (themeService.findByThemeId(id).isEmpty()) {
            return new ResponseEntity<>("Not found theme with this id: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(themeService.findByThemeId(id), HttpStatus.OK);
    }

    @PatchMapping("/add")
    public ResponseEntity<?> addTheme(@RequestBody ThemeBody themeBody) {
        if (themeService.addTheme(themeBody)) {
            return new ResponseEntity<>("Add Theme successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateThemeDataById(@PathVariable("id") int id, @RequestBody ThemeBody themeBody) {
        if (themeService.updateThemeDataById(id, themeBody)) {
            return new ResponseEntity<>("Update Theme successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccessory(@PathVariable("id") int id) {
        if (themeService.deleteByThemeId(id)) {
            return new ResponseEntity<>("Delete Theme successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
