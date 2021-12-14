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

    @RequestMapping(value="/findLocate/id/{id}", method = RequestMethod.GET)
    public ResponseEntity findLocateById(@PathVariable("id") String id) {
        if (locationsService.findLocationById(id).isEmpty()) {
            return new ResponseEntity("Room not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(locationsService.findLocationById(id), HttpStatus.OK);
    }

    @RequestMapping(value="/findLocate/name/{name}", method = RequestMethod.GET)
    public ResponseEntity findLocateByName(@PathVariable("name") String name) {
        if (locationsService.findLocationByName(name).isEmpty()) {
            return new ResponseEntity("Room not found.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(locationsService.findLocationByName(name), HttpStatus.OK);
    }

    @RequestMapping(value="/addRoom", method = RequestMethod.PATCH)
    public ResponseEntity addLocation(@RequestBody Locations location) {
        if (locationsService.addLocation(location)) {
            return new ResponseEntity("Add room successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/updLocate", method = RequestMethod.PATCH)
    public ResponseEntity updateLocation(@RequestBody Locations location) {
        if (locationsService.updateLocation(location)) {
            return new ResponseEntity("Update room successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value="/delLocate", method = RequestMethod.DELETE)
    public ResponseEntity deleteLocation(@RequestBody Locations location) {
        if (locationsService.deleteLocation(location)) {
            return new ResponseEntity("delete room successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
