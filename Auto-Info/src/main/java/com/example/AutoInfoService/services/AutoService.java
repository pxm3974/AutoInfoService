package com.example.AutoInfoService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AutoInfoService.controllers.AutoDetailProxy;
import com.example.AutoInfoService.models.DetailModel;

@Service
public class AutoService {
	
	@Autowired
	AutoDetailProxy detailProxy;
	
	List<DetailModel> list;
	
	public List<DetailModel> getAllCars()
	{
		return detailProxy.getAllAutoDetail();
	}

}
