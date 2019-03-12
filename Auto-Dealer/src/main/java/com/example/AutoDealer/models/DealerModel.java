package com.example.AutoDealer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="first")
public class DealerModel {

	@Id
	@GeneratedValue
	private Long id;
	
	private String dealerName;
	private String dealerOf;
	private String location;
	private String phoneNumber;
	private String email;
	
	
	public DealerModel() {}

	public DealerModel(String dealerName, String dealerOf, String location, String phoneNumber, String email) {
		super();
		
		this.dealerName = dealerName;
		this.dealerOf = dealerOf;
		this.location = location;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDealerName() {
		return dealerName;
	}

	public void setDealerName(String dealerName) {
		this.dealerName = dealerName;
	}

	public String getDealerOf() {
		return dealerOf;
	}

	public void setDealerOf(String dealerOf) {
		this.dealerOf = dealerOf;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
