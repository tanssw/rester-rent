package com.example.backend.service.mysql;

import com.example.backend.controller.mysql.body.AccessoryBody;
import com.example.backend.pojo.mysql.Accessory;
import com.example.backend.repository.mysql.AccessoryRepository;
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

    public boolean findAccessoryById(String id) {return accessoryRepository.findById(id).isEmpty();}

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
