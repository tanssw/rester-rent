package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Musics;
import com.example.backend.requestBody.AuthTokenData;
import com.example.backend.service.mongodb.MusicsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class MusicsController {

    @Autowired
    private MusicsService musicsService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value="/getBrand", method = RequestMethod.GET)
    public ResponseEntity getAllBrand() {return new ResponseEntity(musicsService.allBrands(), HttpStatus.OK);}

    @RequestMapping(value = "/addBrand", method = RequestMethod.PATCH)
    public ResponseEntity addBrand(@RequestBody Musics musics, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (musicsService.addOrUpdateBrand(musics)) {
                return new ResponseEntity("Add Brand successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/updBrand", method = RequestMethod.PATCH)
    public ResponseEntity updateBrand(@RequestBody Musics musics, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (musicsService.addOrUpdateBrand(musics)) {
                return new ResponseEntity("Update Brand successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value="/delBrand/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLocation(@PathVariable("id") String id, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (musicsService.delBrand(id) && musicsService.findBrandById(id)) {
                return new ResponseEntity("delete Brand successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

}
