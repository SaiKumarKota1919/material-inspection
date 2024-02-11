package com.zm.mi.service;

import java.util.List;

import com.zm.mi.entity.InspectionActuals;
import com.zm.mi.entity.InspectionLot;
import com.zm.mi.entity.MaterialCharacteristics;
import com.zm.mi.model.ActualsAndExpected;

public interface InspectionActualsService {

	 void addActuals(InspectionActuals inspectionActuals);

	List<InspectionActuals> getAllByLotId(Integer lotId);

	
	List<InspectionActuals> getAllByInspectionId(List<MaterialCharacteristics> list);

	

	List<ActualsAndExpected> getActualsAndExpected(List<MaterialCharacteristics> list,
			List<InspectionActuals> inspectionActuals);

	//List<ActualsAndExpected> getActualsAndExpected(List<MaterialCharacteristics> list,
		//	List<InspectionActuals> inspectionActuals);
}
