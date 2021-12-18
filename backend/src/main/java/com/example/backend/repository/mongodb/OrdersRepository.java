package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, String> {

    @Query(value="{mail: '?0', income: ?1}")
    Orders findOrderByMailAndAmount(String mail, int income);
}
