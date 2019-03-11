package com.example.AutoDetail.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class AutoDetailModel {

	@Id
	@GeneratedValue
	private long id;
	
	@NotNull
	@NotEmpty
	private String make;
	private String model;
	private String modelNumber;
	private int year;
	private String carDescription;
	
	public AutoDetailModel() {}

	public AutoDetailModel(String make, String model, String modelNumber, int year, String carDescription) {
		super();
		this.make = make;
		this.model = model;
		this.modelNumber=modelNumber;
		this.year = year;
		this.carDescription = carDescription;
	}
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	
	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCarDescription() {
		return carDescription;
	}

	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}


}
