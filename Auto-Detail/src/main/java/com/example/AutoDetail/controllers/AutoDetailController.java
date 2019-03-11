package com.example.AutoDetail.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoDetail.models.AutoDetailModel;
import com.example.AutoDetail.services.AutoDetailService;

@RestController
public class AutoDetailController {
	
	@Autowired
	AutoDetailService autoDetailService;
	
	@RequestMapping(value="/cars", method=RequestMethod.GET)
	public List<AutoDetailModel>  retrieveAll( )
	{
			return autoDetailService.getAll();
	} 
	
	@RequestMapping(value="/cars/{make}", method=RequestMethod.GET, produces = {"application/hal+json"})
	public List<AutoDetailModel>  retrieveAllModel(@PathVariable("make") String make )
	{
			return autoDetailService.getAllMake(make);
	} 
	
	@PostMapping(value="/cars/post")
	public ResponseEntity<AutoDetailModel> add(@RequestBody AutoDetailModel model)
	{
		boolean result=autoDetailService.addMake(model);
		
		if(result)
		{
			return new ResponseEntity<AutoDetailModel>(model, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<AutoDetailModel>(model, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value="/cars/update", method=RequestMethod.PUT)
	public ResponseEntity<AutoDetailModel> update(@RequestBody AutoDetailModel model)
	{
		boolean result=autoDetailService.updateMake(model);
		if(result)
		{
			return new ResponseEntity<AutoDetailModel>(model, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<AutoDetailModel>(model, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@RequestMapping(value="/cars/delete/{modelNo}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("modelNo") String modelNo)
	{
		boolean result=autoDetailService.deleteMake(modelNo);
		
		if(result)
		{
			return "Successfully deleted";
		}
		else {
			return "Failure to delete";
		}
	}

}
