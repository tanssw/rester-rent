package com.example.backend.service.mongodb;

import com.example.backend.pojo.mongodb.Musics;
import com.example.backend.pojo.mongodb.Orders;
import com.example.backend.repository.mongodb.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

//    READ
    public List<Orders> allOrders() {return ordersRepository.findAll();}

//    CREATE & UPDATE
    public boolean addOrUpdateOrder(Orders order) {
        try {
            ordersRepository.save(order);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

//    DELETE
    public boolean delOrder(String id) {
        try {
            ordersRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


}
