package com.example.Autozuulapigatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class AutoZuulApiGatewayServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoZuulApiGatewayServerApplication.class, args);
	}

}
