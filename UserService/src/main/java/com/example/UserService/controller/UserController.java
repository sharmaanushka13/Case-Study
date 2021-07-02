package com.example.UserService.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserService.entity.TrainDetails;
import com.example.UserService.service.AdminServiceImpl;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@GetMapping("/alltrains")
	@ApiOperation(value="Get all train details")
	public List<TrainDetails> getAllDetails()
	{
		return adminServiceImpl.getAllDetails();
	}
	
	@GetMapping("/status/{pnrNo}")
	@ApiOperation(value="Get status of your booking by Pnr Number")
	public String getStatus(@PathVariable long pnrNo)
	{
		return adminServiceImpl.pnrStatus(pnrNo);
	}
	
	@GetMapping("/trainNo/{trainNo}")
	@ApiOperation(value="Get train details by Train Number")
	public TrainDetails getDetailsByTrainNo(@PathVariable Integer trainNo) 
	{
		return adminServiceImpl.getDetailsByTrainNo(trainNo);
	}
	
	@GetMapping("/{startStation}/{destStation}")
	@ApiOperation(value="Get train details by giving start and final locations")
	public List<TrainDetails> getTrainDetailsByStartStation(@PathVariable String startStation,@PathVariable String destStation)
	{
		return adminServiceImpl.getTrainDetailsByStartStation(startStation,destStation);
	}
}