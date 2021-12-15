package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.Musics;
import com.example.backend.repository.mongodb.MusicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicsService {

    @Autowired
    private MusicsRepository musicsRepository;

//    CREATE & UPDATE
    public boolean addOrUpdateBrand(Musics musics) {
        try {
            musicsRepository.save(musics);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    READ
    public List<Musics> allBrands() {return musicsRepository.findAll();}

    public List<Musics> findBrandByName(String name) {return musicsRepository.findByName(name);}

    public Optional<Musics> findBrandById(String id) {return musicsRepository.findById(id);}

//    DELETE
    public boolean delBrand(String id) {
        try {
            musicsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
