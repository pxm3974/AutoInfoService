package com.example.AutoDetail.controllers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AutoDetail.models.AutoDetailModel;

@Repository
public interface AutoDetailRepository  extends JpaRepository <AutoDetailModel, String>
{
	List<AutoDetailModel> findByMake(String make);
	
	AutoDetailModel findByModelNumber(String modelNumber);
	
	//AutoDetailModel findById(Long id);
	
	
}
