package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Locations;
import com.example.backend.service.mongodb.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationsController {

    @Autowired
    private LocationsService locationsService;

    @RequestMapping(value="/getLocate", method = RequestMethod.GET)
    public ResponseEntity getAllLocations() { return new ResponseEntity(locationsService.allLocation(), HttpStatus.OK);}

    @RequestMapping(value="/addRoom", method = RequestMethod.PATCH)
    public ResponseEntity addLocation(@RequestBody Locations location) {
        if (locationsService.addOrUpdateLocation(location)) {
            return new ResponseEntity("Add room successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/updLocate", method = RequestMethod.PATCH)
    public ResponseEntity updateLocation(@RequestBody Locations location) {
        if (locationsService.addOrUpdateLocation(location)) {
            return new ResponseEntity("Update room successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/delLocate/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteLocation(@PathVariable("id") String id) {
        if (locationsService.deleteLocation(id)) {
            return new ResponseEntity("delete room successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
