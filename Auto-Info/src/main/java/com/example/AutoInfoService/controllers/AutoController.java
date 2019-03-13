package com.example.AutoInfoService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoInfoService.models.DetailModel;
import com.example.AutoInfoService.services.AutoService;

@RestController
public class AutoController {
	
	@Autowired
	AutoService autoService;
	
	@RequestMapping(value="/autoinfo/cars", method=RequestMethod.GET)
	public List<DetailModel> getAllCars()
	{
		return autoService.getAllCars();
	}

}
