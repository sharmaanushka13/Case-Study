package com.example.PaymentService.entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "User_Details")
public class UserDetails 
{
	@Transient
	public static final String SEQUENCE_NAME = "users_sequence";
	
	@Id
	@NotNull
	private int id;
	
	@NotNull
	private long pnrNo;
	 
	@NotNull
	@Size(min=3,message="Name should be minimum of 3 characters")
	private String name;
	
	@NotNull
	@Max(value=99,message="Age cannot be more than 99")
	private int age;
	
	@NotNull
	@Size(max=6,message="Either male,female or other ")
	private String sex;
	
	@NotNull
	@Size(max=70,message="Address cannot exceed 70 characters..!!")
	private String address;
	
	@NotNull
	@Max(value=99999,message="Train number cannot exceed 5 digits")
	private int trainNo;
	
	@NotNull
	@Size(min=5,message="Train name should be minimum of 5 characters")
	private String trainName;
	
	@NotNull
	@Size(min=2,message="Start Station should be minimum of 2 characters")
	private String startStation;
	
	@NotNull
	@Size(min=2,message="Destination Station should be minimum of 2 characters")
	private String destStation;
	
	@NotNull
	@Size(min=2,message="Class type should be minimum of 2 characters")
	private String classType;
	
	private int adults;
	private int children;
	
	@NotNull
	private String payment;

	public UserDetails() {
		super();
	}

	public UserDetails(@NotNull int id, @NotNull long pnrNo,
			@NotNull @Size(min = 3, message = "Name should be minimum of 3 characters") String name,
			@NotNull @Max(value = 99, message = "Age cannot be more than 99") int age,
			@NotNull @Size(max = 6, message = "Either male,female or other ") String sex,
			@NotNull @Size(max = 70, message = "Address cannot exceed 70 characters..!!") String address,
			@NotNull @Max(value = 99999, message = "Train number cannot exceed 5 digits") int trainNo,
			@NotNull @Size(min = 5, message = "Train name should be minimum of 5 characters") String trainName,
			@NotNull @Size(min = 2, message = "Start Station should be minimum of 2 characters") String startStation,
			@NotNull @Size(min = 2, message = "Destination Station should be minimum of 2 characters") String destStation,
			@NotNull @Size(min = 2, message = "Class type should be minimum of 2 characters") String classType,
			int adults, int children, @NotNull String payment) {
		super();
		this.id = id;
		this.pnrNo = pnrNo;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.trainNo = trainNo;
		this.trainName = trainName;
		this.startStation = startStation;
		this.destStation = destStation;
		this.classType = classType;
		this.adults = adults;
		this.children = children;
		this.payment = payment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getPnrNo() {
		return pnrNo;
	}

	public void setPnrNo(long pnrNo) {
		this.pnrNo = pnrNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getClassType() {
		return classType;
	}

	public void setClassType(String classType) {
		this.classType = classType;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", pnrNo=" + pnrNo + ", name=" + name + ", age=" + age + ", sex=" + sex
				+ ", address=" + address + ", trainNo=" + trainNo + ", trainName=" + trainName + ", startStation="
				+ startStation + ", destStation=" + destStation + ", classType=" + classType + ", adults=" + adults
				+ ", children=" + children + ", payment=" + payment + "]";
	}
	
	
}