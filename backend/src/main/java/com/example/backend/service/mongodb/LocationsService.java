package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.Locations;
import com.example.backend.repository.mongodb.LocationsRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class LocationsService {

    @Autowired
    private LocationsRepository locationsRepository;

    //    CREATE & UPDATE
    public boolean addOrUpdateLocation(Locations location) {
        try {
            locationsRepository.save(location);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    READ
    public List<Locations> allLocation() {
        List<Locations> locations = locationsRepository.findAll();
        return locations;
    }

    public boolean findRoomById(String id) {
        return !locationsRepository.findById(id).isEmpty();
    }

//    DELETE
    public boolean deleteLocation(String id) {
        try {
            locationsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
