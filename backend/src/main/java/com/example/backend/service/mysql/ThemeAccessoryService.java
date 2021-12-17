package com.example.backend.service.mysql;

import com.example.backend.controller.mysql.body.ThemeAccessoryBody;
import com.example.backend.pojo.CompositeThemeAccessory;
import com.example.backend.pojo.mysql.ThemeAccessory;
import com.example.backend.repository.mysql.ThemeAccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeAccessoryService {

    @Autowired
    private ThemeAccessoryRepository themeAccessoryRepository;


    //    CREATE
    public boolean addThemeAccessory(ThemeAccessoryBody item) {
        try {
            CompositeThemeAccessory newThemeAccesoryKey = new CompositeThemeAccessory(item.getThemeId(), item.getAccessoryId());
            ThemeAccessory newThemeAccesory = new ThemeAccessory(newThemeAccesoryKey, item.getQuantity());
            themeAccessoryRepository.save(newThemeAccesory);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // READ
    public boolean findThemeAccessory(String id) {return !themeAccessoryRepository.findById(id).isEmpty();}

    // Delete
    public boolean deleteThemeAccessory(int themeId, int accessoryId) {
        try {
            themeAccessoryRepository.deleteTA(themeId, accessoryId);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteTAByThemeId(int themeId) {
        try {
            themeAccessoryRepository.deleteTAByThemeId(themeId);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
