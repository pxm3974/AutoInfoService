package com.example.AutoDealer.controllers;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AutoDealer.models.DealerInventory;


@Repository
public interface InventoryRepository extends JpaRepository<DealerInventory, Long>{

	List<DealerInventory> findByDealerName(String dealerName);
}
