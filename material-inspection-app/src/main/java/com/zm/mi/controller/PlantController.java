package com.zm.mi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.Plant;
import com.zm.mi.service.PlantService;

@Controller
@RequestMapping("/plant")
public class PlantController {
@Autowired
private PlantService plantService;
	@GetMapping("/get/all")
	public String getPlants(Model model)
	{
		
		return ViewPageConstants.HOME_PAGE;
	}
	@PostMapping("/add")
	public String addPlant(@ModelAttribute Plant plant,Model model)
	{
		if(plantService.isAlreadyExists(plant))
		{
			model.addAttribute("plantAlreadyExists","plant with id "+plant.getPlantId()+" is already exists");
			
			return ViewPageConstants.ADD_PLANT_PAGE;
		}
		else {
			System.out.println(plant);
			plantService.savePlant(plant);
		}
		
		return ViewPageConstants.HOME_PAGE;
	}
	
	public void savePlants()
	{
		
	}

}
