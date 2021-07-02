package com.example.UserService.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.UserService.entity.TrainDetails;

//Dao Layer
@Repository
public interface AdminRepository extends MongoRepository<TrainDetails, Integer>
{

}
