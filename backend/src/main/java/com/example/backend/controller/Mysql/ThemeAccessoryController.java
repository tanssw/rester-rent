package com.example.backend.controller.Mysql;

import com.example.backend.controller.Mysql.body.ThemeAccessoryBody;
import com.example.backend.service.Mysql.ThemeAccessoryJoinService;
import com.example.backend.service.Mysql.ThemeAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ta")
public class ThemeAccessoryController {

    @Autowired
    private ThemeAccessoryService themeAccessoryService;

    @Autowired
    private ThemeAccessoryJoinService themeAccessoryJoinService;

    @GetMapping("/")
    public ResponseEntity all() {return new ResponseEntity(themeAccessoryJoinService.findAllTA(), HttpStatus.OK);}

    @GetMapping("/find/{themeId}/{accessoryId}")
    public ResponseEntity findOneByBothId(@PathVariable("themeId") int themeId, @PathVariable("accessoryId") int accessoryId) {return new ResponseEntity(themeAccessoryJoinService.findOneByBothId(themeId, accessoryId), HttpStatus.OK);}

    @PatchMapping("/add")
    public ResponseEntity addThemeAcessory(@RequestBody ThemeAccessoryBody themeAccessoryBody) {
        if(themeAccessoryService.addThemeAccessory(themeAccessoryBody)){
            return new ResponseEntity("Add theme_accessory successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{themeId}/{accessoryId}")
    public ResponseEntity deleteThemeAccessory(@PathVariable("themeId") int themeId, @PathVariable("accessoryId") int accessoryId) {
        if(themeAccessoryService.deleteThemeAccessory(themeId, accessoryId)){
            return new ResponseEntity("Delete theme_accessory successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
