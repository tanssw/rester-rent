package com.example.backend.controller.mysql;

import com.example.backend.controller.mysql.body.ThemeAccessoryBody;
import com.example.backend.service.mysql.ThemeAccessoryJoinService;
import com.example.backend.service.mysql.ThemeAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThemeAccessoryController {

    @Autowired
    private ThemeAccessoryService themeAccessoryService;

    @Autowired
    private ThemeAccessoryJoinService themeAccessoryJoinService;

    @GetMapping("/getTheme")
    public ResponseEntity all() {return new ResponseEntity(themeAccessoryJoinService.findAllTA(), HttpStatus.OK);}

    @PatchMapping("/addTheme")
    public ResponseEntity addThemeAcessory(@RequestBody ThemeAccessoryBody themeAccessoryBody) {
        if(themeAccessoryService.addThemeAccessory(themeAccessoryBody)){
            return new ResponseEntity("Add theme_accessory successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delTheme/{themeId}/{accessoryId}")
    public ResponseEntity deleteThemeAccessory(@PathVariable("themeId") int themeId, @PathVariable("accessoryId") int accessoryId) {
        if(themeAccessoryService.deleteThemeAccessory(themeId, accessoryId)){
            return new ResponseEntity("Delete theme_accessory successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
