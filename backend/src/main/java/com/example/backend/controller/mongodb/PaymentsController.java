package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Payments;
import com.example.backend.service.mongodb.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @RequestMapping(value="/getPayment", method = RequestMethod.GET)
    public ResponseEntity getAllPayments() {return new ResponseEntity(paymentsService.getAllPayments(), HttpStatus.OK);}

    @RequestMapping(value="/addPayment", method = RequestMethod.PATCH)
    public ResponseEntity addPayment(@RequestBody Payments payment) {
        if (paymentsService.addOrUpdatePayment(payment)) {
            return new ResponseEntity("Add payment successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/updPayment", method = RequestMethod.PATCH)
    public ResponseEntity updatePayment(@RequestBody Payments payments) {
        if (paymentsService.addOrUpdatePayment(payments)) {
            return new ResponseEntity("Update payment successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value="/delPayment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePayments(@PathVariable("id") String id) {
        if (paymentsService.deletePayment(id)) {
            return new ResponseEntity("Delete payment successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
