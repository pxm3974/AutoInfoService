package com.example.AutoDetail.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AutoDetail.controllers.AutoDetailRepository;
import com.example.AutoDetail.models.AutoDetailModel;

@Service
public class AutoDetailService {
	
	@Autowired
	AutoDetailRepository autoRepository;
	
	List<AutoDetailModel> list;
	
	AutoDetailModel autoModel;
	
	
	public List<AutoDetailModel>  getAll()
	{
		return autoRepository.findAll();
	}
	
	/* get all the detail info of a car given the car Make*/
	public List<AutoDetailModel> getAllMake(String make)
	{
		return autoRepository.findByMake(make);
	}
	
	/* add the new car info and description */
	public boolean addMake(AutoDetailModel model)
	{
		try
		{
			autoRepository.save(model);
		}
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean updateMake(AutoDetailModel model)
	{
		try
		{
			  autoModel=autoRepository.findByModelNumber(model.getModelNumber());
			  autoModel.setCarDescription(model.getCarDescription());
			  autoRepository.save(autoModel);
			 
			/*
			 * autoModel=autoRepository.findById(model.getId());
			 * autoModel.setCarDescription(model.getCarDescription());
			 * autoRepository.save(autoModel);
			 */
		}
		
		catch(Exception e)
		{
			return false;
		}
		return true;
	}
	
	public boolean deleteMake(String modelNumber)
	{
		
		try
		{
			autoModel=autoRepository.findByModelNumber(modelNumber);
			autoRepository.delete(autoModel);
		}
		
		catch (Exception e)
		{
			return false;
		}
		return true;
	}

}
