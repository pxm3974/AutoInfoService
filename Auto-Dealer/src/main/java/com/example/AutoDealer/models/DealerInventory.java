package com.example.AutoDealer.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="second")
public class DealerInventory {
	
	@Id
	@GeneratedValue
	private Long id;
	private String dealerName;
	private String modelNumber;
	private double price;
	private int inventoryCount;
	//private DealerAutoDetailModel autoModel;
	
	public DealerInventory() {}
	
	public DealerInventory( String dealerName, String modelNumber, double price, int inventoryCount) {
		super();
		this.dealerName = dealerName;
		this.modelNumber = modelNumber;
		this.price = price;
		this.inventoryCount = inventoryCount;
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
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getInventoryCount() {
		return inventoryCount;
	}
	public void setInventoryCount(int inventoryCount) {
		this.inventoryCount = inventoryCount;
	}

}
