package com.zm.mi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.mi.entity.Vendor;
import com.zm.mi.repo.VendorRepo;
import com.zm.mi.service.VendorService;
import com.zm.mi.utils.StringDataUtils;

@Service
public class VendorServiceImpl implements VendorService {
@Autowired
private VendorRepo vendorRepo;
	
	@Override
	public boolean isAlreadyExists(Vendor vendor) {
			
		vendor.setVendorName(StringDataUtils.normlaizeString(vendor.getVendorName().toLowerCase()));
		
		
		if(vendorRepo.findByVendorName(vendor.getVendorName())!=null)
		{
			return true;
		}
		return false;
	}

	@Override
	public void addVendor(Vendor vendor) {
		
		vendor.setVendorLocation(StringDataUtils.normlaizeString(vendor.getVendorLocation().toLowerCase()));
		vendor.setVendorName(StringDataUtils.normlaizeString(vendor.getVendorName()).toLowerCase());
		vendorRepo.save(vendor);
		
	}

	@Override
	public List<Vendor> getAllVendors() {
		
		return vendorRepo.findAll();
	}

	@Override
	public Vendor getVendorById(Integer vendorId) {
		Optional<Vendor> vendorOptional = vendorRepo.findById(vendorId);
		
		if(vendorOptional.isPresent())
		{
			return vendorOptional.get();
		}

		return null;
	}

}
