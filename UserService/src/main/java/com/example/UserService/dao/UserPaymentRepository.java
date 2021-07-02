package com.example.UserService.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.UserService.entity.PaymentDetails;

@Repository
public interface UserPaymentRepository extends MongoRepository<PaymentDetails, Long>
{

}
