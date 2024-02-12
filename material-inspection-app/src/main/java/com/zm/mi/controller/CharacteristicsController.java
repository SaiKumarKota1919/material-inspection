package com.zm.mi.controller;


import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.Material;
import com.zm.mi.entity.MaterialCharacteristics;
import com.zm.mi.model.MaterialCharacteristicsForm;
import com.zm.mi.service.CharacteristicsService;
import com.zm.mi.service.MaterialService;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/characteristics")
public class CharacteristicsController {
	@Autowired
	private MaterialService materialService;
	@Autowired
	private CharacteristicsService characteristicsService;

    // Display the form
    @GetMapping("/form/{materialId}")
    public String characteristicsForm(@PathVariable("materialId") String materialId,
    		Model model) {
    	
       model.addAttribute("mat",materialService.getMaterialById(materialId));
        MaterialCharacteristicsForm form = new MaterialCharacteristicsForm();
        form.setCharacteristicsList(new ArrayList<>());

      
        model.addAttribute("characteristicsForm", form);

        return ViewPageConstants.ADD_CHARACTER_PAGE;
    }

    
    @PostMapping("/add")
    public String addCharacteristics(
            @ModelAttribute("characteristicsForm") MaterialCharacteristicsForm characteristicsForm,
            Model model,RedirectAttributes redirectAttributes,HttpSession session,@RequestParam String materialId)
    
    {
        List<MaterialCharacteristics> characteristicsList = characteristicsForm.getCharacteristicsList();
        redirectAttributes.addFlashAttribute("material", session.getAttribute("materialSearchCriteria"));
      
        for(MaterialCharacteristics materialCharacteristics : characteristicsList)
        {
        	
        	materialCharacteristics.setMaterial(materialService.getMaterialById(materialId));
        	
        }
        characteristicsService.addAllCharacteristics(characteristicsList);
        
        return ViewPageConstants.REDIRECT_SHOW_MATERIAL; 
    }
    
    @GetMapping("/edit/{characterId}")
    public String editCharacter(@PathVariable Integer characterId,Model model)
    {
    	
    	MaterialCharacteristics materialCharacteristics = characteristicsService.getCharacterByid(characterId);
    	model.addAttribute("character",materialCharacteristics);
    	
    	return ViewPageConstants.EDIT_CHARACTER;
    }
    
    @PostMapping("/update")
    public String updateCharacter(@ModelAttribute MaterialCharacteristics materialCharacteristics,
    		@RequestParam String materialId)
    {
    
    	materialCharacteristics.setMaterial(materialService.getMaterialById(materialId));
    	characteristicsService.updateCharacter(materialCharacteristics);
    	
    	return ViewPageConstants.REDIRECT_SHOW_CHARACTERISTICS+"/"+materialId;
    }
    
    @GetMapping("/delete")
    public String deleteCharacter(@RequestParam Integer characterId,@RequestParam String materialId)
    
    {
    
    	characteristicsService.deleteCharacterById(characterId);
    	
    	return ViewPageConstants.REDIRECT_SHOW_CHARACTERISTICS+"/"+materialId; 
    	
    }
}
