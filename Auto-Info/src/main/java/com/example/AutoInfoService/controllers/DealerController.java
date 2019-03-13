package com.example.AutoInfoService.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.AutoInfoService.models.DealerModel;
import com.example.AutoInfoService.services.DealerService;

@RestController
public class DealerController {

	@Autowired
	DealerService dealerService;
	
	@RequestMapping(value="/autoinfo/dealers", method=RequestMethod.GET)
	public List<DealerModel> getAllDealers()
	{
		return dealerService.getAllDealers();
	}
}

