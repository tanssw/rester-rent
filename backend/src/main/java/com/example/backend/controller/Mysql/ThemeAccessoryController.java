package com.example.backend.controller.Mysql;

import com.example.backend.service.Mysql.ThemeAccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ta")
public class ThemeAccessoryController {

    @Autowired
    private ThemeAccessoryService themeAccessoryService;

    @GetMapping("/")
    public ResponseEntity findAll() {return new ResponseEntity(themeAccessoryService.findAllThemeAccessory(), HttpStatus.OK);}

    @GetMapping("/all")
    public ResponseEntity all() {return new ResponseEntity(themeAccessoryService.findAll(), HttpStatus.OK);}
}
