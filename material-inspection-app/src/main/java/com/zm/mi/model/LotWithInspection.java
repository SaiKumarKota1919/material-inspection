package com.zm.mi.model;

import java.time.LocalDate;

import com.zm.mi.entity.Material;
import com.zm.mi.entity.Plant;
import com.zm.mi.entity.User;
import com.zm.mi.entity.Vendor;

public class LotWithInspection {
	
	private Integer lotId;
	private Material material;
	private Vendor vendor;
	private Plant plant;
	private User user;
	private LocalDate createdOn;
	private LocalDate startDate;
	private LocalDate endDate;
	private String result;
	private String remarks;

}
