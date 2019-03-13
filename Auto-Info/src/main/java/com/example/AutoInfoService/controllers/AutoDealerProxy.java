package com.example.AutoInfoService.controllers;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.AutoInfoService.models.DealerModel;

@FeignClient(name="Auto-Dealer")
@RibbonClient(name="Auto-Dealer")

//This is using zuul api geteway
//@FeignClient(name="Auto-zuul-api-gateway-server")
//@RibbonClient(name="Auto-Dealer")
public interface AutoDealerProxy {
	
	@RequestMapping(value="/cars/dealers", method=RequestMethod.GET)
	//@GetMapping(value="/cars/dealers")
	public List<DealerModel> getAllDealers();

}
