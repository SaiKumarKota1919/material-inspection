package com.zm.mi.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zm.mi.entity.InspectionActuals;
import com.zm.mi.entity.MaterialCharacteristics;
import com.zm.mi.model.ActualsAndExpected;
import com.zm.mi.repo.InspectionActualsRepo;
import com.zm.mi.service.InspectionActualsService;
@Service
public class InspectionActualsServiceImpl implements InspectionActualsService {
@Autowired
private InspectionActualsRepo inspectionActualsRepo;
	@Override
	public void addActuals(InspectionActuals inspectionActuals) {
		
		
		inspectionActualsRepo.save(inspectionActuals);
		
	}
	@Override
	public List<InspectionActuals> getAllByLotId(Integer lotId) {
		
		return inspectionActualsRepo.findAllByLotId(lotId);
	}
	@Override
	public List<InspectionActuals> getAllByInspectionId(List<MaterialCharacteristics> list) {
		List<Integer> characterIds = null;
		if(list!=null)
		{
			characterIds = list.stream().map(l->l.getCharacterId()).toList();
		}
		
		
		return inspectionActualsRepo.findAllByMaterialCharacteristics(characterIds);
	}
	
	
	@Override
	public List<ActualsAndExpected> getActualsAndExpected(List<MaterialCharacteristics> list,
			List<InspectionActuals> inspectionActuals) {
			
		List<ActualsAndExpected> actualsAndExpectedList = new ArrayList<>();
		List<MaterialCharacteristics> materialCharacteristics = list;
		List<Integer> characterIds = inspectionActuals.stream().map(l->l.getMaterialCharacteristics()
																.getCharacterId()).toList();
		
		for(int i=0;i<materialCharacteristics.size();i++)
		{
			for(int j=0;j<characterIds.size();j++)
			{
				if(materialCharacteristics.get(i).getCharacterId()==characterIds.get(j))
				{
					actualsAndExpectedList.add(new ActualsAndExpected(materialCharacteristics.get(i).getMaterial().getMaterialId(), 
																	materialCharacteristics.get(i).getMaterial().getMaterialDesc(),
																	materialCharacteristics.get(i).getMaterial().getMaterialType(),
																	materialCharacteristics.get(i).getCharacterId(),
																		materialCharacteristics.get(i).getCharacterDesc(),
																		materialCharacteristics.get(i).getUpperTolLimit(),
																		materialCharacteristics.get(i).getLowerTolLimit(),
																		materialCharacteristics.get(i).getUnitsOfMsrmnt(),
																			inspectionActuals.get(i).getMaxMeasurement(),
																			inspectionActuals.get(i).getMinMeasurement()));

					
					//materialCharacteristics.remove(i);
				}
			
				
			}
			
		}
		
		
		
		return actualsAndExpectedList;
	}

}