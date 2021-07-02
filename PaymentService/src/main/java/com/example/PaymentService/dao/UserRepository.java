package com.example.PaymentService.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.PaymentService.entity.UserDetails;

//Dao Layer
@Repository
public interface UserRepository extends MongoRepository<UserDetails, Integer>
{

	
}
