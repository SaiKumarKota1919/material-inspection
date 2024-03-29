package com.zm.mi.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.InspectionLot;
import com.zm.mi.entity.Material;
import com.zm.mi.entity.Plant;
import com.zm.mi.entity.Vendor;
import com.zm.mi.model.ActualsAndExpected;
import com.zm.mi.serachcriteria.LotSearchCriteria;
import com.zm.mi.service.InspectionActualsService;
import com.zm.mi.service.LotService;
import com.zm.mi.service.MaterialService;
import com.zm.mi.service.PlantService;
import com.zm.mi.service.UserService;
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
	@Autowired
	private UserService userService;
	
	
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
	private String searchLot(@ModelAttribute LotSearchCriteria lotSearchCriteria,HttpSession session,
								Model model)
	{
		
		
		
		
		if(lotSearchCriteria.getFromDate()!=null || lotSearchCriteria.getLotId() !=null)
		{
			if(lotSearchCriteria.getFromDate()!=null && lotSearchCriteria.getToDate()!=null)
			{
				if(!lotService.isValidDateRange(lotSearchCriteria))
				{
					model.addAttribute("InvalidDateRange","Date range should not be more than 90 days");
					
					return ViewPageConstants.SEARCH_LOT_BY_RANGE;
					
				}
				
			}
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
	
	@GetMapping("/result/{lotId}")
	public String getLotResult(@PathVariable Integer lotId,Model model)
	{
		InspectionLot inspectionLot = lotService.getLotById(lotId);
		
		List<ActualsAndExpected> actualsAndExpectedList = inspectionActualsService.getActualsAndExpected(inspectionLot.getMaterial()
									.getMaterialCharacteristics(), 
									inspectionLot.getInspectionActuals());
		
		model.addAttribute("inspectionLot",inspectionLot);
		model.addAttribute("material", inspectionLot.getMaterial());
		
		return ViewPageConstants.SHOW_RESULT_PAGE;
	}
	@PostMapping("/edit/{lotId}")
	public String editResult(@PathVariable Integer lotId,
							@RequestParam Integer userId,
							@RequestParam String remarks,
							@RequestParam String result)
	
	{
		
		
		InspectionLot lot = lotService.getLotById(lotId);
		lot.setUser(userService.getUserById(userId));
		lot.setRemarks(remarks);
		lot.setResult(result);
		
		lotService.addLot(lot);
		
		
		
		return ViewPageConstants.REDIRECT_SHOW_RESULT_PAGE+"/"+lotId;
	}

}
