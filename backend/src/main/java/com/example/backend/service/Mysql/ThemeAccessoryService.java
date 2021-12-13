package com.example.backend.service.Mysql;

import com.example.backend.repository.Mysql.ThemeAccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeAccessoryService {
    @Autowired
    private ThemeAccessoryRepository themeAccessoryRepository;

    // READ
    public List findAllThemeAccessory() {return themeAccessoryRepository.findAll();}

    public  List findAll() {return themeAccessoryRepository.findAllThemeAccessory();}
}
