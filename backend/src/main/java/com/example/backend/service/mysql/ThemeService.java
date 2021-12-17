package com.example.backend.service.mysql;

import com.example.backend.controller.mysql.body.ThemeBody;
import com.example.backend.pojo.mysql.Theme;
import com.example.backend.repository.mysql.ThemeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThemeService {

    @Autowired
    private ThemeRepository themeRepository;

    //    CREATE
    public boolean addTheme(ThemeBody item) {
        try {
            Theme newTheme = new Theme(item.getName(), item.getPrice(), item.getImage(), item.getDetails());
            themeRepository.save(newTheme);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //    READ
    public List<Theme> allTheme() {return themeRepository.findAll();}

    public boolean findThemeById(String id) {return !themeRepository.findById(id).isEmpty();}

    //    UPDATE
    public boolean updateThemeDataById(int id, ThemeBody item) {
        try {
            themeRepository.changeThemeById(item.getName(), item.getPrice(), item.getImage(), item.getDetails(), id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //    DELETE
    public boolean deleteByThemeId(int id) {
        try {
            themeRepository.deleteByThemeId(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
