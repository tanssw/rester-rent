package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Orders;
import com.example.backend.requestBody.AuthTokenData;
import com.example.backend.service.mongodb.MailService;
import com.example.backend.service.mongodb.OrdersService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private MailService mailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "/getOrder", method = RequestMethod.GET)
    public ResponseEntity getAllOrders() {
        return new ResponseEntity(ordersService.allOrders(), HttpStatus.OK);
    }

    @RequestMapping(value = "/addOrder", method = RequestMethod.PATCH)
    public ResponseEntity addOrder(@RequestBody Orders order) {
        if (ordersService.addOrUpdateOrder(order)) {
            return new ResponseEntity("Add order successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/updOrder", method = RequestMethod.PATCH)
    public ResponseEntity updateOrderStatus(@RequestBody Orders order, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            try {
                if (!ordersService.addOrUpdateOrder(order)) {
                    throw new Exception();
                }
                if (order.getStatus().equals("รอการชำระเงิน")) {
                    mailService.sendMail(order, true);
                } else if (order.getStatus().equals("ยกเลิกการดดำเนินการ")) {
                    mailService.sendMail(order, false);
                }
                return new ResponseEntity("Update order status successfully.", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value="/delOrder/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder(@PathVariable("id") String id, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (ordersService.findOrderById(id) & ordersService.delOrder(id)) {
                return new ResponseEntity("Delete order successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
