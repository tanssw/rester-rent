package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, String> {
}
