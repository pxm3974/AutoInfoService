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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.*;

@RestController
@Api("Dealer Management Controller")
public class DealerController {
	
	@Autowired
	DealerService dealerService;
	
	@ApiOperation(value="view list of dealers and their inventory, response=List.class")
	
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrieved list"),
			@ApiResponse(code=401, message="You are not authorized to view the resource"),
			@ApiResponse(code=403, message="Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code=404, message="The resource you were trying to reach is not found")
	})
	
	@RequestMapping(value="/cars/dealers", method=RequestMethod.GET)
	public List<DealerModel> getAllDealers()
	{
		return dealerService.getAllDealers();
	}
	
	@ApiOperation(value="Search a dealer info with dealer Name", response=DealerModel.class)
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
