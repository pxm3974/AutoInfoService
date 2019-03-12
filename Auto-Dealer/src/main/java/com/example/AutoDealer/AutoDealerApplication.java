package com.example.AutoDealer;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import com.example.AutoDealer.controllers.DealerRepository;
import com.example.AutoDealer.controllers.InventoryRepository;
import com.example.AutoDealer.models.DealerInventory;
import com.example.AutoDealer.models.DealerModel;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
public class AutoDealerApplication {

	@Autowired
	DealerRepository repo;
	
	@Autowired
	InventoryRepository inventRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(AutoDealerApplication.class, args);
	}
	
	@Primary
	@Bean(name="first")
	InitializingBean iniBean()
	  { 
		  return ()->{
			  repo.save(new DealerModel("DavidMACDavid", "Toyota", "Irving", "6366679456","toyotaOfdallas@tyta.com"));
			  repo.save(new DealerModel("Rustic", "Ford", "Arlington", "9727467865","fordHenry@tyta.com"));
			  repo.save(new DealerModel("FamilyOfToyota", "Toyota", "Burleson", "234679456","toyotaArlington@tyta.com"));
			  
			  }; 
	}
	
	@Bean (name="second")
	InitializingBean initBean()
	{
		return ()->{
			inventRepo.save(new DealerInventory("DavidMACDavid", "T2001", 20000.56, 30));
			inventRepo.save(new DealerInventory("Rustic", "F2001", 20202.56, 50));
			inventRepo.save(new DealerInventory("FamilyOfToyota", "T2002", 40053.3, 8));
		};
	}

}
