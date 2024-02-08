package com.zm.mi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.InspectionActuals;
import com.zm.mi.entity.InspectionLot;
import com.zm.mi.entity.Material;
import com.zm.mi.entity.MaterialCharacteristics;
import com.zm.mi.model.ActualsAndExpected;
import com.zm.mi.service.InspectionActualsService;
import com.zm.mi.service.LotService;
import com.zm.mi.service.MaterialService;

@Controller
@RequestMapping("/inspection")
public class InspectionActualsController {
	@Autowired
	private InspectionActualsService inspectionActualsService;
	@Autowired
	private LotService lotService;
	@Autowired
	private MaterialService materialService;

	@PostMapping("/add")
	public String addInspection(@ModelAttribute InspectionActuals inspectionActuals) {

		inspectionActualsService.addActuals(inspectionActuals);

		return ViewPageConstants.REDIRECT_TO_SHOW_LOTS_PAGE;
	}

	@GetMapping("/add/form/{lotId}")
	public String getAddForm(@PathVariable Integer lotId, Model model) {
		InspectionLot inspectionLot = lotService.getLotById(lotId);
		model.addAttribute("lotId", lotId);
		
		List<MaterialCharacteristics> materialCharacteristics = inspectionLot.getMaterial()
				.getMaterialCharacteristics();

		
		List<MaterialCharacteristics> list = inspectionActualsService.getAllByLotId(lotId).stream()
												.map(i->i.getMaterialCharacteristics())
												.toList();
		
		materialCharacteristics.removeAll(list);
		
		model.addAttribute("materialCharacters",materialCharacteristics);
		
		return ViewPageConstants.ADD_ACTUALS_FORM_PAGE;
	}
	
	@GetMapping("/actuals/{materialId}")
	public String viewActualsByMaterialId(@PathVariable String materialId,Model model)
	{
		Material material = materialService.getMaterialById(materialId);
		
		List<MaterialCharacteristics> list =material.getMaterialCharacteristics();
		
		  List<InspectionActuals> inspectionActuals= inspectionActualsService.getAllByInspectionId(list);
		
	     List<ActualsAndExpected> actualsAndExpectedList =	 inspectionActualsService.getActualsAndExpected(list,inspectionActuals);
	     
	     model.addAttribute("actualsAndExpectedList",actualsAndExpectedList);
	     
	     model.addAttribute("material",material);
	     
		return ViewPageConstants.SHOW_ACTUALS_PAGE;
	}

}