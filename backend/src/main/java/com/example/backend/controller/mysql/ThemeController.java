package com.example.backend.controller.mysql;

import com.example.backend.controller.mysql.body.ThemeBody;
import com.example.backend.requestBody.AuthTokenData;
import com.example.backend.service.mysql.ThemeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/theme")
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/getTheme")
    public ResponseEntity allTheme() {return new ResponseEntity(themeService.allTheme(), HttpStatus.OK);}

    @PatchMapping("/addTheme")
    public ResponseEntity<?> addTheme(@RequestBody ThemeBody themeBody, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (themeService.addTheme(themeBody)) {
                return new ResponseEntity<>("Add Theme successfully.", HttpStatus.OK);
            }
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @PatchMapping("/updTheme/{id}")
    public ResponseEntity<?> updateThemeDataById(@PathVariable("id") int id, @RequestBody ThemeBody themeBody, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (themeService.updateThemeDataById(id, themeBody)) {
                return new ResponseEntity<>("Update Theme successfully.", HttpStatus.OK);
            }
            return new ResponseEntity<>("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @DeleteMapping("/delTheme/{id}")
    public ResponseEntity<?> deleteAccessory(@PathVariable("id") int id, @RequestBody ThemeBody themeBody, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (themeService.deleteByThemeId(id)) {
                return new ResponseEntity<>("Delete Theme successfully", HttpStatus.OK);
            }
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
