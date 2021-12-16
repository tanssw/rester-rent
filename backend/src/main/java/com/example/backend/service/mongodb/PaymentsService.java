package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.Payments;
import com.example.backend.repository.mongodb.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentsService {

    @Autowired
    private PaymentsRepository paymentsRepository;

//    CREATE & UPDATE
    public boolean addOrUpdatePayment(Payments payment){
        try {
            paymentsRepository.save(payment);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
//    READ
    public List<Payments> getAllPayments() {return paymentsRepository.findAll();}

    public boolean findPaymentById(String id) {return !paymentsRepository.findById(id).isEmpty();}

//    DELETE
    public boolean deletePayment(String id) {
        try {
            paymentsRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
