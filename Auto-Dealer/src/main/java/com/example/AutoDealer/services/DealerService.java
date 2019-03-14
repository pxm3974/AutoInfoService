package com.example.AutoDealer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AutoDealer.models.DealerInventory;
import com.example.AutoDealer.models.DealerModel;

@Service
public class DealerService {
	
	@Autowired
	DealerRepository dealerRepo;
	
	@Autowired
	InventoryRepository inventoryRepo;
	
	List<DealerModel> list;
	
	// get all the dealers
	public List<DealerModel> getAllDealers()
	{
		return dealerRepo.findAll();
	}
	
	// get the particular dealers
	public DealerModel getDealer(String dealerName)
	{
		return dealerRepo.findByDealerName(dealerName);
	}

	// get the general dealers Inventory
	public List<DealerInventory> getDealersInventory(String dealerName)
	{
		return inventoryRepo.findByDealerName(dealerName);
	}
	
	// add the inventory 
	public boolean addInventory(DealerInventory invent)
	{
		try {
			inventoryRepo.save(invent);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	//delete the inventory
	public boolean deleteInventory(DealerInventory invent)
	{
		try {inventoryRepo.delete(invent);}
		catch(Exception e) {return false;}
		return true;
	}
}
