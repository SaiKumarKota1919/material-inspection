package com.zm.mi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.InspectionLot;
import com.zm.mi.entity.Material;
import com.zm.mi.entity.Plant;
import com.zm.mi.entity.Vendor;
import com.zm.mi.serachcriteria.LotSearchCriteria;
import com.zm.mi.service.InspectionActualsService;
import com.zm.mi.service.LotService;
import com.zm.mi.service.MaterialService;
import com.zm.mi.service.PlantService;
import com.zm.mi.service.VendorService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/lot")
public class LotController {
	@Autowired
	private LotService lotService;
	@Autowired
	private PlantService plantService;
	@Autowired
	private VendorService vendorService;
	@Autowired
	private MaterialService materialService;
	@Autowired
	private InspectionActualsService inspectionActualsService;
	
	
	@GetMapping("/form")
	private String getLotForm(Model model)
	{
		model.addAttribute("plants",plantService.getAllPlants());
		model.addAttribute("vendors",vendorService.getAllVendors());
		model.addAttribute("materials",materialService.getAllMaterials());
		
		return ViewPageConstants.CREATE_LOT_FORM_PAGE;
	}
	
	
	@PostMapping("/add")
	private String createLot(@ModelAttribute InspectionLot inspectionLot)
	{
		
	System.out.println(inspectionLot);
		lotService.addLot(inspectionLot);
		
		return ViewPageConstants.HOME_PAGE;
	}
	
	@GetMapping("/search")
	private String searchLot(@ModelAttribute LotSearchCriteria lotSearchCriteria,HttpSession session)
	{
		
		if(lotSearchCriteria.getFromDate()!=null)
		{
		
		 List<InspectionLot> lots = lotService.getLotsByLotSearchCriteria(lotSearchCriteria);
		 session.setAttribute("lotSearchCriteria", lotSearchCriteria);
		 session.setAttribute("lots", lots);
		 session.setAttribute("inspectionActualsService", inspectionActualsService);
		}else {
			
			
			List<InspectionLot> lots = lotService.getLotsByLotSearchCriteria((LotSearchCriteria)session.getAttribute("lotSearchCriteria"));
			 session.setAttribute("lots", lots);
		}
		
		return ViewPageConstants.SHOW_LOTS_PAGE;
	}
	
	

}