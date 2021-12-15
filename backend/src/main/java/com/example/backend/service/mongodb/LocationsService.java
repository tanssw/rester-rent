package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.Locations;
import com.example.backend.repository.mongodb.LocationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationsService {

    @Autowired
    private LocationsRepository locationsRepository;

    //    CREATE & UPDATE
    public boolean addOrUpdateLocation(Locations locations) {
        try {
            locationsRepository.save(locations);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    READ
    public List<Locations> allLocation() {return locationsRepository.findAll();}

    public Optional<Locations> findLocationById(String id) {return locationsRepository.findById(id);}

    public List<Locations> findLocationByName(String name) {return locationsRepository.findByName(name);}

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
