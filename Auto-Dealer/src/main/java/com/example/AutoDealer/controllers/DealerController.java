package com.example.AutoDealer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoDealer.models.DealerInventory;
import com.example.AutoDealer.models.DealerModel;
import com.example.AutoDealer.services.DealerService;

@RestController
public class DealerController {
	
	@Autowired
	DealerService dealerService;
	
	@RequestMapping(value="/cars/dealers", method=RequestMethod.GET)
	public List<DealerModel> getAllDealers()
	{
		return dealerService.getAllDealers();
	}
	
	@RequestMapping(value="/cars/dealers/{dealerName}", method=RequestMethod.GET)
	public DealerModel getDealer(@PathVariable("dealerName") String dealerName)
	{
		return dealerService.getDealer(dealerName);
	}
	
	@RequestMapping(value="/cars/dealers/inventory/{dealerName}", method=RequestMethod.GET)
	public List<DealerInventory> getInventory(@PathVariable("dealerName") String dealerName)
	{
		return dealerService.getDealersInventory(dealerName);
	}
	
	@RequestMapping(value="/cars/dealers/inventory/post", method=RequestMethod.POST)
	public ResponseEntity<DealerInventory> addInventory(@RequestBody DealerInventory invent)
	{
		boolean result=dealerService.addInventory(invent);
		if(result)
		{
			return new ResponseEntity<DealerInventory>(invent, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<DealerInventory>(invent, HttpStatus.EXPECTATION_FAILED);
		}
			
	}
	
	@RequestMapping(value="/cars/dealers/inventory/delete", method=RequestMethod.DELETE)
	public String deleteInventory(@RequestBody DealerInventory invent)
	{
		boolean result=dealerService.deleteInventory(invent);
		if(result)
		{
			return "Sucessfully deleted";
		}
		else { return "failed to delete";}
	}

}
