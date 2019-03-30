package com.example.AutoDealer.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AutoDealer.models.DealerModel;

@Repository
//@Qualifier("DealerRepository")
public interface DealerRepository extends JpaRepository<DealerModel, Long> {
	
	DealerModel findByDealerName(String dealerName);

}
