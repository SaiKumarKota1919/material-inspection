package com.zm.mi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.mi.constants.ViewPageConstants;
import com.zm.mi.entity.Vendor;
import com.zm.mi.service.VendorService;

@Controller
@RequestMapping("/vendor")
public class VendorController {
@Autowired
private VendorService vendorService;

@PostMapping("/add")
private String addVendor(@ModelAttribute Vendor vendor,Model model)
{
	if(vendorService.isAlreadyExists(vendor))
	{
		model.addAttribute("vendorAlreadyExists","vendor already exists");
		
		return ViewPageConstants.ADD_VENDOR_PAGE;
	}
	else {
		vendorService.addVendor(vendor);
	}
	return ViewPageConstants.HOME_PAGE; 
}
}
