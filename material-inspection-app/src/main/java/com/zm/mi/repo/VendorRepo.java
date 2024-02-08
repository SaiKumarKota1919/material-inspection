package com.zm.mi.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zm.mi.entity.Vendor;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Serializable> {

	Vendor findByVendorName(String vendorName);

}
