package com.example.backend.controller;

import com.example.backend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/supplies")
public class MySQLController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/")
    public List allStudent() {
        return studentService.getAllStudents();
    }

    @GetMapping("/health")
    public String HealthCheck() {
        return "Healthy";
    }
}
