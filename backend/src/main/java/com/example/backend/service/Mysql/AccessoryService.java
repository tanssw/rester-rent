package com.example.backend.service.Mysql;

import com.example.backend.controller.Mysql.body.AccessoryBody;
import com.example.backend.pojo.Mysql.Accessory;
import com.example.backend.repository.Mysql.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

//    CREATE
    public boolean addAccessory(AccessoryBody item) {
        try {
            Accessory newAccessory = new Accessory(item.getName());
            accessoryRepository.save(newAccessory);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    READ
    public List<Accessory> allAccessory() {return accessoryRepository.findAll();}

    public List<Accessory> findByAccessoryName(String name) {return accessoryRepository.findByAccessoryName(name);}

    public List<Accessory> findByAccessoryId(int id) {return accessoryRepository.findByAccessoryId(id);}

//    UPDATE
    public boolean updateAccessory(int id, AccessoryBody item) {
        try {
            accessoryRepository.changeAccessoryById(item.getName(), id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    DELETE
    public boolean deleteByAccessoryId(int id) {
        try {
            accessoryRepository.deleteByAccessoryId(id);
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
