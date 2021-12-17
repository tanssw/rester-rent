package com.example.backend.controller.mysql;

import com.example.backend.controller.mysql.body.AccessoryBody;
import com.example.backend.requestBody.AuthTokenData;
import com.example.backend.service.AccessoryService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

//    Get all accessory in db
    @GetMapping("/getAcc")
    public ResponseEntity<?> allAccessory() {
        return new ResponseEntity<>(accessoryService.allAccessory(), HttpStatus.OK);
    }

//    Add new accessory
    @PatchMapping("/addAcc")
    public ResponseEntity addAccessory(@RequestBody AccessoryBody accessoryBody, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (accessoryService.addAccessory(accessoryBody)) {
                return new ResponseEntity<>("Add accessory successfully.", HttpStatus.OK);
            }
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

//    Change accessory name by id
    @PatchMapping("/updAcc/{id}")
    public ResponseEntity updateAccessoryById(@PathVariable("id") int id, @RequestBody AccessoryBody accessoryBody, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (accessoryService.updateAccessory(id, accessoryBody)) {
                return new ResponseEntity("Update accessory data successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }

//    Delete accessory by id
    @DeleteMapping("/delAcc/{id}")
    public ResponseEntity deleteAccessory(@PathVariable("id") int id, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (!accessoryService.findAccessoryById(Integer.toString(id)) & accessoryService.deleteByAccessoryId(id)) {
                return new ResponseEntity("Delete accessory successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(HttpStatus.UNAUTHORIZED);
    }
}
