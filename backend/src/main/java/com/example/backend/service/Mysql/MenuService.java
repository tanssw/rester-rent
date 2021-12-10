package com.example.backend.service.Mysql;

import com.example.backend.controller.Mysql.Body.MenuBody;
import com.example.backend.pojo.Mysql.Menu;
import com.example.backend.repository.Mysql.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    //    CREATE
    public boolean addMenu(MenuBody item) {
        try {
            Menu newMenu = new Menu(item.getName());
            menuRepository.save(newMenu);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    //    READ
    public List allMenu() {return menuRepository.findAll();}

    public Menu findByMenuName(String name) {return menuRepository.findByMenuName(name);}

    public Menu findByMenuId(int id) {return menuRepository.findByMenuId(id);}


    //    UPDATE
    public boolean updateMenuDataById(int id, MenuBody item) {
        try {
            menuRepository.changeMenuById(item.getName(), id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    //    DELETE
    public boolean deleteByMenuId(int id) {
        try {
            menuRepository.deleteByMenuId(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
