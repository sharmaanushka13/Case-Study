package com.example.UserService.entity;
import javax.validation.constraints.Max;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Train Details")
public class TrainDetails 
{
	@Id
	@NotNull(message="Train number cannot be null")
	@Max(value=99999,message="Train number cannot exceed 5 digits")
	private int trainNo;
	
	@NotNull
	@Size(min=5,message="Train name should be minimum of 5 characters")
	private String trainName;
	
	@NotNull
	@Size(min=2,message="Start Station should be minimum of 2 characters")
	private String startStation;
	
	@NotNull
	private String destStation;
	
	@NotNull
	private String arrivalTime;
	
	@NotNull
	@Size(max=7,message="Departure Time should be maximum of 7 characters")
	private String deptTime;
	private String duration;
	private int noOfSeats;
	
	private int firstClassACFare;
	private int twoTierAcFare;
	private int threeTierAcFare;
	private int sleeperFare;
	
	public TrainDetails() {
		super();
	}

	public TrainDetails(
			@NotNull(message = "Train number cannot be null") @Max(value = 99999, message = "Train number cannot exceed 5 digits") int trainNo,
			@NotNull @Size(min = 5, message = "Train name should be minimum of 5 characters") String trainName,
			@NotNull @Size(min = 2, message = "Start Station should be minimum of 2 characters") String startStation,
			@NotNull String destStation, @NotNull String arrivalTime,
			@NotNull @Size(max = 7, message = "Departure Time should be maximum of 7 characters") String deptTime,
			String duration, int noOfSeats, int firstClassACFare, int twoTierAcFare, int threeTierAcFare,
			int sleeperFare) {
		super();
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.startStation = startStation;
		this.destStation = destStation;
		this.arrivalTime = arrivalTime;
		this.deptTime = deptTime;
		this.duration = duration;
		this.noOfSeats = noOfSeats;
		this.firstClassACFare = firstClassACFare;
		this.twoTierAcFare = twoTierAcFare;
		this.threeTierAcFare = threeTierAcFare;
		this.sleeperFare = sleeperFare;
	}

	public int getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(int trainNo) {
		this.trainNo = trainNo;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getStartStation() {
		return startStation;
	}

	public void setStartStation(String startStation) {
		this.startStation = startStation;
	}

	public String getDestStation() {
		return destStation;
	}

	public void setDestStation(String destStation) {
		this.destStation = destStation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getFirstClassACFare() {
		return firstClassACFare;
	}

	public void setFirstClassACFare(int firstClassACFare) {
		this.firstClassACFare = firstClassACFare;
	}

	public int getTwoTierAcFare() {
		return twoTierAcFare;
	}

	public void setTwoTierAcFare(int twoTierAcFare) {
		this.twoTierAcFare = twoTierAcFare;
	}

	public int getThreeTierAcFare() {
		return threeTierAcFare;
	}

	public void setThreeTierAcFare(int threeTierAcFare) {
		this.threeTierAcFare = threeTierAcFare;
	}

	public int getSleeperFare() {
		return sleeperFare;
	}

	public void setSleeperFare(int sleeperFare) {
		this.sleeperFare = sleeperFare;
	}

	@Override
	public String toString() {
		return "TrainDetails [trainNo=" + trainNo + ", trainName=" + trainName + ", startStation=" + startStation
				+ ", destStation=" + destStation + ", arrivalTime=" + arrivalTime + ", deptTime=" + deptTime
				+ ", duration=" + duration + ", noOfSeats=" + noOfSeats + ", firstClassACFare=" + firstClassACFare
				+ ", twoTierAcFare=" + twoTierAcFare + ", threeTierAcFare=" + threeTierAcFare + ", sleeperFare="
				+ sleeperFare + "]";
	}
	
	
	

	
	
}