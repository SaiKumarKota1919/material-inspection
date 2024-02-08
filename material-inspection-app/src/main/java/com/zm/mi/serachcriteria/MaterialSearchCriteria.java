package com.zm.mi.serachcriteria;

import com.zm.mi.entity.Material;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialSearchCriteria extends Material{

	private String materialId;
	private String materialDesc;
	private String materialType;
	
	
}