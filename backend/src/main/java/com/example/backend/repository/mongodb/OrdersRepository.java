package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Orders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends MongoRepository<Orders, String> {

    @Query(value="{fullname:?0}")
    List<Orders> findByFullname(String name);

    @Query(value="{email:?0}")
    List<Orders> findByEmail(String email);
}
