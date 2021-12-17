package com.example.backend.controller.mongodb;

import com.example.backend.pojo.mongodb.Payments;
import com.example.backend.requestBody.AuthTokenData;
import com.example.backend.service.mongodb.MailService;
import com.example.backend.service.mongodb.PaymentsService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentsController {

    @Autowired
    private PaymentsService paymentsService;

    @Autowired
    private MailService mailService;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value="/getPayment", method = RequestMethod.GET)
    public ResponseEntity getAllPayments() {return new ResponseEntity(paymentsService.getAllPayments(), HttpStatus.OK);}

    @RequestMapping(value="/addPayment", method = RequestMethod.PATCH)
    public ResponseEntity addPayment(@RequestBody Payments payment) {
        if (paymentsService.addOrUpdatePayment(payment)) {
            return new ResponseEntity("Add payment successfully.", HttpStatus.OK);
        }
        return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);    }

    @RequestMapping(value="/updPayment", method = RequestMethod.PATCH)
    public ResponseEntity updatePayment(@RequestBody Payments payments, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            try {
                if (!paymentsService.addOrUpdatePayment(payments)) {
                    throw new Exception();
                }
                if (payments.isStatus()) {
                    mailService.sendMail(payments, true);
                }
                return new ResponseEntity("Update payment successfully.", HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value="/delPayment/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePayments(@PathVariable("id") String id, @RequestHeader("token") String token, @RequestHeader("userId") String userId) {
        AuthTokenData header = new AuthTokenData(token, userId);
        Object auth = rabbitTemplate.convertSendAndReceive("AuthExchange", "auth", header);
        if ((boolean) auth) {
            if (paymentsService.findPaymentById(id) & paymentsService.deletePayment(id)) {
                return new ResponseEntity("Delete payment successfully.", HttpStatus.OK);
            }
            return new ResponseEntity("Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
