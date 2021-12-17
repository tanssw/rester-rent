package com.example.backend.controller.mysql;

import com.example.backend.controller.mysql.body.ThemeAccessoryBody;
import com.example.backend.controller.mysql.response.AccessoryItems;
import com.example.backend.controller.mysql.response.ThemeAccessoryResponse;
import com.example.backend.pojo.mysql.ThemeAccessoryJoin;
import com.example.backend.requestBody.AuthTokenData;
import com.example.backend.service.mysql.ThemeAccessoryJoinService;
import com.example.backend.service.mysql.ThemeAccessoryService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class ThemeAccessoryController {

    @Autowired
    private ThemeAccessoryService themeAccessoryService;

    @Autowired
    private ThemeAccessoryJoinService themeAccessoryJoinService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getThemeAcc")
    public ResponseEntity all() {
        List<ThemeAccessoryJoin> themeAccs = themeAccessoryJoinService.findAllTA();

        List<ThemeAccessoryResponse> response = new ArrayList<>();

        List themeIds = new ArrayList();

        for (ThemeAccessoryJoin ta: themeAccs) {
            themeIds.add(ta.getId().getTHEME_ID());
        }

        Set themeIdSet = new HashSet(themeIds);

        for (Object id: themeIdSet) {
            ThemeAccessoryResponse temp = new ThemeAccessoryResponse(id.toString());
            AccessoryItems tempAcc;
            for (ThemeAccessoryJoin ta: themeAccs) {
                if (id.toString().equals(ta.getId().getTHEME_ID())) {
                    tempAcc = new AccessoryItems(ta.getId().getACCESSORY_ID(), ta.getANAME(), ta.getQUANTITY());

                    if(temp.getName() == null) temp.setName(ta.getTNAME());
                    if(temp.getImage() == null) temp.setImage(ta.getIMAGE());
                    if(temp.getDetils() == null) temp.setDetils(ta.getDETAILS());
                    if(temp.getPrice() == 0) temp.setPrice(ta.getPRICE());

                    temp.addAccessory(tempAcc);
                }
            }
            response.add(temp);
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }

    @PatchMapping("/addThemeAcc")
    public ResponseEntity addThemeAcessory(@RequestBody ThemeAccessoryBody themeAccessoryBody, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (themeAccessoryService.addThemeAccessory(themeAccessoryBody)) {
                return new ResponseEntity("Add theme_accessory successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/delThemeAcc/{themeId}/{accessoryId}")
    public ResponseEntity deleteThemeAccessory(@PathVariable("themeId") int themeId, @PathVariable("accessoryId") int accessoryId, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (themeAccessoryService.findThemeAccessory(Integer.toString(themeId)) && themeAccessoryService.deleteThemeAccessory(themeId, accessoryId)) {
                return new ResponseEntity("Delete theme_accessory successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
