package com.zm.mi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.mi.entity.Plant;
import com.zm.mi.repo.PlantRepo;
import com.zm.mi.service.PlantService;
import com.zm.mi.utils.StringDataUtils;

@Service
public class PlantServiceImpl implements PlantService {
@Autowired
private PlantRepo plantRepo;
	@Override
	public boolean isAlreadyExists(Plant plant) {
		if(plantRepo.findById(plant.getPlantId()).isPresent())
		{
			return true;
		}
		
		return false;
	}
	@Override
	public void savePlant(Plant plant) {
		
	 plant.setPlantCity(StringDataUtils.normlaizeString(plant.getPlantCity()).toLowerCase());
	 plant.setPlantName(StringDataUtils.normlaizeString(plant.getPlantName()).toLowerCase());
	 plant.setPlantId(StringDataUtils.normlaizeString(plant.getPlantId()).toUpperCase());
	 plant.setPlantState(StringDataUtils.normlaizeString(plant.getPlantState()).toLowerCase());
		
		plantRepo.save(plant);
		
	}
	@Override
	public List<Plant> getAllPlants() {
		
		return plantRepo.findAll();
	}
	@Override
	public Plant getPlantById(String plantId) {
		
		Optional<Plant> plantOptional = plantRepo.findById(plantId);
		if (plantOptional.isPresent()) {
			
			return plantOptional.get();
		}
		
		return null;
	}

}
