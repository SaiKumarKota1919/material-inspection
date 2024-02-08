package com.zm.mi.service;

import java.util.List;

import com.zm.mi.entity.Vendor;

public interface VendorService {

	boolean isAlreadyExists(Vendor vendor);

	void addVendor(Vendor vendor);

	List<Vendor> getAllVendors();

	Vendor getVendorById(Integer vendorId);

}
