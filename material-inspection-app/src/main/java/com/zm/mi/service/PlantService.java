package com.zm.mi.service;

import java.util.List;

import com.zm.mi.entity.Plant;

public interface PlantService {

	boolean isAlreadyExists(Plant plant);

	void savePlant(Plant plant);

	List<Plant> getAllPlants();

	Plant getPlantById(String plantId);

}
