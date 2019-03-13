package com.example.AutoInfoService.controllers;

import java.util.List;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.AutoInfoService.models.DetailModel;

@FeignClient(name="Auto-Detail")
@RibbonClient(name="Auto-Detail")

//This is using zuul api geteway
//@FeignClient(name="Auto-zuul-api-gateway-server")
//@RibbonClient(name="Auto-Detail")
public interface AutoDetailProxy {
	
	@GetMapping(value="/cars")
	//@GetMapping(value="/Auto-Detail/cars")
	public List<DetailModel> getAllAutoDetail();

}
