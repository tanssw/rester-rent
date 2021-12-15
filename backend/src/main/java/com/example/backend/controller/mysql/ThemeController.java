package com.example.backend.controller.mysql;

import com.example.backend.controller.mysql.body.ThemeBody;
import com.example.backend.service.mysql.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @GetMapping("/")
    public ResponseEntity allTheme() {return new ResponseEntity(themeService.allTheme(), HttpStatus.OK);}

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
