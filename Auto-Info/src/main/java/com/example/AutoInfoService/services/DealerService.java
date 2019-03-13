package com.example.AutoInfoService.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AutoInfoService.controllers.AutoDealerProxy;
import com.example.AutoInfoService.models.DealerModel;

@Service
public class DealerService {

	@Autowired
	AutoDealerProxy dealerProxy;
	
	List<DealerModel> list;
	
	public List<DealerModel> getAllDealers()
	{
		return dealerProxy.getAllDealers();
	}
}

