package com.example.AutoInfoService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.example.AutoInfoService.controllers")
@EnableAutoConfiguration
@EnableDiscoveryClient

public class AutoInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoInfoServiceApplication.class, args);
	}

}
