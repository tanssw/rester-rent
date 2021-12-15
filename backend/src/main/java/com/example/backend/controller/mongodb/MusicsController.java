package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Musics;
import com.example.backend.service.mongodb.MusicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MusicsController {

    @Autowired
    private MusicsService musicsService;

    @RequestMapping(value="/getBrand", method = RequestMethod.GET)
    public ResponseEntity getAllBrand() {return new ResponseEntity(musicsService.allBrands(), HttpStatus.OK);}

    @RequestMapping(value = "/addBrand", method = RequestMethod.PATCH)
    public ResponseEntity addBrand(@RequestBody Musics musics) {
        if (musicsService.addOrUpdateBrand(musics)) {
            return new ResponseEntity("Add Brand successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/updBrand", method = RequestMethod.PATCH)
    public ResponseEntity updateBrand(@RequestBody Musics musics) {
        if (musicsService.addOrUpdateBrand(musics)) {
            return new ResponseEntity("Update Brand successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/delBrand/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLocation(@PathVariable("id") String id) {
        if (musicsService.delBrand(id)) {
            return new ResponseEntity("delete Brand successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
