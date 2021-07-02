package com.example.AdminService.service;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.AdminService.entity.TrainDetails;

public interface AdminService 
{
	public List<TrainDetails> getAllDetails();
	public TrainDetails getDetailsByTrainNo(int trainNo);
	public void addTrainDetails(TrainDetails trainDetails);
	public TrainDetails updateTrainDetails(int trainNo,TrainDetails trainDetails);
	public ResponseEntity<TrainDetails> deleteTrainDetails(int trainNo);
}
