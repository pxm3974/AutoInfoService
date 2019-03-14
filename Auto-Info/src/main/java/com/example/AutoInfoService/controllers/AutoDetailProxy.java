package com.example.AutoInfoService.controllers;

import java.util.List;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.AutoInfoService.models.DetailModel;


/**
 * 
 * @author pranilmaharjan
 *
 */
/*This is using Ribbon and Eureka naming servr */
//@FeignClient(name="Auto-Detail")
//@RibbonClient(name="Auto-Detail")

/*
 * This is using zuul api geteway, dont forget to have proper url with application name*/

@FeignClient(name="Auto-zuul-api-gateway-server", configuration=FeignClientConfiguration.class)
@RibbonClient(name="Auto-Detail")
public interface AutoDetailProxy {
	
	//@GetMapping(value="/cars")
	@GetMapping(value="/auto-detail/cars")
	public List<DetailModel> getAllAutoDetail();

}
