package com.example.AutoDealer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AutoDealer.models.DealerInventory;


@Repository
//@Qualifier("InventoryRepository")
public interface InventoryRepository extends JpaRepository<DealerInventory, Long>{

	List<DealerInventory> findByDealerName(String dealerName);
}
