package com.example.AdminService.controller;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.AdminService.entity.TrainDetails;
import com.example.AdminService.service.AdminServiceImpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController 
{
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	

	@GetMapping("/all")
	@ApiOperation(value="Get all train details")
	public List<TrainDetails> getAllDetails()
	{
		return adminServiceImpl.getAllDetails();
	}
	

	@GetMapping("/{trainNo}")
	@ApiOperation(value="Get all train details by Train Number")
	public TrainDetails getDetailsByTrainNo(@PathVariable Integer trainNo) 
	{
		return adminServiceImpl.getDetailsByTrainNo(trainNo);
	}
	

	@PostMapping("/add")
	@ApiOperation(value="Add new train details to train database")
	public String addTrainDetails(@Valid @RequestBody TrainDetails trainDetails)
	{
		adminServiceImpl.addTrainDetails(trainDetails);
		return ("Added train details with train number - "+trainDetails.getTrainNo()+" successfully..!!");
	}
	

	@PutMapping("/update/{trainNo}")
	@ApiOperation(value="Update train details in train database by Train Number")
	public TrainDetails updateTrainDetails(@PathVariable Integer trainNo,@Valid @RequestBody TrainDetails trainDetails)
	{
		return adminServiceImpl.updateTrainDetails(trainNo,trainDetails);
	}
	

	@DeleteMapping("/delete/{trainNo}")
	@ApiOperation(value="Delete train details in train database by Train Number")
	public ResponseEntity<TrainDetails> deleteTrainDetails(@PathVariable Integer trainNo)
	{
		return adminServiceImpl.deleteTrainDetails(trainNo);
	}
	
	//update the no of seats based on the no of passengers that booked ticket
	@GetMapping("/updateSeats/{trainNo}/{noOfPassengers}")
	public void updateSeats(@PathVariable int trainNo,@PathVariable int noOfPassengers)
	{
		TrainDetails currentTrain=adminServiceImpl.getDetailsByTrainNo(trainNo);
		int initialSeats=currentTrain.getNoOfSeats();
		int finalSeats=initialSeats-noOfPassengers;
		currentTrain.setNoOfSeats(finalSeats);
		adminServiceImpl.updateTrainDetails(trainNo, currentTrain);
	}
}