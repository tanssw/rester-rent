package com.example.backend.repository.mongodb;

import com.example.backend.pojo.mongodb.Payments;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentsRepository  extends MongoRepository<Payments, String> {
}
