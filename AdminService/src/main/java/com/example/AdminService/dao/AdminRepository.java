package com.example.AdminService.dao;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.AdminService.entity.TrainDetails;

//Dao Layer
@Repository
public interface AdminRepository extends MongoRepository<TrainDetails, Integer>
{

}
