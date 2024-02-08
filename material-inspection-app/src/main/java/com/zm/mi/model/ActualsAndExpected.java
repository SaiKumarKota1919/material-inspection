package com.zm.mi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActualsAndExpected {
	
	private String materialId;
	private String materialDesc;
	private String materialType;
	private Integer characterId;
	private String  characterDesc;
	private Float upperTolLimit;
	private Float lowerTolLimit;
	private String unitsOfMsrmnt;
	private Float maxMeasurement;
	private Float minMeasurement;
	
	public ActualsAndExpected(String materialId, String materialDesc, String materialType, Integer characterId,
			String characterDesc, Float upperTolLimit, Float lowerTolLimit, String unitsOfMsrmnt, Float maxMeasurement,
			Float minMeasurement) {
		super();
		this.materialId = materialId;
		this.materialDesc = materialDesc;
		this.materialType = materialType;
		this.characterId = characterId;
		this.characterDesc = characterDesc;
		this.upperTolLimit = upperTolLimit;
		this.lowerTolLimit = lowerTolLimit;
		this.unitsOfMsrmnt = unitsOfMsrmnt;
		this.maxMeasurement = maxMeasurement;
		this.minMeasurement = minMeasurement;
	}
	

}