package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Orders;
import com.example.backend.service.mongodb.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

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

    @RequestMapping(value="/delOrder/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder(@PathVariable("id") String id) {
        if (ordersService.delOrder(id)) {
            return new ResponseEntity("Delete order successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
