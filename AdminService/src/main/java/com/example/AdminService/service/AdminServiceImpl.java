package com.example.AdminService.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.AdminService.dao.AdminRepository;
import com.example.AdminService.entity.TrainDetails;
import com.example.AdminService.exception.ResourceNotFoundException;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	private AdminRepository adminRepo;
	
	public List<TrainDetails> getAllDetails()
	{
		List<TrainDetails> trainDetails=new ArrayList<TrainDetails>();
		adminRepo.findAll().forEach(trainDetails1 -> trainDetails.add(trainDetails1));
		//To check while tesing..
		//System.out.println(trainDetails);
		return trainDetails;
	}
	
	public TrainDetails getDetailsByTrainNo(int trainNo)
	{
		return adminRepo.findById(trainNo)
		.orElseThrow(()->new ResourceNotFoundException("Train not found with number : "+ trainNo));
	}
	
	public void addTrainDetails(TrainDetails trainDetails)
	{
		adminRepo.save(trainDetails);
	}
	
	public TrainDetails updateTrainDetails(int trainNo,TrainDetails trainDetails)
	{
		TrainDetails existingDetails=adminRepo.findById(trainNo)
				.orElseThrow(()->new ResourceNotFoundException("Cannot update the given train details, as train not found with number : "+ trainNo));
		existingDetails.setTrainNo(trainDetails.getTrainNo());
		existingDetails.setTrainName(trainDetails.getTrainName());
		existingDetails.setStartStation(trainDetails.getStartStation());
		existingDetails.setDestStation(trainDetails.getDestStation());
		existingDetails.setArrivalTime(trainDetails.getArrivalTime());
		existingDetails.setDeptTime(trainDetails.getDeptTime());
		existingDetails.setDuration(trainDetails.getDuration());
		existingDetails.setNoOfSeats(trainDetails.getNoOfSeats());
		existingDetails.setFirstClassACFare(trainDetails.getFirstClassACFare());
		existingDetails.setTwoTierAcFare(trainDetails.getTwoTierAcFare());
		existingDetails.setThreeTierAcFare(trainDetails.getThreeTierAcFare());
		existingDetails.setSleeperFare(trainDetails.getSleeperFare());
		return adminRepo.save(existingDetails);
	}
	
	public ResponseEntity<TrainDetails> deleteTrainDetails(int trainNo)
	{
		TrainDetails existingDetails=adminRepo.findById(trainNo)
				.orElseThrow(()->new ResourceNotFoundException("Cannot delete as train not found with number : "+ trainNo));
		adminRepo.delete(existingDetails);
		//adminRepo.deleteById(trainNo);
		return ResponseEntity.ok().build();

	}
}