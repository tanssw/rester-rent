package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Locations;
import com.example.backend.requestBody.AuthTokenData;
import com.example.backend.service.mongodb.LocationsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value="/getLocate", method = RequestMethod.GET)
    public ResponseEntity getAllLocations() {
        return new ResponseEntity(locationsService.allLocation(), HttpStatus.OK);
    }

    @RequestMapping(value="/addLocate", method = RequestMethod.PATCH)
    public ResponseEntity addLocation(@RequestBody Locations location, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (locationsService.addOrUpdateLocation(location)) {
                return new ResponseEntity("Add room successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value="/updLocate", method = RequestMethod.PATCH)
    public ResponseEntity updateLocation(@RequestBody Locations location, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (locationsService.addOrUpdateLocation(location)) {
                return new ResponseEntity("Update room successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value="/delLocate/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLocation(@PathVariable("id") String id, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (locationsService.findRoomById(id) & locationsService.deleteLocation(id)) {
                return new ResponseEntity("delete room successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
