package com.example.AutoDetail;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import com.example.AutoDetail.controllers.AutoDetailRepository;
import com.example.AutoDetail.models.AutoDetailModel;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient

public class AutoDetailApplication {

	@Autowired
	AutoDetailRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(AutoDetailApplication.class, args);
	}
	
	@Bean
	InitializingBean iniBean()
	{
		return ()-> {
			repository.save(new AutoDetailModel("Toyota", "Camry", "T2001",2018 , "SE luxury AWD"));
			repository.save(new AutoDetailModel("Ford"," Fusion", "F2001", 2016 , "Hybrid "));
			repository.save(new AutoDetailModel("Toyota", "RAV4","T2002", 2012, "xl basix"));
			repository.save(new AutoDetailModel("Jeep", "Wrangler","J2001", 2015, "Road Runner"));
		};
	}

}
