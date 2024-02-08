package com.zm.mi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.Material;
import com.zm.mi.service.MaterialService;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/material")
public class MaterialController {
	@Autowired
	private MaterialService materialService;
	private static final Logger LOGGER = LoggerFactory.getLogger(MaterialController.class);
	
	
	

	@PostMapping("/add")
	public String addMaterial(@ModelAttribute Material material,HttpSession session,
			RedirectAttributes redirectAttributes)
	{
		LOGGER.info("**** Request recieved by "+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		if(materialService.isAlreadyExists(material))
		{
			LOGGER.info(" material already exists ");
			
			if(!material.equals(materialService.getMaterialById(material.getMaterialId())))
			{
				LOGGER.info("---updating material details---");
				materialService.saveMaterial(material);
				LOGGER.info("---material details updated---"); 
				redirectAttributes.addFlashAttribute("material", session.getAttribute("materialSearchCriteria")); 
				return ViewPageConstants.REDIRECT_SHOW_MATERIAL;
			}
			
			return ViewPageConstants.ADD_MATERIAL_PAGE;
		}
		else {
			materialService.saveMaterial(material);
			LOGGER.info(" material saved sucessfully ");
			
		}
		
		
		LOGGER.info("**** End of the method "+Thread.currentThread().getStackTrace()[1].getMethodName());
		
		return ViewPageConstants.HOME_PAGE;
	}
	
	@GetMapping("/search")
	public String searchMaterial(@ModelAttribute Material material,Model model,HttpSession session)
	{
		System.out.println( session.getAttribute("materialSearchCriteria"));
		if(session.getAttribute("materialSearchCriteria") != null && material.getMaterialId()==null) {
			material = (Material)session.getAttribute("materialSearchCriteria");
		}
		else {
			session.setAttribute("materialSearchCriteria", material);
		}
		LOGGER.info("**** Request recieved by "+Thread.currentThread().getStackTrace()[1].getMethodName());
		
	   List<Material> materials =	materialService.searchMaterial(material);
	   	session.setAttribute("materials", materials);
	   	LOGGER.info("**** End of the method "+Thread.currentThread().getStackTrace()[1].getMethodName());
		return ViewPageConstants.SHOW_MATERIALS_PAGE;
	}
	
	@GetMapping("/delete/{materialId}")
	private String deleteMaterial(@PathVariable String materialId,
			RedirectAttributes redirectAttributes,HttpSession session)
	{
		
		materialService.deleteMaterialById(materialId);
		redirectAttributes.addFlashAttribute("material",session.getAttribute("materialSearchCriteria"));
		
		return ViewPageConstants.REDIRECT_SHOW_MATERIAL;
	}
	
	
	@GetMapping("/edit/{materialId}")
	public String updateMaterial(@PathVariable String materialId,Model model)
	{
		Material material = materialService.getMaterialById(materialId);
		if(material!=null)
		{
			model.addAttribute("material", material);
		}
		
		return ViewPageConstants.ADD_MATERIAL_PAGE;
	}
	
	@GetMapping("/view/{materialId}")
	public String viewMaterial(@PathVariable String materialId,Model model)
	{
		model.addAttribute("material",materialService.getMaterialById(materialId));
		
		return ViewPageConstants.SHOW_CHARACTERISTICS;
		
	}
}