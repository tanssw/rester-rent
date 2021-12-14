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
public class ThemeAccessoryController {

    @Autowired
    private ThemeAccessoryService themeAccessoryService;

    @Autowired
    private ThemeAccessoryJoinService themeAccessoryJoinService;

    @GetMapping("/getTheme")
    public ResponseEntity all() {return new ResponseEntity(themeAccessoryJoinService.findAllTA(), HttpStatus.OK);}

    @GetMapping("/findTheme/{themeId}/{accessoryId}")
    public ResponseEntity findOneByBothId(@PathVariable("themeId") int themeId, @PathVariable("accessoryId") int accessoryId) {
        if (themeAccessoryJoinService.findOneByBothId(themeId, accessoryId) == null) {
            return new ResponseEntity("Not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(themeAccessoryJoinService.findOneByBothId(themeId, accessoryId), HttpStatus.OK);
    }

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
